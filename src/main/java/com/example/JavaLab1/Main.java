package com.example.JavaLab1;

public class Main {
    public static void main(String[] args) {
        // call static methods
        ComplexCalc resultAdd = ComplexCalc.addBoth(new ComplexCalc(1, 2), new ComplexCalc(3, 4));
        ComplexCalc resultSub = ComplexCalc.subBoth(new ComplexCalc(1, 2), new ComplexCalc(3, 4));

        System.out.println(resultAdd.printComplexNumber());
        System.out.println(resultSub.printComplexNumber());

    }

}
