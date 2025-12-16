package com.example.JavaLec3;

import java.awt.Graphics;
import javax.swing.JPanel;

class CatPanel extends JPanel {
    // Simple GUI to say hello java
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Hello Java", 50, 50);
    }

    public void update() {
        repaint();
    }

}
