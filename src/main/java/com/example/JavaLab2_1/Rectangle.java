package com.example.JavaLab2_1;

public class Rectangle extends Shape {
    int length;
    int width;

    public Rectangle() {
        super();
    }

    public Rectangle(int length, int width) {
        super();
        this.dim = length;
        this.width = width;
    }

    public double calculateArea() {
        return dim * width;
    }

}