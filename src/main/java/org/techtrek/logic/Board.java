package org.techtrek.logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board implements ActionListener {

    int gridSizeX;
    int gridSizeY;
    JPanel panel;
    Timer timer;
    int elapsedTime;
    String timeFormatted;
    JLabel timerLabel;
    boolean notClicked = true;

    JButton[] fields;

    public void setNotClicked(boolean notClicked) {
        this.notClicked = notClicked;
        placeMines();
    }

    //remove old mines map, put fresh random map
    private void placeMines() {
        new MinePlacer(fields);
    }

    public Board(JPanel panel, int gridSizeX, int gridSizeY, JLabel timerLabel) {
        this.panel = panel;
        this.gridSizeY = gridSizeY;
        this.gridSizeX = gridSizeX;
        this.timerLabel = timerLabel;
        panel.setLayout(new GridLayout(gridSizeX, gridSizeY));

        int numberOfButtons = gridSizeX * gridSizeY;

        fields = new JButton[numberOfButtons];
        for (int i = 0; i < numberOfButtons; i++) {
            fields[i] = new JButton();
            fields[i].addActionListener(this);
            panel.add(fields[i]);
        }

        timer = new Timer(1000, (ActionEvent e) -> {
            elapsedTime++;
            int minutes = elapsedTime / 60;
            int seconds = elapsedTime % 60;
            timeFormatted = String.format("%02d:%02d", minutes, seconds);
            timerLabel.setText(timeFormatted);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(notClicked) {
            placeMines();
            notClicked = false;
        }
    }
}
