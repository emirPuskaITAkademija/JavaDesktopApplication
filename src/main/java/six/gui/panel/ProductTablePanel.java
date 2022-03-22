package six.gui.panel;

import six.gui.listener.ProductTableListener;
import six.gui.model.ProductTableModel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;

public class ProductTablePanel extends JPanel {
    private JTable productJTable;

    public ProductTablePanel(){
        ProductTableModel productTableModel= new ProductTableModel();
        ProductTableListener productTableListener = new ProductTableListener();
        productTableModel.addTableModelListener(productTableListener);
        productJTable = new JTable(productTableModel);
        setupTable();
        JScrollPane scrollPane = new JScrollPane(productJTable);
        scrollPane.setPreferredSize(new Dimension(800, 800));
        add(scrollPane);
    }
    private void setupTable() {
        this.productJTable.setPreferredSize(new Dimension(800, 800));
        this.productJTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        this.productJTable.setFillsViewportHeight(true);
    }
}
