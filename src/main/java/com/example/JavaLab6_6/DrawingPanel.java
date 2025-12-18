package com.example.JavaLab6_6;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class DrawingPanel extends JPanel implements MouseListener {

    Line[] lines = new Line[10];
    int lineCount = 0;
    int startX, startY;

    public DrawingPanel() {
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // redraw all stored lines
        for (int i = 0; i < lineCount; i++) {
            Line l = lines[i];
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
        if (lineCount < lines.length) { // Only add if there's space
            int endX = e.getX();
            int endY = e.getY();
            lines[lineCount] = new Line(startX, startY, endX, endY);
            lineCount++;
            repaint();
        } else {
            System.out.println("Maximum of 10 lines reached!");
        }
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Lines (Max 10)");
        DrawingPanel panel = new DrawingPanel();

        frame.add(panel);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
