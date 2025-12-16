package com.example.JavaLab1_2;

public class Student {
    private String name;
    private int age;
    private String track;

    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public Student() {
    }

    public Student(String name, int age, String track) {
        this.name = name;
        this.age = age;
        this.track = track;
    }

    // print student info
    public void printStudentInfo() {
        System.out.println("Name: " + getName() + "\nAge: " + getAge() + "\nTrack: " + getTrack());
    }

}
