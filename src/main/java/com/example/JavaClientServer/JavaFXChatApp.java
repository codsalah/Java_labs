package com.example.JavaClientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class JavaFXChatApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        showChatWindow("Salah", 100, 200);
        showChatWindow("ITI", 600, 200);
    }

    private void showChatWindow(String name, double x, double y) {
        Stage stage = new Stage();
        stage.setTitle("Chat Room - " + name);

        // Use TextFlow for rich text (different colors)
        TextFlow messageArea = new TextFlow();
        messageArea.setPadding(new Insets(10));
        
        ScrollPane scrollPane = new ScrollPane(messageArea);
        scrollPane.setFitToWidth(true);
        
        // Auto-scroll to bottom
        messageArea.heightProperty().addListener((obs, oldVal, newVal) -> scrollPane.setVvalue(1.0));

        TextField inputField = new TextField();
        inputField.setPromptText("Type a message...");
        inputField.setDisable(true);
        
        Button sendButton = new Button("Send");
        sendButton.setDisable(true);

        // This is the input box itself
        HBox inputBox = new HBox(10, inputField, sendButton);
        inputBox.setPadding(new Insets(10));
        HBox.setHgrow(inputField, Priority.ALWAYS);

        // This is the layout of the chat window
        BorderPane layout = new BorderPane();
        layout.setCenter(scrollPane);
        layout.setBottom(inputBox);

        // This is the scene of the chat window
        Scene scene = new Scene(layout, 400, 450);
        stage.setScene(scene);
        stage.setX(x);
        stage.setY(y);

        // This is the event handler for the close button
        stage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });

        // This is the thread that handles the client
        Thread clientThread = new Thread(() -> {
            try (Socket socket = new Socket("localhost", 12345);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                Platform.runLater(() -> {
                    inputField.setDisable(false);
                    sendButton.setDisable(false);
                    sendButton.setOnAction(e -> {
                        String msg = inputField.getText();
                        if (!msg.isEmpty()) {
                            out.println(name + ": " + msg);
                            inputField.clear();
                        }
                    });
                    inputField.setOnAction(e -> sendButton.fire());
                });

                String line;
                while ((line = in.readLine()) != null) {
                    final String rawMessage = line;
                    Platform.runLater(() -> {
                        Text textNode = new Text(rawMessage + "\n");
                        // Logic: If message starts with MY name, it's Light Green. Otherwise, Light Blue.
                        if (rawMessage.startsWith(name + ":")) {
                            textNode.setFill(Color.web("#32CD32")); // LimeGreen / LightGreen
                            textNode.setStyle("-fx-font-weight: bold;");
                        } else {
                            textNode.setFill(Color.web("#00BFFF")); // DeepSkyBlue / LightBlue
                        }
                        messageArea.getChildren().add(textNode);
                    });
                }
            } catch (IOException e) {
                Platform.runLater(() -> {
                    Text errorText = new Text("Connection Error: " + e.getMessage() + "\n");
                    errorText.setFill(Color.RED);
                    messageArea.getChildren().add(errorText);
                    inputField.setDisable(true);
                    sendButton.setDisable(true);
                });
            }
        });
        clientThread.setDaemon(true);
        clientThread.start();

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
