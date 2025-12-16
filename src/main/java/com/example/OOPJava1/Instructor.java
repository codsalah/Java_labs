package com.example.OOPJava1;

public class Instructor extends People {
    private String[] subjects;
    private double salary;

    // constructor
    public Instructor() {
    }

    public Instructor(String[] subjects, double salary) {
        this.subjects = subjects;
        this.salary = salary;
    }

    public Instructor(String name, int age, String gender, String[] subjects, double salary) {
        super(name, age, gender);
        this.subjects = subjects;
        this.salary = salary;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // override the toString method
    @Override
    public String toString() {
        return "Instructor [subjects=" + subjects + ", salary=" + salary + "]";
    }

}
