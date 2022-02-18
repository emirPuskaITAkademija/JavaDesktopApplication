package one;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * <li>1. Container(JFrame, JPanel, )</li>
 * <li>2. Controls(JButton)</li>
 * <li>3. LayoutManager(BorderLayout,FlowPane)</li>
 */
public class ButtonDemo {

    public static void main(String[] args) {
        Runnable runnable = ButtonDemo::createAndShowGUI;
        SwingUtilities.invokeLater(runnable);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Demonstracija upotrebe dugmića");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        one.ButtonPanel buttonPanel = new one.ButtonPanel();
        CheckBoxPanel checkBoxPanel = new CheckBoxPanel();
        frame.setContentPane(checkBoxPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
