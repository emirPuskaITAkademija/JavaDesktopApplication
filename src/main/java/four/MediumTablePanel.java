package four;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;
import javax.swing.text.Document;
import java.awt.Dimension;
import java.awt.GridLayout;

public class MediumTablePanel extends JPanel {

    //filter
    private final JTextField nameTextField;
    private final TableRowSorter<MyTableDataModel> tableRowSorter;
    //
    private final JTable table;

    public MediumTablePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //FORMA
        JPanel formPanel = new JPanel(new GridLayout(1, 1));
        formPanel.setSize(200, 300);
        JLabel searchLabel = new JLabel("Filter by surname:", SwingConstants.TRAILING);
        formPanel.add(searchLabel);
        this.nameTextField = new JTextField();
        this.nameTextField.getDocument().addDocumentListener(new MyDocumentListener());
        searchLabel.setLabelFor(nameTextField);
        formPanel.add(nameTextField);
        add(formPanel);
        //TABELA
        MyTableDataModel tableDataModel = new MyTableDataModel();
        this.tableRowSorter = new TableRowSorter<>(tableDataModel);
        this.table = new JTable(tableDataModel);
        this.table.setRowSorter(tableRowSorter);
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

    private class MyDocumentListener implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent e) {
            filter();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            filter();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            filter();
        }


        /**
         *  JTextField nameTextField;
         *
         *  <p>
         *      String nameText = "Neila";
         *  </p>
         *  Kolona na koju ću aplicirati row filtriranje
         */
        private void filter(){
            String nameText = nameTextField.getText();
            RowFilter<MyTableDataModel, Object> rowFilter = RowFilter.regexFilter(nameText, 1);
            tableRowSorter.setRowFilter(rowFilter);
        }
    }
}
