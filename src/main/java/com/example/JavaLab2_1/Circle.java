package com.example.JavaLab2_1;

public class Circle extends Shape {
    public Circle() {
        super();
    }

    public Circle(int radius) {
        super();
        this.dim = radius;
    }

    public double calculateArea() {
        return Math.PI * dim * dim;
    }
}
