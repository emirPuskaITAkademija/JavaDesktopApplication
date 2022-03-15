package five.gui;

import four.dao.CustomerDao;
import four.entity.Customer;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 * 1.4  ?
 * WILDCARDS
 * <li> ? Unbounded</li>
 * <li> ? extends Number</li>
 * <li> ? super Integer</li>
 * <p>
 * 1.5 Generički E
 */
public class CustomerTableModel extends AbstractTableModel {

    private final CustomerDao customerDao = new CustomerDao();

    private final Vector<String> columnNames;
    private final Vector<Vector<Object>> data = new Vector<>();

    public CustomerTableModel() {
        columnNames = customerDao.getColumnNames()
                .stream()
                .collect(Collectors.toCollection(Vector::new));

        System.out.println();
        try {
            for (Customer customer : customerDao.getAll()) {
                Vector<Object> row = mapCustomerToVector(customer);
                data.add(row);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private Vector<Object> mapCustomerToVector(Customer customer) {
        Vector<Object> row = new Vector<>();
        row.add(customer.getCustomerId());
        row.add(customer.getFirstName());
        row.add(customer.getLastName());
        row.add(customer.getBirthdate());
        row.add(customer.getPhone());
        row.add(customer.getAddress());
        row.add(customer.getCity());
        row.add(customer.getState());
        row.add(customer.getPoints());
        return row;
    }


    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vector<?> row = data.get(rowIndex);
        Object valueAt = row.get(columnIndex);
        return valueAt;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Vector<Object> row = data.get(rowIndex);
        row.set(columnIndex, aValue);
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class clazz = getValueAt(0, columnIndex).getClass();
        return clazz;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex > 0;
    }

    public Vector<Object> getRawData(int rowIndex) {
        return data.get(rowIndex);
    }

    public void updateSqlRow(int rowIndex){
        // 0 customerId   1 firstName   2 lastName
        Vector<Object> rowVector = getRawData(rowIndex);
        //customerId, firstName, lastName
        Customer customer = toCustomer(rowVector);
        try {
            customerDao.update(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Customer toCustomer(Vector<Object> row) {
        Customer customer = new Customer();
        Integer customerId = (Integer) row.get(0);
        String firstName = (String) row.get(1);
        String lastName = (String) row.get(2);
        LocalDate birthdate = (LocalDate) row.get(3);
        String phone = (String) row.get(4);
        String address = (String) row.get(5);
        String city = (String) row.get(6);
        String state = (String) row.get(7);
        Integer points = (Integer) row.get(8);
        customer.setCustomerId(customerId);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setBirthdate(birthdate);
        customer.setPhone(phone);
        customer.setAddress(address);
        customer.setCity(city);
        customer.setState(state);
        customer.setPoints(points);
        return customer;
    }
}
