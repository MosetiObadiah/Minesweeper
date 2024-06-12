package org.techtrek.gui;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() {
        setTitle("Minesweeper");
        setLocation(50, 50);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //TODO change default size of panel depending on the number of mines
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
