package six.gui.listener;

import one.five.gui.CustomerTableModel;
import six.gui.model.ProductTableModel;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class ProductTableListener implements TableModelListener {
    @Override
    public void tableChanged(TableModelEvent event) {
        int rowIndex = event.getFirstRow();
        ProductTableModel tableModel = (ProductTableModel) event.getSource();
        tableModel.updateSqlTableRow(rowIndex);
    }
}
