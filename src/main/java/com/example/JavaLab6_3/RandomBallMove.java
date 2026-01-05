package com.example.JavaLab6_3;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class RandomBallMove extends JPanel implements Runnable {
    private int ballX = 50;
    private int ballY = 50;
    private final int ballSize = 30;
    private int ballSpeedX;
    private int ballSpeedY;

    private Thread ballThread;
    private boolean running = false;

    public RandomBallMove() {
        Random rand = new Random();
        ballSpeedX = rand.nextInt(10) + 1;
        ballSpeedY = rand.nextInt(10) + 1;

        // Original Timer approach (commented):
        /*
         * timer = new Timer(30, new java.awt.event.ActionListener() {
         * 
         * @Override
         * public void actionPerformed(java.awt.event.ActionEvent e) {
         * if (getWidth() > 0 && getHeight() > 0) {
         * ballX += ballSpeedX;
         * ballY += ballSpeedY;
         * 
         * if (ballX <= 0 || ballX + ballSize >= getWidth()) {
         * ballSpeedX = -ballSpeedX;
         * }
         * if (ballY <= 0 || ballY + ballSize >= getHeight()) {
         * ballSpeedY = -ballSpeedY;
         * }
         * }
         * repaint();
         * }
         * });
         */
    }

    // Start the ball movement (Thread approach)
    public void startBall() {
        if (!running) {
            running = true;
            ballThread = new Thread(this); // this class implements Runnable
            ballThread.start();
        }
    }

    // Pause the ball movement
    public void pauseBall() {
        running = false;

        // Original Timer stop (commented)
        // timer.stop();
    }

    // The run method is called when the thread starts
    @Override
    public void run() {
        while (running) {
            if (getWidth() > 0 && getHeight() > 0) {
                // update ball position
                ballX += ballSpeedX;
                ballY += ballSpeedY;

                // bounce off walls
                if (ballX <= 0 || ballX + ballSize >= getWidth()) {
                    ballSpeedX = -ballSpeedX;
                }
                if (ballY <= 0 || ballY + ballSize >= getHeight()) {
                    ballSpeedY = -ballSpeedY;
                }

                // repaint the panel to show new position
                repaint();
            }

            try {
                Thread.sleep(30); // delay ~30ms (similar to Timer interval)
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        g.fillOval(ballX, ballY, ballSize, ballSize);
    }
}
