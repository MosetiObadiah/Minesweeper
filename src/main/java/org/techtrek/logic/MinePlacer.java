package org.techtrek.logic;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MinePlacer {

    Random random = new Random();
    int numberOfMines;
    ImageIcon img;

    int gridSizeX;
    int gridSizeY;

    public MinePlacer(JButton[][] buttons, int numberOfMines, int gridSizeX, int gridSizeY) {
        this.gridSizeX = gridSizeX;
        this.gridSizeY = gridSizeY;
        this.numberOfMines = numberOfMines;

        Boolean[][] isABtnAMine = new Boolean[gridSizeX][gridSizeY];
        
        for (int i = 0; i < gridSizeX; i++) {
            for (int j = 0; j < gridSizeY; j++) {
                isABtnAMine[i][j] = false;
            }
        }

        int minesPlaced = 0;
        while (minesPlaced < numberOfMines) {
            int row = random.nextInt(gridSizeX);
            int col = random.nextInt(gridSizeY);
            if (!isABtnAMine[row][col]) {
                isABtnAMine[row][col] = true;
                minesPlaced++;
            }
        }

        img = new ImageIcon("src/main/java/org/techtrek/assets/referenceImages/smallBomb.jpg");
        Image image = img.getImage();
        Image scaledImage = image.getScaledInstance(buttons[0][0].getWidth(), buttons[0][0].getHeight(), Image.SCALE_SMOOTH);
        img = new ImageIcon(scaledImage);

        for (int i = 0; i < gridSizeX; i++) {
            for (int j = 0; j < gridSizeY; j++) {
                if (isABtnAMine[i][j]) {
                    buttons[i][j].setIcon(img);
                }
            }
        }
        new NumberPlacer(buttons, gridSizeX, gridSizeY, isABtnAMine);
    }
}