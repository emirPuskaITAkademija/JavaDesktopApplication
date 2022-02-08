import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;

/**
 * Container tipa JPanel.
 * <p></p>
 * FlowLayout defaultno povezan sa JPanel
 */
public class ButtonPanel extends JPanel {
    private JButton leftButton;
    private JButton middleButton;
    private JButton rightButton;

    public ButtonPanel(){
        this.leftButton = createButton("Disable middle button", "right.gif", "DISABLE", KeyEvent.VK_D);
        this.leftButton.setToolTipText("Ovaj dugmić disable srednji dugmić...");
        this.leftButton.setHorizontalTextPosition(AbstractButton.LEADING);
        this.leftButton.setVerticalTextPosition(AbstractButton.CENTER);

        this.middleButton = createButton("Middle VICTIM", "middle.gif", "", KeyEvent.VK_S);
        this.middleButton.setVerticalTextPosition(AbstractButton.BOTTOM);
        this.middleButton.setHorizontalTextPosition(AbstractButton.CENTER);

        this.rightButton = createButton("Enable middle button", "left.gif", "ENABLE", KeyEvent.VK_E);
        ActionListener buttonListener = this::middleButtonAction;
        this.leftButton.addActionListener(buttonListener);
        this.rightButton.addActionListener(buttonListener);
        this.rightButton.setToolTipText("Ovaj dugmić enabe srednji dugmić...");
        add(leftButton);
        add(middleButton);
        add(rightButton);
    }

    private JButton createButton(String labela, String iconName, String actionCommand, int mnemonic){
        ImageIcon imageIcon = createImageIcon(iconName);
        JButton button = new JButton(labela, imageIcon);
        button.setActionCommand(actionCommand);
        button.setMnemonic(mnemonic);
        return button;
    }

    private ImageIcon createImageIcon(String iconName){
        URL imageAddress = ButtonPanel.class.getResource(iconName);
        System.out.println(imageAddress);
        if(imageAddress != null){
            ImageIcon imageIcon = new ImageIcon(imageAddress);
            return imageIcon;
        }else{
            System.err.println("Ne mogu učitati sliku...");
            return null;
        }
    }

    private void middleButtonAction(ActionEvent e){
        if("DISABLE".equals(e.getActionCommand())){
            middleButton.setEnabled(false);
        }else{
            middleButton.setEnabled(true);
        }
        System.out.println("Izvršava se blok koda actionPerfom metode..FUNCTIONAL STYLE");
    }



//    private class ButtonListener implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if("DISABLE".equals(e.getActionCommand())){
//                middleButton.setEnabled(false);
//            }else{
//                middleButton.setEnabled(true);
//            }
//            System.out.println("Izvršava se blok koda actionPerfom metode..");
//
//        }
//    }
}
