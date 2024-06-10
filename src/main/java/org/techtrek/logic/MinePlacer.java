package org.techtrek.logic;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MinePlacer {

    Random random = new Random();
    int numberOfMines = 10;
    ImageIcon img;

    public MinePlacer(JButton[] buttons) {
        Boolean[][] isABtnAMine = new Boolean[9][9];
        
        for (int i = 0; i < isABtnAMine.length; i++) {
            for (int j = 0; j < isABtnAMine[i].length; j++) {
                isABtnAMine[i][j] = false;
            }
        }

        int minesPlaced = 0;
        while (minesPlaced < numberOfMines) {
            int row = random.nextInt(9);
            int col = random.nextInt(9);
            if (!isABtnAMine[row][col]) {
                isABtnAMine[row][col] = true;
                minesPlaced++;
            }
        }

        img = new ImageIcon(getClass().getResource("../assets/referenceImages/smallBomb.jpg"));
        Image image = img.getImage();
        Image scaledImage = image.getScaledInstance(buttons[0].getWidth(), buttons[0].getHeight(), Image.SCALE_SMOOTH);
        img = new ImageIcon(scaledImage);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (isABtnAMine[i][j]) {
                    buttons[i * 9 + j].setIcon(img);
                }
            }
        }
    }
}
