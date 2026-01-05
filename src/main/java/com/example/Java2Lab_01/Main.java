package com.example.Java2Lab_01;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        /* ---------- Top (Header) ---------- */
        Label title = new Label("JavaFX Full Example");
        StackPane header = new StackPane(title);
        header.setPadding(new Insets(10));
        header.setStyle("-fx-background-color: lightgray;");

        /* ---------- Center (Main Content) ---------- */
        Label message = new Label("Waiting...");
        Button button = new Button("Click Me");

        button.setOnAction(e -> message.setText("Button clicked"));

        VBox centerBox = new VBox(10, message, button);
        centerBox.setAlignment(Pos.CENTER);

        /* ---------- Bottom (Footer) ---------- */
        Label footerText = new Label("Status: Ready");
        StackPane footer = new StackPane(footerText);
        footer.setPadding(new Insets(8));

        /* ---------- Root Layout ---------- */
        BorderPane root = new BorderPane();
        root.setTop(header);
        root.setCenter(centerBox);
        root.setBottom(footer);

        /* ---------- Scene & Stage ---------- */
        Scene scene = new Scene(root, 500, 350);

        stage.setTitle("JavaFX Program Structure");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
