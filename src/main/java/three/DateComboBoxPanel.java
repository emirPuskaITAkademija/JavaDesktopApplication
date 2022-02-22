package three;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Povezati ovaj GUI sa bazom podataka.
 * <li>
 * Baza treba da sadrži tabelu sa dvije kolone.
 * Ime tabele: date_patterns<p>
 * Kolone koje postoj unutar tabele su id, pattern.
 * id->TinyInt
 * pattern -> varchar(55)
 * </li>
 * <li>
 *     ZADATAK: Izbrisati datePatterns niz a navedeni vrijednosti učitati iz baze.
 *     Novoučitane vrijednosti povezati sa JComboBox
 * </li>
 */
public class DateComboBoxPanel extends JPanel {


    String[] datePatterns = {
            "dd MMMMM yyyy",
            "dd.MM.yy",
            "MM/dd/yy",
            "H:mm:ss:SSS"
    };
    //    private String selectedDatePattern = datePatterns[0];
    private final JLabel patternLabel1 = new JLabel("Unesite šablon za prikaz datum ili");
    private final JLabel patternLabel2 = new JLabel("odaberite jedan od ponuđenih šablona");
    private final JLabel resultLabelText = new JLabel("Prikaz Datuma/Vremena");
    private final JLabel resultLabel = new JLabel();

    public DateComboBoxPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //PRVI DIO NAŠEG GLAVNOG PANELA
        JComboBox<String> datePatternComboBox = new JComboBox<>(datePatterns);
        datePatternComboBox.setEditable(true);
        DatePatternListener datePatternListener = new DatePatternListener();
        datePatternComboBox.addActionListener(datePatternListener);

        JPanel patternPanel = new JPanel();
        patternPanel.setLayout(new BoxLayout(patternPanel, BoxLayout.Y_AXIS));
        patternPanel.add(patternLabel1);
        patternPanel.add(patternLabel2);
        datePatternComboBox.setAlignmentX(LEFT_ALIGNMENT);
        Border outsideBorder = BorderFactory.createLineBorder(Color.BLACK);
        Border insideBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border compoundBorder = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
        datePatternComboBox.setBorder(compoundBorder);
        patternPanel.add(datePatternComboBox);
        patternPanel.setAlignmentX(LEFT_ALIGNMENT);


        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(0, 1));
        resultPanel.add(resultLabelText);
        resultLabel.setBorder(compoundBorder);
        resultPanel.add(resultLabel);
        resultPanel.setAlignmentX(LEFT_ALIGNMENT);

        add(patternPanel);
        add(Box.createRigidArea(new Dimension(0, 15)));
        add(resultPanel);

        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        reformatDate(datePatterns[0]);
    }

    private void reformatDate(String selectedDatePattern) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormatter = new SimpleDateFormat(selectedDatePattern);
        String preformatiraniDatum = simpleDateFormatter.format(date);
        resultLabel.setText(preformatiraniDatum);
    }


    private class DatePatternListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JComboBox<String> datePatternComboBox = (JComboBox<String>) actionEvent.getSource();
            String newPattern = (String) datePatternComboBox.getSelectedItem();
            reformatDate(newPattern);
        }
    }
}
