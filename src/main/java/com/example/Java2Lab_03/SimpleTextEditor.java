package com.example.Java2Lab_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SimpleTextEditor extends Application {

    private TextArea textArea;
    private Stage primaryStage;
    private File currentFile;

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;

        textArea = new TextArea();

        // File Menu Button
        MenuButton fileMenu = new MenuButton("_File");
        fileMenu.setMnemonicParsing(true);
        
        // File -> New Item
        MenuItem newItem = new MenuItem("New");
        newItem.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        newItem.setOnAction(e -> {
            textArea.clear();
            currentFile = null;
            updateTitle();
        });

        // File -> Open Item
        MenuItem openItem = new MenuItem("Open");
        openItem.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
        openItem.setOnAction(e -> openFile());

        // File -> Save Item
        MenuItem saveItem = new MenuItem("Save");
        saveItem.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
        saveItem.setOnAction(e -> saveFile());

        // File -> Save As Item
        MenuItem saveAsItem = new MenuItem("Save As...");
        saveAsItem.setOnAction(e -> saveFileAs());

        // File -> Exit Item
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
        exitItem.setOnAction(e -> stage.close());

        // Put the File Menu Items in the File Menu Button
        fileMenu.getItems().addAll(newItem, openItem, saveItem, saveAsItem, new SeparatorMenuItem(), exitItem);

        // Edit Menu Button
        MenuButton editMenu = new MenuButton("_Edit");
        editMenu.setMnemonicParsing(true);

        // Edit -> Cut Item 
        MenuItem cutItem = new MenuItem("Cut");
        cutItem.setOnAction(e -> textArea.cut());

        // Edit -> Copy Item
        MenuItem copyItem = new MenuItem("Copy");
        copyItem.setOnAction(e -> textArea.copy());

        // Edit -> Paste Item
        MenuItem pasteItem = new MenuItem("Paste");
        pasteItem.setOnAction(e -> textArea.paste());

        // Edit -> Delete Item
        MenuItem deleteItem = new MenuItem("Delete");
        deleteItem.setOnAction(e -> textArea.replaceSelection(""));

        // Edit -> Select All Items
        MenuItem selectAllItem = new MenuItem("Select All");
        selectAllItem.setOnAction(e -> textArea.selectAll());

        // Put the Edit Menu Items in the Edit Menu Button
        editMenu.getItems().addAll(cutItem, copyItem, pasteItem, deleteItem, selectAllItem);

        // Help Menu Button
        MenuButton helpMenu = new MenuButton("_Help");
        helpMenu.setMnemonicParsing(true);

        // Help -> About Item
        MenuItem aboutItem = new MenuItem("About");
        aboutItem.setOnAction(e -> showAboutDialog());

        // Put the Help Menu Item in the Help Menu Button
        helpMenu.getItems().add(aboutItem);

        // Put the three MenuButtons in an HBox (this replaces MenuBar)
        HBox menuBar = new HBox(8, fileMenu, editMenu, helpMenu);
        menuBar.setPadding(new Insets(4));

        // ToolBar
        javafx.scene.control.ToolBar toolBar = new javafx.scene.control.ToolBar();

        // ToolBar -> New Button
        javafx.scene.control.Button newBtn = new javafx.scene.control.Button("New");
        newBtn.setOnAction(e -> newItem.fire());

        // ToolBar -> Open Button
        javafx.scene.control.Button openBtn = new javafx.scene.control.Button("Open");
        openBtn.setOnAction(e -> openItem.fire());

        // ToolBar -> Save Button
        javafx.scene.control.Button saveBtn = new javafx.scene.control.Button("Save");
        saveBtn.setOnAction(e -> saveItem.fire());

        // 
        toolBar.getItems().addAll(newBtn, openBtn, saveBtn);

        javafx.scene.layout.VBox topContainer = new javafx.scene.layout.VBox(menuBar, toolBar);

        BorderPane root = new BorderPane();
        root.setTop(topContainer);
        root.setCenter(textArea);

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Simple Text Editor");
        stage.setScene(scene);
        stage.show();
    }

    // Open File (Low + High Level Streams)
    private void openFile() {
        // FileChooser (Low Level stream)
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt", "*.java", "*.md"));
        File file = chooser.showOpenDialog(primaryStage);

        if (file != null) {
            try (
                // FileInputStream (Low Level stream)
                FileInputStream fis = new FileInputStream(file);
                // BufferedReader (High Level stream)
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis))
            ) {
                // StringBuilder (Low Level stream)
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                textArea.setText(sb.toString());
                currentFile = file;
                updateTitle();
            } catch (IOException ex) {
                showError("Error opening file: " + ex.getMessage());
            }
        }
    }

    // Save File (Low + High Level Streams)
    private void saveFile() {
        if (currentFile != null) {
            saveToFile(currentFile);
        } else {
            saveFileAs();
        }
    }

    private void saveFileAs() {
        FileChooser chooser = new FileChooser();
        // FileChooser Extension Filter
        chooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Text Files", "*.txt"),
            new FileChooser.ExtensionFilter("Java Files", "*.java"),
            new FileChooser.ExtensionFilter("Markdown Files", "*.md"),
            new FileChooser.ExtensionFilter("All Files", "*.*")
        );
        // FileChooser Save Dialog (Low Level stream)
        File file = chooser.showSaveDialog(primaryStage);

        if (file != null) {
            saveToFile(file);
            currentFile = file;
            updateTitle();
        }
    }

    private void saveToFile(File file) {
        try (
            // FileOutputStream (Low Level stream)
            FileOutputStream fos = new FileOutputStream(file);

            // OutputStreamWriter (Bridge) and BufferedWriter (High Level stream)
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos))
        ) {
            writer.write(textArea.getText());

            // Successful Save Alert
            showInfo("File saved successfully: " + file.getName());
        } catch (IOException ex) {
            // Error Save Alert
            showError("Error saving file: " + ex.getMessage());
        }
    }

    private void showInfo(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show(); 
    }

    private void updateTitle() {
        if (currentFile != null) {
            primaryStage.setTitle("Simple Text Editor - " + currentFile.getName());
        } else {
            primaryStage.setTitle("Simple Text Editor");
        }
    }

    // About Dialog
    private void showAboutDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Simple Text Editor");
        alert.setContentText(
                "Version: 1.0\n" +
                "Developed using JavaFX\n" +
                "Lab Exercise: Text Editor\n" +
                "Supports basic file operations"
        );
        alert.showAndWait();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
