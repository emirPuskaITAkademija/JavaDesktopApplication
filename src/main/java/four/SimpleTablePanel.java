package four;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Vector
 * Stack
 */
public class SimpleTablePanel extends JPanel {
    //KOLONE
    final String[] columnNames = {"Name", "Surname", "Sport", "Years in sport", "Vegetarian"};
    //PODATKE u redovima
    Object[][] data = {
            {"Ismar", "Kozica", "Fudbal", Integer.valueOf(12), Boolean.valueOf(false)},
            {"Neila", "Hasanović", "Odbojka", Integer.valueOf(2), Boolean.valueOf(true)},
            {"Ismar", "Kozica", "Fudbal", Integer.valueOf(12), Boolean.valueOf(false)}

    };
    private final JTable table = new JTable(data, columnNames);

    public SimpleTablePanel() {
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                printTableData(e);
            }
        });
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

    }

    private void printTableData(MouseEvent mouseEvent){
        int rowNumber = table.getRowCount();
        int columnNumber = table.getColumnCount();
        TableModel tableModel = table.getModel();
        for(int i = 0; i<rowNumber; i++){
            for(int j = 0; j<columnNumber;j++){
                System.out.print(" " + tableModel.getValueAt(i, j));
            }
            System.out.println();
        }

    }
}
