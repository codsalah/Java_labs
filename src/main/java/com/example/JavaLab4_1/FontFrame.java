package com.example.JavaLab4_1;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FontFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("List of Fonts");
            FontPanel panel = new FontPanel();

            frame.setContentPane(panel);
            frame.setSize(600, 800);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null); // center on screen
            frame.setVisible(true);
        });
    }
}
