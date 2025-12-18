package com.example.JavaLab6_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DragOval {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Drag Oval");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        OvalPanel panel = new OvalPanel();
        frame.add(panel);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    static class OvalPanel extends JPanel {
        private int OvalX = 100;
        private int OvalY = 100;
        private final int OvalWidth = 50;
        private final int OvalHeight = 50;

        private boolean dragging = false;
        private int offsetX, offsetY;

        public OvalPanel() {
            // Mouse listener to detect links
        }
    }
}
