package com.example.Java2Lab_01;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Java2Lab1 extends Application {
    @Override
    public void start(Stage stage) {
        Text text = new Text("Welcome to java");
        text.setFill(Color.RED);
        text.setFont(Font.font("System", FontWeight.BOLD, 20));
        StackPane header = new StackPane(text);
        
        Reflection reflection = new Reflection();
        reflection.setFraction(0.3);
        reflection.setTopOpacity(0.6);
        reflection.setBottomOpacity(0.2);
        reflection.setTopOffset(2);
        text.setEffect(reflection);


        header.setPadding(new Insets(10, 10, 50, 10)); // Set padding to 10 for all sides
        
        Stop[] stops = new Stop[] { 
            new Stop(0, Color.BLACK),
            new Stop(0.5, Color.WHITE), // Middle color 
            new Stop(1, Color.BLACK) // End color 
        };
        
        // Initialize the gradient (params startX, startY, endX, endY, cycleMethod (means to repeat the gradient), stops)
        LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops);
        
        // Apply the gradient
        header.setBackground(new Background(new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)));
        
        // scene creation (params root, width, height)
        Scene scene = new Scene(header, 300, 250);
        stage.setTitle("Java Label program");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
