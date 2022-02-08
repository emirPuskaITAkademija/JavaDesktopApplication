import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

/**
 * <li>1. Container ... JPanel, CheckBoxPanel</li>
 * <li>2. UI controls ... JButton, JCheckBox</li>
 * <li>3. LayoutManager....FlowLayout, BorderLayout, GridLayout</li>
 */
public class CheckBoxPanel extends JPanel {
    private JCheckBox chinCheckBox;
    private JCheckBox glassesCheckBox;
    private JCheckBox hairCheckBox;
    private JCheckBox teethCheckBox;
    private StringBuffer imageChoice = new StringBuffer("cght");
    private JLabel pictureLabel = new JLabel();

    public CheckBoxPanel() {
        setLayout(new BorderLayout());
        //check boxes
        chinCheckBox = createCheckBox("Chin", KeyEvent.VK_C, true);
        glassesCheckBox = createCheckBox("Glasses", KeyEvent.VK_G, true);
        hairCheckBox = createCheckBox("Hair", KeyEvent.VK_H, true);
        teethCheckBox = createCheckBox("Teeth", KeyEvent.VK_T, true);
        //image label
        updatePictureLabel();
        JPanel checkBoxPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(0,1);
        checkBoxPanel.setLayout(gridLayout);
        checkBoxPanel.add(chinCheckBox);
        checkBoxPanel.add(glassesCheckBox);
        checkBoxPanel.add(hairCheckBox);
        checkBoxPanel.add(teethCheckBox);

        add(checkBoxPanel, BorderLayout.LINE_START);
        add(pictureLabel, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    private void updatePictureLabel(){
        String imageName = "geek-"+imageChoice.toString()+".gif";
        ImageIconLoader imageIconLoader = new ImageIconLoader(imageName);
        ImageIcon imageIcon = imageIconLoader.loadImageIcon();
        pictureLabel.setIcon(imageIcon);
    }

    private JCheckBox createCheckBox(String label, int mnemonic, boolean selected){
        JCheckBox checkBox = new JCheckBox(label);
        CheckBoxItemListener checkBoxListener = new CheckBoxItemListener();
        checkBox.addItemListener(checkBoxListener);
        checkBox.setMnemonic(mnemonic);
        checkBox.setSelected(selected);
        return checkBox;
    }


    /**
     * <li>1. S kojeg check boxa je došao event klik</li>
     * <li>2. Koje je stanje prisutno na tom check boxu SELECTED DESELECTED</li>
     */
    private class CheckBoxItemListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent event) {
            char character = '-';
            int index = 0;
            Object source = event.getItemSelectable();
            if(source == chinCheckBox){
                index = 0;
                character = 'c';
            }else if(source == glassesCheckBox){
                index = 1;
                character = 'g';
            }else if(source == hairCheckBox){
                index = 2;
                character = 'h';
            }else if (source == teethCheckBox){
                index = 3;
                character = 't';
            }
            if(event.getStateChange() == ItemEvent.DESELECTED){
                character = '-';
            }
            imageChoice.setCharAt(index, character);
            updatePictureLabel();
        }
    }
}
