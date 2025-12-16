package com.example.javauml;

public class Conference extends CgObj {
    private static final long serialVersionUID = 1L;
    public int toId;
    public int fromId;
    public String name;

    public Conference() {
    }

    @Override
    public String toString() {
        return "Conference{" +
                "toId=" + toId +
                ", fromId=" + fromId +
                ", name='" + name + '\'' +
                '}';
    }
}
