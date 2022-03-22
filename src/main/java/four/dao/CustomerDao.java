package four.dao;

import four.connection.ConnectionPool;
import four.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements Dao<Customer> {
    @Override
    public void save(Customer entity)  {

    }

    @Override
    public List<Customer> getAll()  {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers";
        //1.
        Connection connection = ConnectionPool.getINSTANCE().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        ConnectionPool.getINSTANCE().releaseConnection(connection);
        return customers;
    }

    @Override
    public Customer get(Integer primaryKey)  {
        String sql = "SELECT * FROM customers WHERE customer_id=?";
        Connection connection = ConnectionPool.getINSTANCE().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, primaryKey);
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer = new Customer();
            while (resultSet.next()) {
                customer.setCustomerId(resultSet.getInt(1));
                customer.setFirstName(resultSet.getString(2));
                customer.setLastName(resultSet.getString(3));
                customer.setBirthdate(resultSet.getDate(4).toLocalDate());
                customer.setPhone(resultSet.getString(5));
                customer.setAddress(resultSet.getString(6));
                customer.setCity(resultSet.getString(7));
                customer.setState(resultSet.getString(8));
                customer.setPoints(resultSet.getInt(9));
            }
            ConnectionPool.getINSTANCE().releaseConnection(connection);
            return customer;
        } catch (SQLException exception) {
            throw new RuntimeException(exception.getCause());
        }
    }

    @Override
    public void update(Customer entity)  {
        String sql = "UPDATE customers SET first_name=?,last_name=? WHERE customer_id=?";
        Connection connection = ConnectionPool.getINSTANCE().getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            System.out.println("Prije ažuriranja: " + entity);
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setInt(3, entity.getCustomerId());
            int numberAffectedRows = preparedStatement.executeUpdate();
            System.out.println("Broj ažuriranih redova: " + numberAffectedRows);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
        ConnectionPool.getINSTANCE().releaseConnection(connection);
    }

    @Override
    public void delete(Customer entity)  {

    }

    public List<String> getColumnNames() {
        String sqlQuery = "SELECT *FROM customers";
        Connection connection = ConnectionPool.getINSTANCE().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnNumber = resultSetMetaData.getColumnCount();
            List<String> columnNames = new ArrayList<>(columnNumber);
            for (int i = 1; i <= columnNumber; i++) {
                String columnName = resultSetMetaData.getColumnName(i);
                columnNames.add(columnName);
            }
            ConnectionPool.getINSTANCE().releaseConnection(connection);
            return columnNames;
        } catch (SQLException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
