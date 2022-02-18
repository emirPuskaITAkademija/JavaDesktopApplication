package two;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * JEDAN PROCES -> N THREADOVA ali ima najmanje 1 THREAD
 * <li>MAIN thread </li>
 * <li>UI Thread</li>
 *
 * DVa načina za kreiranje Threadova:
 * <li>1. Thread </li> new Thread().start();
 * <li>2. Runnable -> run()</li> new Thread(new Runnable()).start();
 */
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
        JPanel panel = new ComboBoxPanel();
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
