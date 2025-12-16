package com.example.JavaLab3_bonus;

public class Main {
    public static void main(String[] args) {
        String y = "*";
        String spacedStar = "* ";
        int spaces = 10; // starting spaces
        for (int i = 0; i < 5; i++) {
            System.out.println(y.repeat(i) +
                " ".repeat(spaces) +
                spacedStar.repeat(i));
            spaces -= 2; // decrease by 2 each row
        }
    }
}
