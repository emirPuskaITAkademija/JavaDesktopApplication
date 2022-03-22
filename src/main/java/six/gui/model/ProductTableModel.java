package six.gui.model;

import four.entity.Customer;
import six.dao.ProductDao;
import six.entity.Product;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

/**
 * TableModel -> JTable
 * <p>
 *     pristupio podacima iz baze
 * </p>
 *
 * ProductDao   < ----->  ProductTableModel   <-------> JTable
 *
 * <p>FORMAT dobavljenih podataka iz baze:
 *          List<Product>
 * </p>
 * <p>
 *     FORMAT koji odgovara JTable:
 *          Vector<Vector<Object>>   -> Product polja preslikati u Vector polja
 * </p>
 */
public class ProductTableModel extends AbstractTableModel {

    private final ProductDao productDao = new ProductDao();
    private final Vector<String> columnNames = new Vector<>();
    private final Vector<Vector<Object>> rows = new Vector<>();

    public ProductTableModel(){
        columnNames.add("Product ID");
        columnNames.add("Name");
        columnNames.add("Quantity in stock");
        columnNames.add("Unit price");
        //List<Product>       ->     Vector<Vector<Object>>
        List<Product> productList = productDao.getAll();
        for(Product product: productList){
            Vector<Object> row = mapProductToVector(product);
            rows.add(row);
        }
    }

    private Vector<Object> mapProductToVector(Product product) {
        Vector<Object> row = new Vector<>();
        row.add(product.getProductId());
        row.add(product.getName());
        row.add(product.getQuantityInStock());
        row.add(product.getUnitPrice());
        return row;
    }

    private Product mapRowToProduct(Vector<Object> row){
        return new Product();
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vector<?> row = rows.get(rowIndex);
        Object valueAt = row.get(columnIndex);
        return valueAt;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class clazz = getValueAt(0, columnIndex).getClass();
        return clazz;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object novaVrijednost, int rowIndex, int columnIndex) {
        Vector<Object> row = rows.get(rowIndex);
        row.set(columnIndex, novaVrijednost);
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public void updateSqlTableRow(int row){
        // 0 customerId   1 firstName   2 lastName
        Vector<Object> rowVector = rows.get(row);
        //customerId, firstName, lastName
        Product product = mapRowToProduct(rowVector);
        productDao.update(product);
    }


}
