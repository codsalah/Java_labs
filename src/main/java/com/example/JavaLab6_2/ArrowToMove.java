package com.example.JavaLab6_2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ArrowToMove {

    static int wordX = 50;
    static int wordY = 50;
    static final int wordSpeed = 10;
    static String theWord = "JAVA";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Arrow to Move");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        WordPanel panel = new WordPanel();
        frame.add(panel);
        frame.setVisible(true);

        // KeyListener listens to keyboard events
        // Using inner classes
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

                // Move the word according to arrow keys
                if (key == KeyEvent.VK_LEFT)
                    wordX -= wordSpeed;
                if (key == KeyEvent.VK_RIGHT)
                    wordX += wordSpeed;
                if (key == KeyEvent.VK_UP)
                    wordY -= wordSpeed;
                if (key == KeyEvent.VK_DOWN)
                    wordY += wordSpeed;

                // Bounds check so the word stays inside the panel
                if (wordX < 0)
                    wordX = 0;
                if (wordY < 30)
                    wordY = 30;
                if (wordX > panel.getWidth() - 50)
                    wordX = panel.getWidth() - 50;
                if (wordY > panel.getHeight())
                    wordY = panel.getHeight();

                panel.repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }
        });

        // Make sure the frame can receive keyboard input
        frame.setFocusable(true);
        frame.requestFocusInWindow();
    }

    // Custom JPanel to draw the word
    static class WordPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.setColor(Color.BLUE);
            g.drawString(theWord, wordX, wordY); // draw the word at (wordX, wordY)
        }
    }
}
