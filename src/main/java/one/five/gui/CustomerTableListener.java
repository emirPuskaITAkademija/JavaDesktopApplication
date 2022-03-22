package one.five.gui;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 * Želimo zakačiti listener na JTable.
 * Listener ćemo zakačiti preko TableModel(CustomerTableModel)
 */
public class CustomerTableListener implements TableModelListener {
    @Override
    public void tableChanged(TableModelEvent event) {
        int rowIndex = event.getFirstRow();
        CustomerTableModel tableModel = (CustomerTableModel) event.getSource();
        tableModel.updateSqlRow(rowIndex);
    }


}
