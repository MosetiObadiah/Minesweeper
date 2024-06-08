package org.techtrek.panels;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    int defaultWindowWidth = 500;
    int defaultWindowHeight = 600;

    public Frame() {
        setTitle("MineSweeper 10");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        //TODO center the game window on player's screen
        setSize(new Dimension(defaultWindowWidth , defaultWindowHeight));

        setVisible(true);
    }
    
    public void switchPanel(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel);
        revalidate();
        repaint();
    }
}