package org.techtrek.logic;

import javax.swing.*;
import java.awt.*;

public class NumberPlacer {
    int count;

    JButton[][] buttons;
    Boolean[][] isABtnAMine;

    public NumberPlacer(JButton[][] buttons, int gridSizeX, int gridSizeY, Boolean[][] isABtnAMine) {
        this.buttons = buttons;
        this.isABtnAMine = isABtnAMine;

        //All middle Buttons
        for (int i = 1; i < gridSizeX - 1; i++) {
            for (int j = 1; j < gridSizeY - 1; j++) {
                checkNorth(i, j);
                checkEast(i, j);
                checkSouth(i, j);
                checkWest(i, j);
                checkNorthEast(i, j);
                checkSouthEast(i, j);
                checkSouthWest(i, j);
                checkNorthWest(i, j);
                addCorrectNumbers(i, j);
            }
        }
        //second loop bcz I couldn't come up with good if statements on top
        //All implementations are minus corner buttons
        for (int j = 1; j < gridSizeY - 1; j++) {
            //top row
            int i = 0 ;
            checkWest(i, j);
            checkSouthWest(i, j);
            checkSouth(i, j);
            checkSouthEast(i, j);
            checkEast(i, j);
            addCorrectNumbers(i, j);
        }
        for (int j = 1; j < gridSizeY - 1; j++) {
            //bottom row
            int i = gridSizeX - 1 ;
            checkWest(i, j);
            checkNorthWest(i, j);
            checkNorth(i, j);
            checkNorthEast(i, j);
            checkEast(i, j);
            addCorrectNumbers(i, j);
        }
        for (int i = 1; i < gridSizeX - 1; i++) {
            //left row
            int j = 0 ;
            checkNorth(i, j);
            checkNorthEast(i, j);
            checkEast(i, j);
            checkSouthEast(i, j);
            checkSouth(i, j);
            addCorrectNumbers(i, j);
        }
        for (int i = 1; i < gridSizeX - 1; i++) {
            //right row
            int j = gridSizeY - 1 ;
            checkSouth(i, j);
            checkSouthWest(i, j);
            checkWest(i, j);
            checkNorthWest(i, j);
            checkNorth(i, j);
            addCorrectNumbers(i, j);
        }

        //corner cases
        for (int i = 0; i < gridSizeX; i++) {
            for (int j = 0; j < gridSizeY; j++) {
                //top right
                if(i == 0 && j == gridSizeY-1) {
                    checkWest(i, j);
                    checkSouthWest(i, j);
                    checkSouth(i, j);
                    addCorrectNumbers(i, j);
                }
                //top left
                else if(i == 0 && j == 0) {
                    checkEast(i, j);
                    checkSouthEast(i, j);
                    checkSouth(i, j);
                    addCorrectNumbers(i, j);
                }
                //bottom left
                else if(i == gridSizeX - 1 && j == 0) {
                    checkNorth(i, j);
                    checkNorthEast(i, j);
                    checkEast(i, j);
                    addCorrectNumbers(i, j);
                }
                //bottom right
                else if(i == gridSizeX - 1 && j == gridSizeY - 1) {
                    checkNorth(i, j);
                    checkNorthWest(i, j);
                    checkWest(i, j);
                    addCorrectNumbers(i, j);
                }

            }
        }
    }

    private void addCorrectNumbers(int i, int j) {
        buttons[i][j].setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        buttons[i][j].setText(String.valueOf(count));
        count = 0;
    }

    private void checkNorth(int i, int j) {
        if (isABtnAMine[(i-1)][j]) {
            count +=1;
        }
    }

    private void checkEast(int i, int j) {
        if (isABtnAMine[(i)][j+1]) {
            count +=1;
        }
    }

    private void checkSouth(int i, int j) {
        if (isABtnAMine[(i+1)][j]) {
            count +=1;
        }
    }

    private void checkSouthWest(int i, int j) {

        if (isABtnAMine[(i+1)][j-1]) {
            count +=1;
        }
    }



    private void checkSouthEast(int i, int j) {
        if (isABtnAMine[(i+1)][j+1]) {
            count +=1;
        }
    }

    private void checkNorthEast(int i, int j) {
        if (isABtnAMine[(i-1)][j+1]) {
            count +=1;
        }
    }

    private void checkNorthWest(int i, int j) {
        if (isABtnAMine[(i-1)][j-1]) {
            count +=1;
        }
    }

    private void checkWest(int i, int j) {
        if (isABtnAMine[(i)][j-1]) {
            count +=1;
        }
    }
}
