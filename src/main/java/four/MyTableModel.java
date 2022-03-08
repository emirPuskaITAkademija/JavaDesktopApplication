package four;

import javax.swing.table.AbstractTableModel;

class MyTableDataModel extends AbstractTableModel {
    //KOLONE
    private final String[] columnNames = {"Name", "Surname", "Sport", "Years in sport", "Vegetarian"};
    //PODATKE u redovima
    private final Object[][] data = {
            {"Ismar", "Kozica", "Fudbal", Integer.valueOf(12), Boolean.valueOf(false)},
            {"Neila", "Hasanović", "Odbojka", Integer.valueOf(2), Boolean.valueOf(true)},
            {"Ismar", "Kozica", "Fudbal", Integer.valueOf(12), Boolean.valueOf(false)}

    };

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex <=2) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0,columnIndex).getClass();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
