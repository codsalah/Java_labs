package com.example.JavaLab2_1;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectangle rect = new Rectangle(2, 10);
        Triangle triangle = new Triangle(5, 10);
        Picture picture = new Picture();
        System.out.println(picture.sumAreas(circle, rect, triangle));
    }

}
