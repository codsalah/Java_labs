package com.example.javauml;

import java.util.Arrays;

public class IsaKind extends CgObj {
    private static final long serialVersionUID = 1L;
    public String isaObject;
    public String[] characteristics;
    public String[] subtypes;

    public IsaKind() {
    }

    @Override
    public String toString() {
        return "IsaKind{" +
                "isaObject='" + isaObject + '\'' +
                ", characteristics=" + Arrays.toString(characteristics) +
                ", subtypes=" + Arrays.toString(subtypes) +
                '}';
    }
}
