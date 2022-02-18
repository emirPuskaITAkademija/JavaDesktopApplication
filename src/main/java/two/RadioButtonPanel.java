package two;

import one.ImageIconLoader;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.stream.Stream;

/**
 * <li>RadioButtonPanel -> container</li
 * <li>controlls JRadioButton</li>
 * <li>FLowLayout, BorderLayout</li>
 * <p>
 * center -> slika
 * line_start -> radio dugmiće
 */
public class RadioButtonPanel extends JPanel {
//    implements ActionListener

    private JLabel pictureLabel = new JLabel();
    private ButtonGroup radioButtonGroup = new ButtonGroup();
    //        RadioButtonListener listener = new RadioButtonListener();
//        ActionListener actionListener = this::desilaSeAkcijaNaRadioDugmicima;
//        AnimalEnum[] animals = AnimalEnum.values();
//        for(AnimalEnum animalEnum: animals){
//            JRadioButton radioButton = animalEnum.createRadioButton(radioButtonGroup, this::radioButtonListening);
//            radioButtonPanel.add(radioButton);
//        }
    public RadioButtonPanel() {
        setLayout(new BorderLayout());
        JPanel radioButtonPanel = new JPanel(new GridLayout(0, 1));
        Stream.of(AnimalEnum.values())
                .map(this::animalToRadioButton)
                .forEach(radioButtonPanel::add);
        add(radioButtonPanel, BorderLayout.LINE_START);
        pictureLabel.setPreferredSize(new Dimension(180, 125));
        ImageIcon imageIcon = AnimalEnum.RABBIT.getImageIcon();
        pictureLabel.setIcon(imageIcon);
        add(pictureLabel, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    private JRadioButton animalToRadioButton(AnimalEnum animalEnum){
        JRadioButton radioButton = animalEnum.createRadioButton(radioButtonGroup, this::radioButtonListening);
        return radioButton;
    }

    private void radioButtonListening(ActionEvent actionEvent) {
        System.out.println(actionEvent.getActionCommand());
        String pictureName = actionEvent.getActionCommand() + ".gif";
        ImageIconLoader imageIconLoader = new ImageIconLoader(pictureName);
        ImageIcon imageIcon = imageIconLoader.loadImageIcon();
        pictureLabel.setIcon(imageIcon);
    }

//    @Override
//    public void actionPerformed(ActionEvent actionEvent) {
//        System.out.println(actionEvent.getActionCommand());
//        ImageIconLoader imageIconLoader = new ImageIconLoader(actionEvent.getActionCommand()+".gif");
//        ImageIcon imageIcon = imageIconLoader.loadImageIcon();
//        pictureLabel.setIcon(imageIcon);
//    }

//    private class RadioButtonListener implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent actionEvent) {
//            System.out.println(actionEvent.getActionCommand());
//            ImageIconLoader imageIconLoader = new ImageIconLoader(actionEvent.getActionCommand()+".gif");
//            ImageIcon imageIcon = imageIconLoader.loadImageIcon();
//            pictureLabel.setIcon(imageIcon);
//        }
//    }
}
