package com.example.JavaLab6_5;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
    private Line line; // Only one line at a time

    public DrawingPanel() {
        // Mouse handler to track press, drag, release
        MouseAdapter mouseHandler = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Start the line from where the mouse is pressed
                line = new Line(e.getX(), e.getY(), e.getX(), e.getY());
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                // Update line end point while dragging
                if (line != null) {
                    line.x2 = e.getX();
                    line.y2 = e.getY();
                    repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Set final end point when mouse released
                if (line != null) {
                    line.x2 = e.getX();
                    line.y2 = e.getY();
                    repaint();
                }
            }
        };

        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (line != null) {
            g.drawLine(line.x1, line.y1, line.x2, line.y2);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw One Line");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.add(new DrawingPanel());
        frame.setVisible(true);
    }
}
