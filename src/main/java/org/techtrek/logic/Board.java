package org.techtrek.logic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board implements ActionListener {

    int gridSizeX;
    int gridSizeY;
    int numberOfMines;
    JPanel panel;

    Timer timer;
    int elapsedTime;
    String timeFormatted;
    JLabel timerLabel;
    boolean notClicked = true;

    JButton[][] fields;
    int position;

    MinePlacer minePlacer;

    String CLickedBtnPosition;

    public void setNotClicked(boolean notClicked) {
        this.notClicked = notClicked;
        placeMines();
    }

    //remove old mines map, put fresh random map
    private void placeMines() {
        minePlacer = new MinePlacer(fields, numberOfMines, gridSizeX, gridSizeY, CLickedBtnPosition);
    }

    public Board(JPanel panel, int gridSizeX, int gridSizeY, JLabel timerLabel, int numberOfMInes) {
        this.panel = panel;
        this.gridSizeY = gridSizeY;
        this.numberOfMines = numberOfMInes;
        this.gridSizeX = gridSizeX;
        this.timerLabel = timerLabel;
        panel.setLayout(new GridLayout(gridSizeX, gridSizeY));

        fields = new JButton[gridSizeX][gridSizeY];
        for (int i = 0; i < gridSizeX; i++) {
           for(int j = 0; j < gridSizeY; j++){
               fields[i][j] = new JButton(String.valueOf(i * 9 + j));
               fields[i][j].addActionListener(this);
               panel.add(fields[i][j]);
           }
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

        System.out.println(((JButton) e.getSource()).getText());
        timer.start();
        if(notClicked) {
            placeMines();
            CLickedBtnPosition = ((JButton) e.getSource()).getText();
            notClicked = false;
        }
        //TODO not clicked below not working, fix
        minePlacer.checkIfUserClickedMine(notClicked, (JButton) e.getSource());
    }
}
