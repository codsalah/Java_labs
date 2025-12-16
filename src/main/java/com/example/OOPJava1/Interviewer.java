package com.example.OOPJava1;

public class Interviewer extends People {
    private String company;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Interviewer() {
    }

    public Interviewer(String name, int age, String gender, String company) {
        super(name, age, gender);
        this.company = company;
    }

    // override the toString method
    @Override
    public String toString() {
        return "Interviewer [company=" + company + "]";
    }

}
