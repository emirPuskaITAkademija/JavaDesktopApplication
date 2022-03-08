package three;

import one.CheckBoxPanel;
import two.ComboBoxPanel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.awt.Container;

public class Demo {
    public static void main(String[] args) {
        Runnable runnable = Demo::createAndShowGui;
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
        frame.setTitle("Demo GUI");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel container = new CheckBoxPanel();
        container.setOpaque(true);
        frame.setContentPane(container);
        frame.pack();
        frame.setVisible(true);
    }
}
