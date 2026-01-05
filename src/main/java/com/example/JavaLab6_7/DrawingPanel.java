package com.example.JavaLab6_7;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;

class DrawingPanel extends JPanel implements MouseListener {

    Vector<Line> lines = new Vector<>(); // Here we have unlimited lines
    int startX, startY;
    int lineSize = 22;

    public DrawingPanel() {
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // redraw all stored lines
        for (Line l : lines) {
            g.drawLine(l.x1, l.y1, l.x2, l.y2);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int endX = e.getX();
        int endY = e.getY();

        lines.add(new Line(startX, startY, endX, endY));
        repaint();
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Draw Lines (Unlimited)");
        DrawingPanel panel = new DrawingPanel();

        frame.add(panel);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}