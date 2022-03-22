package one.five;

import one.five.gui.CustomerTablePanel;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Runnable runnable = Runner::createAndShowGui;
        SwingUtilities.invokeLater(runnable);
    }

    /**
     * Create GUI and show it.
     * <p>
     *     For thread safety, this method should be invoked from
     *     the event-dispatched thread.
     * </p>
     */
    private static void createAndShowGui(){
        JFrame frame = new JFrame();
        frame.setTitle("Table GUI");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        CustomerTablePanel panel = new CustomerTablePanel();
        panel.setOpaque(true);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
