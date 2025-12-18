package com.example.JavaLab6_3;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartStopButtons {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ball Control");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // create the ball panel and add it to the center of the frame
        RandomBallMove ballPanel = new RandomBallMove();
        frame.add(ballPanel, BorderLayout.CENTER);

        // create the button panels
        JPanel buttonPanel = new JPanel();
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Pause");

        // add action listeners to the buttons
        startButton.addActionListener(e -> ballPanel.startBall());
        stopButton.addActionListener(e -> ballPanel.pauseBall());

        // add the buttons to the button panel
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);

        // add the button panel to the south of the frame
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
