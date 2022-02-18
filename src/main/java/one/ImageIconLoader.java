package one;


import javax.swing.ImageIcon;
import java.net.URL;

public class ImageIconLoader {

    private String imagePath;

    public ImageIconLoader(String imagePath) {
        this.imagePath = imagePath;
    }


    public ImageIcon loadImageIcon() {
        ClassLoader classLoader = getClass().getClassLoader();
        if (!imagePath.endsWith(".gif")) {
            imagePath = imagePath + ".gif";
        }
        URL imageAddress = classLoader.getResource(imagePath);
        System.out.println(imageAddress);
        if (imageAddress != null) {
            ImageIcon imageIcon = new ImageIcon(imageAddress);
            return imageIcon;
        } else {
            System.err.println("Ne mogu učitati sliku...");
            return null;
        }
    }
}
