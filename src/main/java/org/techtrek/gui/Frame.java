package org.techtrek.gui;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() {
        setTitle("Minesweeper");
        setLocation(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(500, 600));

        setVisible(true);
    }

    public void switchPanel(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel);
        revalidate();
        repaint();
    }

}
