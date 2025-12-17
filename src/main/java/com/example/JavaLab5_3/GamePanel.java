package com.example.JavaLab5_3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel {

    private final List<Ball> balls = new ArrayList<>();
    private final Random rand = new Random();

    private static final int BALL_RADIUS = 12;
    // private static final int MAX_BALLS = 50;
    private long lastSpawnTime = 0;
    private static final long SPAWN_COOLDOWN_MS = 1000;

    // collision delay
    private final long startTime;
    private boolean collisionEnabled = false;

    public GamePanel() {
        setBackground(Color.BLACK);

        balls.add(Ball.fromCenter(800, 400, BALL_RADIUS, Color.RED));
        balls.add(Ball.fromCenter(800, 400, BALL_RADIUS, Color.GREEN));

        startTime = System.currentTimeMillis();

        Timer timer = new Timer(16, e -> gameLoop());
        timer.start();
    }

    private void gameLoop() {
        for (Ball ball : balls) {
            ball.update(getWidth(), getHeight());
        }

        // enable collisions after 1 second
        if (!collisionEnabled &&
                System.currentTimeMillis() - startTime >= 1000) {
            collisionEnabled = true;
        }

        if (collisionEnabled) {
            handleCollisions();
        }

        repaint();
    }

    private void handleCollisions() {

        long now = System.currentTimeMillis();

        // still in cooldown (ignore all collisions)
        if (now - lastSpawnTime < SPAWN_COOLDOWN_MS) {
            return;
        }

        for (int i = 0; i < balls.size(); i++) {
            for (int j = i + 1; j < balls.size(); j++) {

                Ball a = balls.get(i);
                Ball b = balls.get(j);

                if (a.collidesWith(b)) {

                    double spawnX = (a.getCenterX() + b.getCenterX()) / 2 - BALL_RADIUS;
                    double spawnY = (a.getCenterY() + b.getCenterY()) / 2 - BALL_RADIUS;

                    balls.add(new Ball(
                            spawnX,
                            spawnY,
                            BALL_RADIUS,
                            randomColor()));

                    lastSpawnTime = now; // start cooldown
                    return;
                }
            }
        }
    }

    private Color randomColor() {
        return new Color(
                rand.nextInt(256),
                rand.nextInt(256),
                rand.nextInt(256));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (Ball ball : balls) {
            ball.draw(g2d);
        }
    }
}
