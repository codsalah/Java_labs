package com.example.JavaLab4_1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class FontPanel extends JPanel {
    private String[] fontNames;
    private int fontSize = 20;

    public FontPanel() {
        // Tookit way of doing it
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        System.out.println("Toolkit screen resolution: " + toolkit.getScreenResolution());

        // get fonts from the deprecated toolkit method
        fontNames = toolkit.getFontList();
        setBackground(new Color(248, 238, 238));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int y = 20;
        for (int i = 0; i < 10; i++) {
            g.setFont(new Font(fontNames[i], Font.PLAIN, fontSize));
            g.drawString(fontNames[i], 20, y);
            y += fontSize + 5;
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 10 * (fontSize + 5) + 20);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("FONTSSSSSS{");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new FontPanel());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
