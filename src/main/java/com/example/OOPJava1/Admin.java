package com.example.OOPJava1;

public class Admin extends People {
    private String department;

    // constructor
    public Admin() {
    }

    public Admin(String name, int age, String gender, String department) {
        super(name, age, gender);
        this.department = department;
    }

    // override the toString method
    @Override
    public String toString() {
        return "Admin [department=" + department + "]";
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
