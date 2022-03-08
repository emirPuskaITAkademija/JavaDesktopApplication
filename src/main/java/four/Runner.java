package four;

import one.CheckBoxPanel;
import three.Demo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Runner {
    public static void main(String[] args) {
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
//        JPanel panel = new SimpleTablePanel();
        MediumTablePanel panel = new MediumTablePanel();
        panel.setOpaque(true);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
