package three;

import one.ImageIconLoader;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

public class CustomComboBoxPanel extends JPanel {
    private final String[] petArray = {"Bird", "Cat", "Pig", "Rabbit", "Dog"};
    private final ImageIcon[] petIcons = new ImageIcon[petArray.length];
    private final Integer[] petNumbers = new Integer[petArray.length];

    public CustomComboBoxPanel() {
        super(new BorderLayout());
        //slika text -> int
        for (int i = 0; i < petArray.length; i++) {
            ImageIconLoader imageIconLoader = new ImageIconLoader(petArray[i] + ".gif");
            ImageIcon imageIcon = imageIconLoader.loadImageIcon();
            petIcons[i] = imageIcon;
            petNumbers[i] = i;
        }
        JComboBox<Integer> petComboBox = new JComboBox<>(petNumbers);
        ComboBoxItemLabel comboBoxItemLabel = new ComboBoxItemLabel();
        comboBoxItemLabel.setPreferredSize(new Dimension(200, 120));
        petComboBox.setRenderer(comboBoxItemLabel);
        petComboBox.setMaximumRowCount(3);
        add(petComboBox, BorderLayout.NORTH);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    private class ComboBoxItemLabel extends JLabel implements ListCellRenderer<Integer> {
        public ComboBoxItemLabel() {
            setOpaque(true);
            setHorizontalAlignment(CENTER);
            setVerticalAlignment(CENTER);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Integer> list, Integer value, int index, boolean isSelected, boolean cellHasFocus) {
            int selectedIndex = value.intValue();

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            ImageIcon imageIcon = petIcons[selectedIndex];
            String petText = petArray[selectedIndex];

            setIcon(imageIcon);
            setText(petText);
            return this;
        }
    }
}
