package com.example.JavaLab6_1;

///////////////////////////////////////////////////////////
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonCount {
    static int count = 0;
    static JLabel label;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Count");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Use a JPanel to hold components
        JPanel panel = new JPanel();

        JButton buttonUp = createUpButton();
        JButton buttonDown = createDownButton();
        label = showCountInLabel();

        panel.add(buttonUp);
        panel.add(buttonDown);
        panel.add(label);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static JButton createUpButton() {
        JButton button = new JButton("Up");
        button.addActionListener(e -> {
            countUpButton();
            label.setText("Button clicked " + count + " times");
        });
        return button;
    }

    public static JButton createDownButton() {
        JButton button = new JButton("Down");
        button.addActionListener(e -> {
            countDownButton();
            label.setText("Button clicked " + count + " times");
        });
        return button;
    }

    public static void countUpButton() {
        count++;
        // System.out.println("Button clicked " + count + " times");
    }

    public static void countDownButton() {
        count--;
        // System.out.println("Button clicked " + count + " times");
    }

    public static JLabel showCountInLabel() {
        return new JLabel("Button clicked " + count + " times");
    }
}
