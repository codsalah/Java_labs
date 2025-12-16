package com.example.javauml;

public class Typedef extends CgObj {
    private static final long serialVersionUID = 1L;
    public int cdkey;
    public int key;
    public String name;

    public Typedef() {
    }

    @Override
    public String toString() {
        return "Typedef{" +
                "cdkey=" + cdkey +
                ", key=" + key +
                ", name='" + name + '\'' +
                '}';
    }

    public String getTreeName() {
        return name;
    }
}
