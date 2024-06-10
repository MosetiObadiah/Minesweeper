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

    public Board(JPanel panel, int gridSizeX, int gridSizeY, JLabel timerLabel) {
        this.panel = panel;
        this.gridSizeY = gridSizeY;
        this.gridSizeX = gridSizeX;
        this.timerLabel = timerLabel;
        panel.setLayout(new GridLayout(gridSizeX, gridSizeY));

        int numberOfButtons = gridSizeX * gridSizeY;

        JButton[] fields = new JButton[numberOfButtons];
        for (int i = 0; i < numberOfButtons; i++) {
            fields[i] = new JButton(String.valueOf(i + 1));
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
    }
}
