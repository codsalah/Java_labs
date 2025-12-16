package com.example.OOPJava1;

public class Student extends People {
    private String major;
    private int year;
    private double gpa;
    private boolean isOn;

    // constructor
    public Student() {
    }

    // basic Constructor info
    public Student(String name, int age, String gender, String major) {
        super(name, age, gender);
        this.major = major;
    }

    public Student(String name, int age, String gender, String major, int year, double gpa, boolean isOn) {
        super(name, age, gender);
        this.major = major;
        this.year = year;
        this.gpa = gpa;
        this.isOn = isOn;
    }

    // override the toString method
    @Override
    public String toString() {
        return "Student [major=" + major + ", year=" + year + ", gpa=" + gpa + ", isOn=" + isOn + "]";
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean isOn) {
        this.isOn = isOn;
    }

}
