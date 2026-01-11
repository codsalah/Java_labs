package com.example.JavaClientServer;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient {
    // Input and output streams for communication with the server
    private BufferedReader in;
    private PrintWriter out;
    
    // GUI components
    private final JFrame frame = new JFrame("Chat Room");
    private final JTextField textField = new JTextField(40);
    private final JTextArea messageArea = new JTextArea(8, 40);

    public ChatClient() {
        // GUI Setup
        textField.setEditable(false);
        messageArea.setEditable(false);
        // text field is at the bottom
        frame.getContentPane().add(textField, BorderLayout.SOUTH);
        // message area is at the top
        frame.getContentPane().add(new JScrollPane(messageArea), BorderLayout.CENTER);
        frame.pack();

        // Send message on 'Enter'
        textField.addActionListener(e -> {
            if (out != null) {
                out.println(textField.getText());
                textField.setText("");
            }
        });
    }

    private void run() {
        String serverAddress = "localhost"; 
        try {
            Socket socket = new Socket(serverAddress, 12345);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            textField.setEditable(true);

            // Read messages from server in a loop
            String line;
            while ((line = in.readLine()) != null) {
                final String msg = line;
                javax.swing.SwingUtilities.invokeLater(() -> messageArea.append(msg + "\n"));
            }
        } catch (IOException e) {
            javax.swing.SwingUtilities.invokeLater(() -> 
                JOptionPane.showMessageDialog(frame, "Connection Error: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE));
        } finally {
            frame.setVisible(false);
            frame.dispose();
        }
    }

    public static void main(String[] args) {
        ChatClient client = new ChatClient();
        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.frame.setVisible(true);
        // Run networking in a background thread to keep GUI responsive
        new Thread(client::run).start();
    }

    public JTextField getTextField() {
        return textField;
    }
}