package com.example.JavaLab5_3;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Ball {

    private double x, y;
    private double dx, dy;
    private int radius;
    private Color color;

    public Ball(double x, double y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;

        Random rand = new Random();

        double speed = 2 + rand.nextDouble() * 2;
        double angle = rand.nextDouble() * Math.PI * 2;

        dx = speed * Math.cos(angle);
        dy = speed * Math.sin(angle);
    }

    public static Ball fromCenter(int panelWidth, int panelHeight, int radius, Color color) {
        double cx = panelWidth / 2.0 - radius;
        double cy = panelHeight / 2.0 - radius;
        return new Ball(cx, cy, radius, color);
    }

    public void update(int panelWidth, int panelHeight) {
        x += dx;
        y += dy;

        if (x <= 0 || x + 2 * radius >= panelWidth) {
            dx = -dx;
        }
        if (y <= 0 || y + 2 * radius >= panelHeight) {
            dy = -dy;
        }
    }

    public boolean collidesWith(Ball other) {
        double dx = (x + radius) - (other.x + other.radius);
        double dy = (y + radius) - (other.y + other.radius);
        double distanceSq = dx * dx + dy * dy;
        double radii = radius + other.radius;
        return distanceSq <= radii * radii;
    }

    public double getCenterX() {
        return x + radius;
    }

    public double getCenterY() {
        return y + radius;
    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillOval((int) x, (int) y, radius * 2, radius * 2);
    }
}
