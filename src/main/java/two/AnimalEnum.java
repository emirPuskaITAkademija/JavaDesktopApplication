package two;

import one.ImageIconLoader;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.security.Key;

public enum AnimalEnum {

    DOG("Dog", false, KeyEvent.VK_D),
    BIRD("Bird", false, KeyEvent.VK_B),
    CAT("Cat", false, KeyEvent.VK_C),
    RABBIT("Rabbit", true, KeyEvent.VK_R),
    PIG("Pig", false, KeyEvent.VK_P);

    private String animalName;
    private boolean selected;
    private int mnemonic;

    private AnimalEnum(String animalName, boolean selected, int mnemonic){
        this.animalName = animalName;
        this.selected = selected;
        this.mnemonic = mnemonic;
    }

    public String getAnimalName() {
        return animalName;
    }

    public JRadioButton createRadioButton(ButtonGroup buttonGroup, ActionListener actionListener){
        JRadioButton radioButton = new JRadioButton(animalName);
        radioButton.setText(animalName);
        radioButton.setSelected(selected);
        radioButton.setMnemonic(mnemonic);
        radioButton.addActionListener(actionListener);
        buttonGroup.add(radioButton);
        return radioButton;
    }

    public ImageIcon getImageIcon(){
        ImageIconLoader imageIconLoader = new ImageIconLoader(animalName+".gif");
        ImageIcon imageIcon = imageIconLoader.loadImageIcon();
        return imageIcon;
    }
}
