package com.example.JavaLab2_1;

abstract class Shape {
    public int dim;

    public Shape() {
    }

    public abstract double calculateArea();

    public int getDim() {
        return dim;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }

}
