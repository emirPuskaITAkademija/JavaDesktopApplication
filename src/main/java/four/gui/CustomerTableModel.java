package four.gui;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class CustomerTableModel extends AbstractTableModel {
    private final Vector<String> columnNames;
    private final Vector<Vector<Object>> data;

    public CustomerTableModel(Vector<String> columnNames, Vector<Vector<Object>> data){
        this.columnNames = columnNames;
        this.data = data;
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
        Vector<Object> rowVector = data.get(rowIndex);
        Object cellValue = rowVector.get(columnIndex);
        return cellValue;
    }
}
