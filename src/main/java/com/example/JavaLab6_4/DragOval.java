package com.example.JavaLab6_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DragOval {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Drag Oval");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        OvalPanel panel = new OvalPanel();
        frame.add(panel);
        frame.setVisible(true);
    }

    static class OvalPanel extends JPanel {
        private int ovalX = 100;
        private int ovalY = 100;
        private final int ovalWidth = 50;
        private final int ovalHeight = 50;

        private boolean dragging = false;
        private int offsetX, offsetY;

        public OvalPanel() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (e.getX() >= ovalX && e.getX() <= ovalX + ovalWidth &&
                            e.getY() >= ovalY && e.getY() <= ovalY + ovalHeight) {
                        dragging = true;
                        offsetX = e.getX() - ovalX;
                        offsetY = e.getY() - ovalY;
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    dragging = false;
                }
            });

            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    if (dragging) {
                        ovalX = e.getX() - offsetX;
                        ovalY = e.getY() - offsetY;
                        repaint();
                    }
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.fillOval(ovalX, ovalY, ovalWidth, ovalHeight);
        }
    }
}