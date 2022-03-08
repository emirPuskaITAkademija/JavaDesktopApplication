package four.dao;

import four.connection.ConnectionPool;
import four.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements Dao<Customer> {
    @Override
    public void save(Customer entity) throws SQLException {

    }

    @Override
    public List<Customer> getAll() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers";
        Connection connection = ConnectionPool.getINSTANCE().getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getInt(1));
                customer.setFirstName(resultSet.getString(2));
                customer.setLastName(resultSet.getString(3));
                customer.setBirthdate(resultSet.getDate(4).toLocalDate());
                customer.setPhone(resultSet.getString(5));
                customer.setAddress(resultSet.getString(6));
                customer.setCity(resultSet.getString(7));
                customer.setState(resultSet.getString(8));
                customer.setPoints(resultSet.getInt(9));
                customers.add(customer);
            }
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
        return customers;
    }

    @Override
    public Customer get(Integer primaryKey) throws SQLException {
        return null;
    }

    @Override
    public void update(Customer entity) throws SQLException {

    }

    @Override
    public void delete(Customer entity) throws SQLException {

    }
}
