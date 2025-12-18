package com.example.JavaLab6_1;

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

        JButton button = createButton();
        label = showCountInLabel();

        panel.add(button);
        panel.add(label);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static JButton createButton() {
        JButton button = new JButton("Click");
        button.addActionListener(e -> {
            countButton();
            label.setText("Button clicked " + count + " times");
        });
        return button;
    }

    public static void countButton() {
        count++;
        // System.out.println("Button clicked " + count + " times");
    }

    public static JLabel showCountInLabel() {
        return new JLabel("Button clicked " + count + " times");
    }
}
