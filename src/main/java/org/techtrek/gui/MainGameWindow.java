package org.techtrek.gui;

import net.miginfocom.swing.MigLayout;
import org.techtrek.logic.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainGameWindow extends JPanel implements ActionListener {
    int numberOfMines;
    int gridSizeX;
    int gridSizeY;

    JButton gameOptionsBtn;
    JButton helpBtn;

    JLabel gameTimer;
    JLabel gameEmoji;
    JLabel displayNumberOfMines;

    public MainGameWindow(int numberOfMines, int gridSizeX, int gridSizeY) {
        this.numberOfMines = numberOfMines;
        this.gridSizeX = gridSizeX;
        this.gridSizeY = gridSizeY;

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel gameBar = new JPanel(new MigLayout("gapx 10"));
        gameBar.setPreferredSize(new Dimension(500, 40));
        gameBar.setBackground(new Color(46, 46, 46));

        gameOptionsBtn = new JButton("Game");
        helpBtn = new JButton("Help");
        JButton[] gameBarBtns = {gameOptionsBtn, helpBtn};
        for(JButton button: gameBarBtns) {
            button.addActionListener(this);
            button.setContentAreaFilled(false);
            button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button.setForeground(Color.WHITE);
            button.setFont(new Font("Arial", Font.BOLD, 16));
            button.setPreferredSize(new Dimension(80, 34));
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    button.setContentAreaFilled(true);
                    button.setBackground(new Color(213, 248, 251));
                    button.setForeground(new Color(2, 21, 23));

                }
                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseEntered(e);
                    button.setContentAreaFilled(false);
                    button.setForeground(Color.WHITE);
                }
            });
            gameBar.add(button);
        }

        JPanel gameStatus = new JPanel();
        gameStatus.setPreferredSize(new Dimension(500, 30));
        gameStatus.setLayout(new MigLayout("insets 0, gap 10"));

        JLabel gameTimer = new JLabel("00:00");
        JLabel gameEmoji = new JLabel("Emoji");
        JLabel displayNumberOfMines = new JLabel("Mines: " + numberOfMines);

        JLabel[] labels = {gameTimer, gameEmoji, displayNumberOfMines};
        for (JLabel label: labels) {
            label.setForeground(Color.red);
            label.setFont(new Font("Digital-7", Font.BOLD, 25));
        }

        gameStatus.add(gameTimer, "pushy, align left, gapleft 15");
        gameStatus.add(gameEmoji, "pushx, align center, gapleft 80");
        gameStatus.add(displayNumberOfMines, "pushx, align right, gapright 15");

        topPanel.add(gameBar, BorderLayout.NORTH);
        topPanel.add(gameStatus, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);

        JPanel gameArea = new JPanel();
        gameArea.setBackground(Color.green);
        //draw to the board
        new Board(gameArea, gridSizeX, gridSizeY,gameTimer);
        add(gameArea, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object clickedBtn = e.getSource();
        Window window = SwingUtilities.getWindowAncestor(this);
        if(clickedBtn == helpBtn) {
            String message = "<html>For tutorial, visit: <a href=\"https://en.wikipedia.org/wiki/Minesweeper_(video_game)\">Wikipedia</a><br>" +
                    "For bug report visit: <a href=\"https://github.com/MosetiObadiah/Minesweeper/issues\">GitHub</a></html>";

            JOptionPane.showMessageDialog( window, message, "Minesweeper Information", JOptionPane.INFORMATION_MESSAGE);


        } else if (clickedBtn == gameOptionsBtn) {
            new ShowDialog().dialog(window, "Menu", new ButtonPanel());
        }
    }
}