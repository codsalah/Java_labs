package com.example.javauml;

public class CgComment extends CgObj {
    private static final long serialVersionUID = 1L;
    public int key;
    public String comment;

    public CgComment() {
    }

    @Override
    public String toString() {
        return "CgComment{" +
                "key=" + key +
                ", comment='" + comment + '\'' +
                '}';
    }
}
