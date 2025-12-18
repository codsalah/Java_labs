package com.example.JavaCourse_01;

public class Crs03 {
    private int health = 500;
    private int attack = 100;
    private int movement = 2;
    private int xPosition = 0;
    private int yPosition = 0;
    private boolean alive = true;
    public final String TOMBSTONE = "Here Lies a DEAD Monster";

    public String name = "Big Monster";

    public Crs03() {

    }

    // constructor to change health, attack, movement, xPosition, yPosition, alive,
    // name
    public Crs03(int health, int attack, int movement, int xPosition, int yPosition, boolean alive, String name) {
        this.health = health;
        this.attack = attack;
        this.movement = movement;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.alive = alive;
        this.name = name;
    }

    // constructor to change health, attack, movement
    public Crs03(int newHealth, int newAttack, int newMovement) {
        this.health = newHealth;
        this.attack = newAttack;
        this.movement = newMovement;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int decreaseHealth) {
        health = health - decreaseHealth;
        if (health < 0) {
            alive = false;
        }
    }

    public void setHealth(double decrease) {
        health = (int) (health - decrease);
        if (health < 0) {
            alive = false;
        }
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public String getTOMBSTONE() {
        return TOMBSTONE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
