package org.techtrek.logic;

import javax.swing.*;
import java.awt.*;

public class Board {
    int gridSizeX;
    int gridSizeY;
    JPanel panel;

    public Board(JPanel panel, int gridSizeX, int gridSizeY) {
        this.gridSizeY = gridSizeY;
        this.gridSizeX = gridSizeX;
        panel.setLayout(new GridLayout(gridSizeX, gridSizeY));

        int numberOfButtons = gridSizeX * gridSizeY;

        JButton[] fields = new JButton[numberOfButtons];
        for(int i  = 0; i < numberOfButtons; i++) {
            fields[i] = new JButton(String.valueOf(i+1));
            panel.add(fields[i]);
        }

    }
}
