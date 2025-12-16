package com.example.JavaLab3_1;

public class CalculatorBasic {
    public static int calculate(int a, char op, int b) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else if (op == '/') {
            return a / b;
        } else {
            throw new IllegalArgumentException("Invalid operator");
        }
    }
}