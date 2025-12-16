package com.example.OOPJava1;

public class Toolbox implements CustomCheckable {
    private boolean dependable;
    private boolean active;
    private boolean secure;
    private boolean valid;

    public Toolbox() {
        // Default state
        this.dependable = true;
        this.active = true;
        this.secure = false;
        this.valid = true;
    }

    @Override
    public boolean isDependable() {
        return this.dependable;
    }

    @Override
    public boolean isActive() {
        return this.active;
    }

    @Override
    public boolean isSecure() {
        return this.secure;
    }

    // Setters for testing state changes
    public void setDependable(boolean dependable) {
        this.dependable = dependable;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return this.valid;
    }

    public static void main(String[] args) {
        Toolbox toolbox = new Toolbox();
        System.out.println("Starting Toolbox Checks...");
        System.out.println("Is Dependable? " + toolbox.isDependable());
        System.out.println("Is Valid? " + toolbox.isValid());
        System.out.println("Is Active? " + toolbox.isActive());
        System.out.println("Is Secure? " + toolbox.isSecure());
    }
}
