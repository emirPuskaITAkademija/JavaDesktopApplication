package three;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Scanner;

public class Zadatak2 {
    public static void main(String[] args) {
        FrameModel frameModel = new FrameModel();
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("Unesite naslov prozora:");
            String title = scanner.nextLine();
            Point point = new Point();
            System.out.println("Unesite poziciju u formatu (x,y) ili x,y:");
            String position = scanner.nextLine();
            position = position.replace("(", "");
            position = position.replace(")", "");
            String[] positions = position.split(",");
            int x = Integer.parseInt(positions[0]);
            int y = Integer.parseInt(positions[1]);
            point.setLocation(x,y);
            System.out.println("Unesite željenu visinu prozora:");
            int width = scanner.nextInt();
            System.out.println("Unesite željenu širinu prozora: ");
            int height = scanner.nextInt();
            Dimension dimension = new Dimension(width, height);
            frameModel.setDimension(dimension);
            frameModel.setTitle(title);
            frameModel.setPoint(point);
        }
        Runnable runnable = ()->createAndShowGui(frameModel);
        SwingUtilities.invokeLater(runnable);
    }

    private static void createAndShowGui(FrameModel frameModel){
        JFrame frame = new JFrame();
        frame.setTitle(frameModel.getTitle());
        frame.setSize(frameModel.getDimension());
        frame.setLocation(frameModel.getPoint());
        frame.setVisible(true);
    }
}
