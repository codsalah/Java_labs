package com.example.JavaLab4_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Ovals {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Ovals");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 500);
            frame.setLocationRelativeTo(null);

            OvalsPanel drawingPanel = new OvalsPanel();
            frame.add(drawingPanel, BorderLayout.CENTER);

            JPanel buttonPanel = new JPanel();
            JButton nextButton = new JButton("Toggle");
            buttonPanel.add(nextButton);
            frame.add(buttonPanel, BorderLayout.SOUTH);

            // Button toggles background between dark blue and brighter blue
            nextButton.addActionListener(e -> drawingPanel.toggleBackground());

            frame.setVisible(true);
        });
    }

    static class OvalsPanel extends JPanel {
        private Color backgroundColor = new Color(10, 25, 70); // dark blue
        private boolean bright = false;

        public void toggleBackground() {
            backgroundColor = bright ? new Color(10, 25, 70) : new Color(25, 50, 150);
            bright = !bright;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            setBackground(backgroundColor);

            Color yellow = new Color(255, 215, 0); // nice yellow
            Color white = new Color(245, 245, 245); // bright white

            // Main shapes
            g2d.setColor(yellow);
            g2d.fillOval(140, 80, 230, 50);
            g2d.setColor(white);
            g2d.drawOval(140, 80, 230, 50);

            g2d.drawLine(140, 105, 110, 270);
            g2d.drawLine(370, 105, 390, 270);
            g2d.drawArc(110, 230, 280, 70, 180, 180);
            g2d.drawLine(250, 300, 190, 400);
            g2d.drawLine(250, 300, 310, 400);
            g2d.drawRect(140, 400, 220, 20);

            g2d.setColor(yellow);
            g2d.fillOval(130, 170, 50, 70);
            g2d.fillOval(220, 150, 70, 120);
            g2d.fillOval(320, 170, 50, 70);

            g2d.setColor(white);
            g2d.drawOval(130, 170, 50, 70);
            g2d.drawOval(220, 150, 70, 120);
            g2d.drawOval(320, 170, 50, 70);
        }
    }
}
