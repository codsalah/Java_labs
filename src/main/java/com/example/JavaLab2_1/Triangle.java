package com.example.JavaLab2_1;

public class Triangle extends Shape {
    int base;
    int height;

    public Triangle() {
        super();
    }

    public Triangle(int height, int base) {
        super();
        this.dim = height;
        this.base = base;
    }

    public double calculateArea() {
        return 0.5 * dim * base;
    }

}
