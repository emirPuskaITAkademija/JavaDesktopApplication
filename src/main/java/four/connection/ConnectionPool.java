package four.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private final static int MAX_CONNECTIONS = 10;

    private static ConnectionPool INSTANCE;

    public static ConnectionPool getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new ConnectionPool();
        }
        return INSTANCE;
    }

    private List<Connection> availableConnections = new ArrayList<>();
    private List<Connection> usedConnections = new ArrayList<>();

    private ConnectionPool(){
        for(int i = 0; i<MAX_CONNECTIONS; i++){
            Connection connection = createConnection();
            availableConnections.add(connection);
        }
    }


    private Connection createConnection(){
        try {
            String url = ConnectionProperties.URL.getValue();
            String username = ConnectionProperties.USERNAME.getValue();
            String password = ConnectionProperties.PASSWORD.getValue();
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }


    public Connection getConnection(){
        if(availableConnections.isEmpty()){
            throw new RuntimeException("Nema jarane dostupnih konekcija..");
        }
        Connection connection = availableConnections.get(availableConnections.size()-1);
        availableConnections.remove(connection);
        usedConnections.add(connection);
        return connection;
    }

    public boolean releaseConnection(Connection connection){
        if(null != connection){
            usedConnections.remove(connection);
            availableConnections.add(connection);
            return true;
        }
        return false;
    }
}
