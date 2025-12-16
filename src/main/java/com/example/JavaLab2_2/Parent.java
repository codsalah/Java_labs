package com.example.JavaLab2_2;

public class Parent {
    private int num1;
    private int num2;

    public Parent() {
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int sumTwo(int nums1, int num2) {
        return nums1 + num2;
    }

}
