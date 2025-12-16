package com.example.javauml;

public class Isa extends CgObj {
    private static final long serialVersionUID = 1L;
    public String parent;
    public String child;

    public Isa() {
    }

    @Override
    public String toString() {
        return "Isa{" +
                "parent='" + parent + '\'' +
                ", child='" + child + '\'' +
                '}';
    }
}
