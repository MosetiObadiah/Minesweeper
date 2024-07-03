package org.techtrek.logic;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.techtrek.logic.Board.Minebuttons;

public class MinePlacer {

    static ArrayList<Board.Minebuttons> mineList;
    Random random = new Random();
    int numberOfMines;

    int gridSizeX;
    int gridSizeY;

    static JButton[][] buttons;

    public MinePlacer(Board.Minebuttons[][] buttons, int numberOfMines, int gridSizeX, int gridSizeY) {
        this.gridSizeX = gridSizeX;
        this.gridSizeY = gridSizeY;
        this.numberOfMines = numberOfMines;
        this.buttons = buttons;
        this.mineList = new ArrayList<>();

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
                mineList.add(buttons[row][col]);
                isABtnAMine[row][col] = true;
                minesPlaced++;
            }
        }
        
        // new NumberPlacer(buttons, gridSizeX, gridSizeY, isABtnAMine);
    }

    static void revealMines(){
        for (int i = 0; i < mineList.size(); i++) {
            Board.Minebuttons button = mineList.get(i);
            button.setText("💣");
            button.setForeground(Color.BLACK);
            button.setFont(new Font("Arial Unicode MS", Font.PLAIN, 25));
        }
        JOptionPane.showMessageDialog(null, "Game Over");
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                Minebuttons thisbuttons=(Minebuttons) buttons[i][j];
                thisbuttons.setEnabled(false);
            }
        }
    }

    
   /*  public void checkIfUserClickedMine(Boolean isFirstClick, JButton clickedBtn) {
        if (!isFirstClick && clickedBtn.getIcon() != null) {
            JOptionPane.showMessageDialog(null, "Game Over");
            //TODO reset or end game after user fails
        }
    }*/
}
