package five.gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;

/**
 * TableModel -> Table
 * <p>
 * TableModel(AbstractTableModel) -> JTable
 * </p>
 *
 * <li>
 * JTable customerTable   <----> TableModel(CustomerTableModel)   <-------> CustomerDao
 *                                          CustomerTableListener
 * </li>
 */
public class CustomerTablePanel extends JPanel {

    private JTable customerTabel;

    public CustomerTablePanel() {
        CustomerTableModel customerTableModel = new CustomerTableModel();
        CustomerTableListener listener = new CustomerTableListener();
        customerTableModel.addTableModelListener(listener);
        this.customerTabel = new JTable(customerTableModel);
        setupTable();
        JScrollPane scrollPane = new JScrollPane(customerTabel);
        scrollPane.setPreferredSize(new Dimension(800, 800));
        add(scrollPane);
    }

    private void setupTable() {
        this.customerTabel.setPreferredSize(new Dimension(800, 800));
        this.customerTabel.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        this.customerTabel.setFillsViewportHeight(true);
    }

}
