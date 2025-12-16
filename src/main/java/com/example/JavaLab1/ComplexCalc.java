package com.example.JavaLab1;

public class ComplexCalc {
    private double real;
    private double imag;

    public ComplexCalc() {
    }

    public ComplexCalc(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public static ComplexCalc addBoth(ComplexCalc other1, ComplexCalc other2) {
        return new ComplexCalc(other1.real + other2.real, other1.imag + other2.imag);
    }

    public static ComplexCalc subBoth(ComplexCalc other1, ComplexCalc other2) {
        return new ComplexCalc(other1.real - other2.real, other1.imag - other2.imag);
    }

    // print the complex number
    public String printComplexNumber() {
        return "Complex Number: " + real + " + " + imag + "i";
    }

}
