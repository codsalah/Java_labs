package com.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PersonDatabaseApp extends Application {

    // Database Objects
    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    // UI Fields
    private TextField txtId = new TextField();
    private TextField txtFirst = new TextField();
    private TextField txtMiddle = new TextField();
    private TextField txtLast = new TextField();
    private TextField txtEmail = new TextField();
    private TextField txtPhone = new TextField();

    @Override
    public void start(Stage stage) {
        
        // --- LAYOUT ---
        GridPane grid = new GridPane();
        grid.setHgap(10); 
        grid.setVgap(10);
        
        grid.addRow(0, new Label("ID"), txtId);
        grid.addRow(1, new Label("First Name"), txtFirst);
        grid.addRow(2, new Label("Middle Name"), txtMiddle);
        grid.addRow(3, new Label("Last Name"), txtLast);
        grid.addRow(4, new Label("Email"), txtEmail);
        grid.addRow(5, new Label("Phone"), txtPhone);

        // --- BUTTONS ---
        Button btnNew = new Button("New");
        Button btnUpdate = new Button("Update");
        Button btnDelete = new Button("Delete");
        
        Button btnFirst = new Button("First");
        Button btnPrev = new Button("Previous");
        Button btnNext = new Button("Next");
        Button btnLast = new Button("Last");
        Button btnCommit = new Button("Commit");
        Button btnRollback = new Button("Rollback");
        
        btnCommit.setStyle("-fx-base: green;");
        btnRollback.setStyle("-fx-base: red;");

        // --- BUTTON GROUPS ---
        HBox navBox = new HBox(10, btnFirst, btnPrev, btnNext, btnLast);
        navBox.setAlignment(Pos.CENTER);
        
        HBox crudBox = new HBox(10, btnNew, btnUpdate, btnDelete);
        crudBox.setAlignment(Pos.CENTER);
        
        HBox transBox = new HBox(10, btnCommit, btnRollback);
        transBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(15, grid, crudBox, navBox, transBox);
        root.setPadding(new Insets(20));

        // --- EVENT HANDLERS ---
        btnFirst.setOnAction(e -> navigate("FIRST"));
        btnNext.setOnAction(e -> navigate("NEXT"));
        btnPrev.setOnAction(e -> navigate("PREV"));
        btnLast.setOnAction(e -> navigate("LAST"));
        
        btnNew.setOnAction(e -> clearFields());
        btnUpdate.setOnAction(e -> saveRecord());
        btnDelete.setOnAction(e -> deleteRecord());
        
        btnCommit.setOnAction(e -> commitChanges());
        btnRollback.setOnAction(e -> rollbackChanges());

        // --- SHOW WINDOW ---
        Scene scene = new Scene(root, 550, 500);
        stage.setTitle("Person Database (Oracle)");
        stage.setScene(scene);
        stage.show();

        if (connect()) {
            loadData();
        }
    }

    // --- DATABASE CONNECTION ---
    private boolean connect() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
            String user = "system"; 
            String password = "Password123";

            con = DriverManager.getConnection(url, user, password);
            con.setAutoCommit(false); 
            System.out.println("Connected to Oracle Database successfully!");
            return true;
        } catch (Exception e) {
            System.err.println("Connection failed: " + e.getMessage());
            showAlert("Connection Error", "Check your password or if the Oracle Listener is running on port 1521.");
            return false;
        }
    }

    // --- LOAD DATA ---
    private void loadData() {
        if (con == null) return;
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT id, first_name, middle_name, last_name, email, phone FROM persons ORDER BY id");
            
            if (rs.first()) {
                fillFields();
            }
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
    }

    // --- FILL UI FROM CURRENT DB ROW ---
    private void fillFields() {
        try {
            txtId.setText(rs.getString(1));
            txtFirst.setText(rs.getString(2));
            txtMiddle.setText(rs.getString(3));
            txtLast.setText(rs.getString(4));
            txtEmail.setText(rs.getString(5));
            txtPhone.setText(rs.getString(6));
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
    }

    // --- NAVIGATION ---
    private void navigate(String where) {
        try {
            if (con == null || rs == null) return;
            
            switch (where) {
                case "FIRST" -> { if (rs.first()) fillFields(); }
                case "NEXT"  -> { if (!rs.isLast()) { rs.next(); fillFields(); } }
                case "PREV"  -> { if (!rs.isFirst()) { rs.previous(); fillFields(); } }
                case "LAST"  -> { if (rs.last()) fillFields(); }
            }
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
    }

    // --- SAVE LOGIC (INSERT OR UPDATE) ---
    private void saveRecord() {
        if (con == null) {
            showAlert("Error", "Save Failed: No database connection.");
            return;
        }
        try {
            String updateSQL = "UPDATE persons SET first_name=?, middle_name=?, last_name=?, email=?, phone=? WHERE id=?";
            PreparedStatement psUpdate = con.prepareStatement(updateSQL);
            psUpdate.setString(1, txtFirst.getText());
            psUpdate.setString(2, txtMiddle.getText());
            psUpdate.setString(3, txtLast.getText());
            psUpdate.setString(4, txtEmail.getText());
            psUpdate.setString(5, txtPhone.getText());
            psUpdate.setInt(6, Integer.parseInt(txtId.getText()));

            int rows = psUpdate.executeUpdate();

            if (rows == 0) {
                String insertSQL = "INSERT INTO persons (id, first_name, middle_name, last_name, email, phone) VALUES (?,?,?,?,?,?)";
                PreparedStatement psInsert = con.prepareStatement(insertSQL);
                psInsert.setInt(1, Integer.parseInt(txtId.getText()));
                psInsert.setString(2, txtFirst.getText());
                psInsert.setString(3, txtMiddle.getText());
                psInsert.setString(4, txtLast.getText());
                psInsert.setString(5, txtEmail.getText());
                psInsert.setString(6, txtPhone.getText());
                psInsert.executeUpdate();
                showAlert("Success", "New Record Inserted (Buffered).");
            } else {
                showAlert("Success", "Record Updated (Buffered).");
            }
            
            loadData(); 

        } catch (Exception e) { 
            showAlert("Error", "Save Failed: " + e.getMessage()); 
        }
    }

    // --- DELETE LOGIC ---
    private void deleteRecord() {
        if (con == null) {
            showAlert("Error", "Delete Failed: No database connection.");
            return;
        }
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM persons WHERE id=?");
            ps.setInt(1, Integer.parseInt(txtId.getText()));
            ps.executeUpdate();
            
            showAlert("Success", "Record Deleted (Buffered). Click Commit to Save.");
            loadData(); // Refresh UI
            
        } catch (Exception e) { 
            showAlert("Error", "Delete Failed: " + e.getMessage()); 
        }
    }

    // --- NEW / CLEAR FIELDS ---
    private void clearFields() {
        txtId.clear(); 
        txtFirst.clear(); 
        txtMiddle.clear(); 
        txtLast.clear(); 
        txtEmail.clear(); 
        txtPhone.clear();
        txtId.requestFocus(); 
    }

    // --- TRANSACTION CONTROL ---
    private void commitChanges() {
        if (con == null) return;
        try { 
            con.commit();
            showAlert("System", "Changes Committed to Oracle Database!"); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
    }

    private void rollbackChanges() {
        if (con == null) return;
        try { 
            con.rollback(); 
            loadData(); 
            showAlert("System", "Changes Rolled Back."); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.show();
    }
    // --- CLEANUP ---
    @Override
    public void stop() throws Exception {
        if (con != null && !con.isClosed()) {
            con.close();
            stmt.close();
            rs.close();
            System.out.println("Database connection closed successfully.");
        }
    }

    public static void main(String[] args) { 
        launch(); 
    }
}