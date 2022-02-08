import javax.swing.*;

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
//        ButtonPanel buttonPanel = new ButtonPanel();
        CheckBoxPanel checkBoxPanel = new CheckBoxPanel();
        frame.setContentPane(checkBoxPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
