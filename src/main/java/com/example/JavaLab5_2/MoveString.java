package com.example.JavaLab5_2;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class MoveString extends JFrame {

    private JLabel label;
    private String word = "Java World";

    private int x = -100;
    private int y = 50;

    private final int STEP_X = 1;
    private final int STEP_Y = 50;

    // guard flag to prevent repeated color change
    private boolean wrappedFromBottom = false;

    private final Color[] rainbowColors = {
            Color.RED, Color.ORANGE, Color.YELLOW,
            Color.GREEN, Color.BLUE
    };

    public MoveString() {
        setLayout(null);

        label = new JLabel(word);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setSize(label.getPreferredSize());

        add(label);

        Timer timer = new Timer(10, e -> move());
        timer.start();
    }

    private void move() {
        int frameWidth = getContentPane().getWidth();
        int frameHeight = getContentPane().getHeight();

        x += STEP_X;
        label.setLocation(x, y);

        // move to next row when exiting right
        if (x > frameWidth) {
            x = -label.getWidth();
            y += STEP_Y;
            wrappedFromBottom = false; // allow future bottom wrap
        }

        // wrap from bottom to top (change color ONCE)
        if (y + label.getHeight() > frameHeight && !wrappedFromBottom) {
            y = STEP_Y;
            wrappedFromBottom = true;

            label.setForeground(
                    rainbowColors[(int) (Math.random() * rainbowColors.length)]);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MoveString frame = new MoveString();
            frame.setSize(800, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
