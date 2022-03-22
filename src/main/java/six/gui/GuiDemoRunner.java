package six.gui;

import four.MediumTablePanel;
import four.Runner;
import six.gui.panel.ProductTablePanel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class GuiDemoRunner {
    public static void main(String[] args) {
        Runnable runnable = GuiDemoRunner::createAndShowGui;
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
        JPanel panel = new ProductTablePanel();
        panel.setOpaque(true);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
