package two;

import javax.swing.JFrame;

public class RunnableImplementation implements Runnable{
    @Override
    public void run() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
    }
}
