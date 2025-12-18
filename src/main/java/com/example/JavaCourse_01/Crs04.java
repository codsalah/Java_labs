package com.example.JavaCourse_01;

import java.util.Arrays;

public class Crs04 {
    public static void main(String[] args) {
        int[] myArray = { 1, 2, 3, 4, 5 };
        int[] randomArray;
        int[] numberArray = new int[10];
        randomArray = new int[20];
        String[] stringArray = { "wow", "amazing", "fantastic", "great" };
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = (int) (Math.random() * 100) + 1;
            if (i < stringArray.length) {
                System.out.println(stringArray[i]);
            }
            if (i < numberArray.length) {
                System.out.println(numberArray[i]);
            }
            if (i < myArray.length) {
                System.out.println(myArray[i]);
            }
        }

        System.out.println(Arrays.toString(randomArray));

        print2DBox(5, 5);
    }

    public static void print2DBox(int width, int height) {
        // print top border
        System.out.println("_______".repeat(width));
        System.out.println();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(" | " + "*" + " | ");
            }
            System.out.println();
        }
        // print bottom border
        System.out.println("_______".repeat(width));
    }

}
