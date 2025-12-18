package com.example.JavaLab6_3;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class RandomBallMove extends JPanel {
    private int ballX = 50;
    private int ballY = 50;
    private final int ballSize = 30;
    private int ballSpeedX = 5;
    private int ballSpeedY = 5;
    private final Timer timer;

    public RandomBallMove() {
        Random rand = new Random();
        ballSpeedX = rand.nextInt(10) + 1;
        ballSpeedY = rand.nextInt(10) + 1;

        // time to move the ball and if the ball is out of the panel, it will change
        // it's direction (the Timer works as a trigger to move or reverse the ball)
        timer = new Timer(30, new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (getWidth() > 0 && getHeight() > 0) {
                    ballX += ballSpeedX;
                    ballY += ballSpeedY;

                    if (ballX <= 0 || ballX + ballSize >= getWidth()) {
                        ballSpeedX = -ballSpeedX;
                    }
                    if (ballY <= 0 || ballY + ballSize >= getHeight()) {
                        ballSpeedY = -ballSpeedY;
                    }
                }
                repaint();
            }
        });
    }

    // this method will be called in the StartStopButtons class
    public void startBall() {
        timer.start();
    }

    // this method will be called in the StartStopButtons class
    public void pauseBall() {
        timer.stop();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        g.fillOval(ballX, ballY, ballSize, ballSize);
    }
}
