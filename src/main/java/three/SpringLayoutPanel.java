package three;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class SpringLayoutPanel extends JPanel {

    private JButton helloButton = new JButton("Hello");
    private JButton vozdraButton = new JButton("Vozdra button");

    public SpringLayoutPanel(){
        SpringLayout springLayout = new SpringLayout();
        setLayout(springLayout);
        springLayout.putConstraint(SpringLayout.WEST, helloButton, 200, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.NORTH, helloButton, 100, SpringLayout.NORTH, this);
        add(helloButton);
        add(vozdraButton);
    }
}
