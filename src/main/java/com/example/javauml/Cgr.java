package com.example.javauml;

public class Cgr extends CgObj {
    private static final long serialVersionUID = 1L;
    public int fromId;
    public int toId;
    public String name;
    public String comment;

    public Cgr() {
    }

    @Override
    public String toString() {
        return "Cgr{" +
                "fromId=" + fromId +
                ", toId=" + toId +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
