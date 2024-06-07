package org.techtrek;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() {
        setTitle("MineSweeper");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setSize(new Dimension(500 , 450));

        setVisible(true);
    }
}
