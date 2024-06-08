package org.techtrek.logic;

import org.techtrek.panels.GameWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Board {
    JButton[] fields;
    Boolean areButtonsEnabled;
    GameWindow gameWindow;

    public Board(JPanel panel, int mines, int gridSize, GameWindow gameWindow) {
        panel.setLayout(new GridLayout(gridSize, gridSize, 1, 2));
        this.gameWindow = gameWindow;

        int numberOfFields = gridSize * gridSize;

        fields = new JButton[numberOfFields];
        for (int i = 0; i < numberOfFields; i++) {
            fields[i] = new JButton();
            fields[i].setPreferredSize(new Dimension(07,47));
            //on click remove any hovered panels and show game area
            fields[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    //System.out.println("Disabled button clicked!");
                    disableAllButtons(true);
                    gameWindow.hidePanels();
                }
            });
            panel.add(fields[i]);

        }
    }
    public void disableAllButtons(Boolean areButtonsEnabled) {
        this.areButtonsEnabled = areButtonsEnabled;
        for(JButton button: fields) {
            button.setEnabled(areButtonsEnabled);
        }
    }
}