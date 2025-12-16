package com.example.JavaLab3_2;

import java.util.StringTokenizer;

public class IPCutter {
    private static String delimiter = "\\.";

    // Using split
    public static String[] splitStringCutter(String s) {
        return s.split(delimiter);
    }

    // Using StringTokenizer
    public static String splitStringTokenizer(String s) {
        StringTokenizer st = new StringTokenizer(s, ".");
        StringBuilder result = new StringBuilder();

        while (st.hasMoreTokens()) {
            result.append(st.nextToken()).append(" ");
        }

        return result.toString().trim();
    }

    // Using indexOf + substring
    public static String substringIndexOfCutter(String s) {
        StringBuilder result = new StringBuilder();

        while (true) {
            int dotIndex = s.indexOf(".");
            // If no more dots append the rest of the string
            if (dotIndex == -1) {
                result.append(s);
                break;
            }
            // Append the part before the dot and a space
            result.append(s.substring(0, dotIndex)).append(" ");
            // Remove the part before the dot
            s = s.substring(dotIndex + 1);
        }

        return result.toString().trim();
    }

}