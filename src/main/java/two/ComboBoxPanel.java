package two;

import one.ImageIconLoader;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ComboBoxPanel extends JPanel implements ActionListener {

    private JLabel pictureLabel = new JLabel();

    public ComboBoxPanel(){
        super(new BorderLayout());
        Vector<String> animals = new Vector<>();
        for(AnimalEnum animal: AnimalEnum.values()){
            animals.add(animal.getAnimalName());
        }
        JComboBox<String> animalComboBox = new JComboBox<String>(animals);
        animalComboBox.setEditable(false);
        animalComboBox.setSelectedItem(AnimalEnum.RABBIT.getAnimalName());
        animalComboBox.addActionListener(this);
        add(animalComboBox, BorderLayout.PAGE_START);
        ImageIconLoader imageIconLoader = new ImageIconLoader(AnimalEnum.RABBIT.getAnimalName()+".gif");
        ImageIcon imageIcon = imageIconLoader.loadImageIcon();
        pictureLabel.setIcon(imageIcon);
        pictureLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        add(pictureLabel, BorderLayout.PAGE_END);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JComboBox<String> comboBox = (JComboBox<String>) actionEvent.getSource();
        String selectedAnimal = (String)comboBox.getSelectedItem();
        ImageIconLoader imageIconLoader = new ImageIconLoader(selectedAnimal);
        ImageIcon imageIcon = imageIconLoader.loadImageIcon();
        pictureLabel.setIcon(imageIcon);
    }
}
