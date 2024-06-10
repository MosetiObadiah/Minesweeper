package org.techtrek.logic;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class MinePlacer {
    Random random = new Random();
    int randomNumber;
    int numberOfMines = 10;

    public MinePlacer(JButton[] buttons) {

        Boolean[] isABtnAMine = new Boolean[81];
        Arrays.fill(isABtnAMine, false);
        for (int i = 0; i < numberOfMines; i++){
            randomNumber = random.nextInt(81);
            if(!isABtnAMine[randomNumber]){
                isABtnAMine[randomNumber] = true;
            }
        }

        for (int i = 0; i < isABtnAMine.length; i++) {
            if(isABtnAMine[i]) {
                buttons[i].setBackground(Color.red);
            }
        }
    }
}

