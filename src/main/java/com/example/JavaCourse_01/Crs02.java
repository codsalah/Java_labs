package com.example.JavaCourse_01;

import java.util.Scanner;

// Methods, Exception handling, Classes
public class Crs02 {
    static double myPi = 3.14555; // Class variable

    public static void main(String[] args) {
        System.out.println(addThem(1, 2));
        System.out.println("Global class variable: " + myPi);
        tryToChange(1); // pass by value this is not changed
        tryToChange(myPi); // pass by value this is not changed

        System.out.println("Random number: " + getRandomNum());
        // let him guess with scanner
        Scanner theGuess = new Scanner(System.in);

        while (!checkGuess(theGuess.nextInt())) {
            System.out.println("Try again");
        }
        System.out.println("You guessed it, the actual number is " + getRandomNum());
        theGuess.close();
        // divideByZero(1);
        // nullPointer();
        catchClassNotFound();
        catchIllegalArgument("test");
        catchIndexOutOfBounds();
        catchIOException();
        catchInterrupted();
        catchSecurityException();
        checkValidAge();
    }

    public static int addThem(int a, int b) {
        double smallPI = 3.14; // Local variable
        double myPi = 3.00001; // override global variable
        System.out.println(myPi);
        return (int) (a + b + smallPI);
    }

    public static void tryToChange(double d) {
        d = d + 1;
        System.out.println("Try to change d = " + d);
    }

    public static int getRandomNum() {
        // make the number only between 1 to 10
        return (int) (Math.random() * 10) + 1;
    }

    public static boolean checkGuess(int guess) {
        System.out.println("Guess a number from 1 to 10: ");
        if (guess == getRandomNum()) {
            System.out.println("Correct");
            return true;
        } else {
            System.out.println("Wrong");
            return false;
        }
    }

    // Exceptions
    /*
     * ArithmeticException, ClassNotFoundException, IllegalArgumentException,
     * IndexOutOfBoundsException, IOException, InterruptedException,
     * NullPointerException, SecurityException, StringIndexOutOfBoundsException,
     * UnsupportedOperationException, ArrayIndexOutOfBoundsException,
     */

    public static void throwException() {
        throw new IllegalArgumentException("Invalid argument");
    }

    public static void tryCatch() {
        try {
            throwException();
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException Exception caught");
        } catch (Exception e) {
            System.out.println("Generic Exception caught");
        } finally {
            System.out.println("Finally");
        }
    }

    public static void catchClassNotFound() {
        try {
            Class.forName("com.example.NonExistentClass");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException Exception caught");
        }
    }

    public static void catchIllegalArgument(String arg) {
        try {
            if (arg == null || arg.isEmpty()) {
                throw new IllegalArgumentException("Argument cannot be null or empty");
            }
            System.out.println("Valid argument: " + arg);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException Exception caught: " + e.getMessage());
        }
    }

    public static void catchIndexOutOfBounds() {
        try {
            int[] arr = new int[5];
            System.out.println(arr[10]); // This will cause ArrayIndexOutOfBoundsException
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException Exception caught");
        }
    }

    public static void catchIOException() {
        try {
            // Simulate an IOException by explicitly throwing it
            throw new java.io.IOException("Simulated I/O error");
        } catch (java.io.IOException e) {
            System.out.println("IOException Exception caught: " + e.getMessage());
        }
    }

    public static void catchInterrupted() {
        try {
            Thread.sleep(100); // Simulate an interruptible operation
            Thread.currentThread().interrupt(); // Interrupt the current thread
            Thread.sleep(100); // This will throw InterruptedException
        } catch (InterruptedException e) {
            System.out.println("InterruptedException Exception caught");
            Thread.currentThread().interrupt(); // Restore the interrupted status
        }
    }

    public static void catchSecurityException() {
        // This is harder to demonstrate directly without a SecurityManager
        // For demonstration, we'll just throw it.
        try {
            throw new SecurityException("Simulated Security Exception");
        } catch (SecurityException e) {
            System.out.println("SecurityException Exception caught: " + e.getMessage());
        }
    }

    public static void checkValidAge() {
        try {
            int age = 15;
            if (age < 18) {
                throw new IllegalArgumentException("Age must be at least 18");
            }
            System.out.println("Valid age: " + age);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException Exception caught: " + e.getMessage());
        }
    }

}
