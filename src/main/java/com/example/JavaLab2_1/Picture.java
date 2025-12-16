package com.example.JavaLab2_1;

public class Picture {
    public double sumAreas(Shape shape1, Shape shape2, Shape shape3) {
        return shape1.calculateArea() + shape2.calculateArea() + shape3.calculateArea();
    }
}
