package com.example.javauml;

import java.util.Arrays;

public class Cg extends CgObj {
    private static final long serialVersionUID = 1L;
    public String[] fs;
    public int key;

    public Cg() {
    }

    @Override
    public String toString() {
        return "Cg{" +
                "fs=" + Arrays.toString(fs) +
                ", key=" + key +
                '}';
    }

    @Override
    public String toHTML() {
        return "";
    }

    public String getTreeName() {
        return "";
    }
}
