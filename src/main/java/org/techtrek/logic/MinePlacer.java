package org.techtrek.logic;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class MinePlacer {

    Random random = new Random();
    int randomNumber;
    int numberOfMines = 10;

    ImageIcon img;

    public MinePlacer(JButton[] buttons) {

        Boolean[] isABtnAMine = new Boolean[81];
        Arrays.fill(isABtnAMine, false);
        for (int i = 0; i < numberOfMines; i++) {
            randomNumber = random.nextInt(81);
            if (!isABtnAMine[randomNumber]) {
                isABtnAMine[randomNumber] = true;
            }
        }

        img = new ImageIcon(getClass().getResource("../assets/referenceImages/smallBomb.jpg"));

        for (int i = 0; i < isABtnAMine.length; i++) {
            if (isABtnAMine[i]) {
                Image image = img.getImage(); 
                Image scaledImage = image.getScaledInstance(buttons[i].getWidth(), buttons[i].getHeight(), java.awt.Image.SCALE_SMOOTH); 
                img = new ImageIcon(scaledImage);  

                buttons[i].setIcon(img);
            }
        }
    }
}
