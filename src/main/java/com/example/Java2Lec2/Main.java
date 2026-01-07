package com.example.Java2Lec2;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main {
    public static class Appp extends Application {
        @Override
        public void start(Stage stage) {
            System.out.println("Java2Lec2 Main App started");
        }
    }

    public static void main(String[] args) {
        Application.launch(Appp.class, args);
    }
}
