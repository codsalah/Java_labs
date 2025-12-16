package com.example.javauml;

import java.util.Arrays;

public class Cgc extends CgObj {
    private static final long serialVersionUID = 1L;
    public String[] fs;
    public int key;
    public int cdkey;
    public int type;
    public int simple;
    public int situation;
    public String name;
    public String comment;

    public Cgc() {
    }

    @Override
    public String toString() {
        return "Cgc{" +
                "fs=" + Arrays.toString(fs) +
                ", key=" + key +
                ", cdkey=" + cdkey +
                ", type=" + type +
                ", simple=" + simple +
                ", situation=" + situation +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public String getTreeName() {
        return name;
    }
}
