package com.example.JavaLab2_2;

public class Child extends Parent {
    private int num3;

    public Child() {
        super();
    }

    public Child(int num3) {
        super();
        this.num3 = num3;
    }

    public int getNum3() {
        return num3;
    }

    public void setNum3(int num3) {
        this.num3 = num3;
    }

    @Override
    public int sumTwo(int num1, int num2) {
        return super.sumTwo(num1, num2) + getNum3();
    }

}
