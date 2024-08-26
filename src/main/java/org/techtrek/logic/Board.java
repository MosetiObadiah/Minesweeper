package org.techtrek.logic;

import java.awt.Font;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.SwingUtilities;

public class Board implements ActionListener {

    int gridSizeX;
    int gridSizeY;
    int numberOfMines;
    int remainingMines;
    JPanel panel;

    Timer timer;
    int elapsedTime;
    String timeFormatted;
    JLabel timerLabel;

    Minebuttons button;
    Minebuttons[][] tiles;

    MinePlacer minePlacer;

    JButton resetfieldButton;
    JLabel displayNoOfminesJLabel;

    int count;

    class Minebuttons extends JButton {

        int r, c;

        public Minebuttons(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public Board(JPanel panel, int gridSizeX, int gridSizeY, JLabel timerLabel, int numberOfMines, JButton resetfieldButton,JLabel displayNoOfminesJLabel) {
        this.panel = panel;
        this.gridSizeY = gridSizeY;
        this.numberOfMines = numberOfMines;
        this.remainingMines = numberOfMines;
        this.gridSizeX = gridSizeX;
        this.timerLabel = timerLabel;
        this.tiles = new Minebuttons[gridSizeX][gridSizeY];
        this.resetfieldButton = resetfieldButton;
        this.displayNoOfminesJLabel=displayNoOfminesJLabel;

        panel.setLayout(new GridLayout(gridSizeX, gridSizeY));

        for (int r = 0; r < gridSizeX; r++) {
            for (int c = 0; c < gridSizeY; c++) {
                button = new Minebuttons(r, c);
                tiles[r][c] = button;

                button.setFocusable(false);
                button.setFont(new Font("Arial Unicode MS", Font.PLAIN, 35));
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        Minebuttons button = (Minebuttons) e.getSource();
                        if (SwingUtilities.isLeftMouseButton(e)) {
                            System.out.println("left click detected");
                            if ("".equals(button.getText())) {
                                if (MinePlacer.mineList.contains(button)) {
                                    timer.stop();
                                    MinePlacer.revealMines();
                                    int response = JOptionPane.showConfirmDialog(panel, "You hit a mine! Restart game?", "Game Over", JOptionPane.YES_NO_OPTION);
                                    if (response == JOptionPane.YES_OPTION) {
                                        resetGame();
                                    }
                                } else {
                                    checkAdjacentMines(button.r, button.c);
                                }
                            } 
                        }else if (SwingUtilities.isRightMouseButton(e)) {
                            System.out.println("Right click detected");
                            if ("".equals(button.getText())) {
                                button.setText("🚩");
                                remainingMines--;
                                displayNoOfminesJLabel.setText(Integer.toString(remainingMines));
                            } else if ("🚩".equals(button.getText())) {
                                button.setText("");
                                remainingMines++;
                                displayNoOfminesJLabel.setText(Integer.toString(remainingMines));
                            }
                        }
                    }
                });
                panel.add(button);
            }
        }

        resetfieldButton.addActionListener(this);

        timer = new Timer(1000, (ActionEvent e) -> {
            elapsedTime++;
            int minutes = elapsedTime / 60;
            int seconds = elapsedTime % 60;
            timeFormatted = String.format("%02d:%02d", minutes, seconds);
            timerLabel.setText(timeFormatted);
        });

        placeMines();
    }

    private void placeMines() {
        minePlacer = new MinePlacer(tiles, numberOfMines, gridSizeX, gridSizeY);
    }

    void checkAdjacentMines(int r, int c) {
        if (r < 0 || r >= gridSizeX || c < 0 || c >= gridSizeY) {
            return;
        }

        Minebuttons currentBtn = tiles[r][c];
        if (!currentBtn.isEnabled()) {
            return;
        }
        currentBtn.setEnabled(false);

        int numberOfAdjacentMines = 0;
  
        numberOfAdjacentMines += countAdjacentMines(r - 1, c - 1); // top-left
        numberOfAdjacentMines += countAdjacentMines(r - 1, c);     // top
        numberOfAdjacentMines += countAdjacentMines(r - 1, c + 1); // top right
        numberOfAdjacentMines += countAdjacentMines(r, c + 1);     // right
        numberOfAdjacentMines += countAdjacentMines(r + 1, c + 1); // btm right
        numberOfAdjacentMines += countAdjacentMines(r + 1, c);     // btm
        numberOfAdjacentMines += countAdjacentMines(r + 1, c - 1); // btm left
        numberOfAdjacentMines += countAdjacentMines(r, c - 1);     // left

        if (numberOfAdjacentMines > 0) {
            currentBtn.setText(Integer.toString(numberOfAdjacentMines));
        } else {
            currentBtn.setText("");
            checkAdjacentMines(r - 1, c - 1);
            checkAdjacentMines(r - 1, c);
            checkAdjacentMines(r - 1, c + 1);
            checkAdjacentMines(r, c + 1);
            checkAdjacentMines(r + 1, c + 1);
            checkAdjacentMines(r + 1, c);
            checkAdjacentMines(r + 1, c - 1);
            checkAdjacentMines(r, c - 1);
        }
    }

    int countAdjacentMines(int r, int c) {
        if (r < 0 || r >= gridSizeX || c < 0 || c >= gridSizeY) {
            return 0;
        }
        if (MinePlacer.mineList.contains(tiles[r][c])) {
            return 1;
        }
        return 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetfieldButton) {
            resetGame();
        }
    }

    void resetGame() {
        for (int r = 0; r < gridSizeX; r++) {
            for (int c = 0; c < gridSizeY; c++) {
                tiles[r][c].setEnabled(true);
                tiles[r][c].setText("");
            }
        }
        elapsedTime = 0;
        numberOfMines=remainingMines;
        timer.restart();
        placeMines();
    }
}
