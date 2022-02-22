package three;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

/**
 * <li>FlowLayout</li>
 */
public class FormPanel extends JPanel {

    private JLabel titleLabel = new JLabel("User Login");
    private JLabel usernameLabel = new JLabel("Username: ");
    private JLabel passwordLabel = new JLabel("Password: ");
    private JTextField usernameTextField = new JTextField(10);
    private JTextField passwordTextField = new JPasswordField(10);
    private JButton loginButton = new JButton("Login");
    private JButton closeButton = new JButton("Close");

    public FormPanel(){
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        setLayout(boxLayout);
        Font font = new Font("Courier", Font.BOLD,20);
        titleLabel.setFont(font);
        add(titleLabel);
        JPanel usernamePanel = new JPanel();
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameTextField);
        JPanel passwordPanel = new JPanel();
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordTextField);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginButton);
        buttonPanel.add(closeButton);
        add(usernamePanel);
        add(passwordPanel);
        add(buttonPanel);

    }
}
