import javax.swing.*;
public class Test {
    public static void main(String[] args) {
        System.out.println("DISPLAY=" + System.getenv("DISPLAY"));
        JFrame frame = new JFrame("Test");
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
