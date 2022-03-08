package four;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Dimension;

public class MediumTablePanel extends JPanel {

    private final JTable table = new JTable(new MyTableDataModel());

    public MediumTablePanel() {
        setupTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    private void setupTable() {
        this.table.setPreferredSize(new Dimension(500, 70));
        this.table.setFillsViewportHeight(true);
        this.table.getSelectionModel().addListSelectionListener(new RowListener());
        this.table.getColumnModel().getSelectionModel().addListSelectionListener(new ColumnListener());
    }

    /*********************INNER KLASE*****************************/

    private class RowListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            System.out.println("Selektovan red");
        }
    }

    private class ColumnListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            System.out.println("Selektovana kolona");
        }
    }
}
