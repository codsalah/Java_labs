package com.example.JavaCourse_01;

import java.util.Scanner;

//User input, Conditional Statements, logical operators, While loop, do while loop

public class Crs01 {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        // take input
        System.out.println("Enter n and m: ");
        String contYorN = "Y";
        int h = 1;
        int n = 0;
        int m = 0;
        boolean validInput = false;

        if (!validInput) {
            System.out.println("Invalid input");
        }
        if (userInput.hasNextInt()) {
            n = userInput.nextInt();
            m = userInput.nextInt();
            System.out.println("n, m = " + n + ", " + m);
            validInput = true;

            if (n + m < 25) {
                System.out.println("n + m < 25");
            } else if (n + m > 25) {
                System.out.println("n + m > 25");
            } else {
                System.out.println("n + m = 25");
            }
        } else {
            System.out.println("Invalid input");
        }

        if (n > m && n + m < 25) {
            System.out.println("n > m and n + m < 25");
        } else if (n < m || n + m > 25) {
            System.out.println("n < m or n + m > 25");
        } else {
            System.out.println("n = m or n + m = 25");
        }

        int i = 1;
        while (i <= 20) {
            System.out.println(i);
            if (i == 3) {
                i += 10;
            } else if (i == 10) {
                continue;
            } else {
                i++;
            }
        }
        int j = 1;
        do {
            System.out.println(j);
            if (j == 40 || j == 41) {
                break;
            }
            j += 2;
        } while (j <= 200);

        if (userInput.hasNextLine()) {
            userInput.nextLine();
        }

        while (contYorN.equalsIgnoreCase("y")) {
            System.out.println(h);
            h++;
            System.out.println("Continue y or n ? ");
            contYorN = userInput.nextLine();
        }
        System.out.println("Thank you");
        userInput.close();
    }
}
