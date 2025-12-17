package com.example.JavaLab5_1;

import java.awt.BorderLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class DateTimeCenterApp extends JFrame {

    private JLabel dateTimeLabel;
    private SimpleDateFormat formatter;

    public DateTimeCenterApp() {
        setTitle("Date & Time");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center window

        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        dateTimeLabel = new JLabel();
        dateTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateTimeLabel.setVerticalAlignment(SwingConstants.CENTER);
        dateTimeLabel.setFont(new Font("Arial", Font.BOLD, 24));

        add(dateTimeLabel, BorderLayout.CENTER);

        // Update time every second
        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();

        updateTime(); // initial call
    }

    private void updateTime() {
        dateTimeLabel.setText(formatter.format(new Date()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DateTimeCenterApp().setVisible(true);
        });
    }
}
