package org.techtrek.gui;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Welcome extends JPanel implements ActionListener {
    int numberOfMines;
    int gridSizeX;

    int gridSizeY;

    public int getNumberOfMines() {
        return numberOfMines;
    }

    public void setNumberOfMines(int numberOfMines) {
        this.numberOfMines = numberOfMines;
    }

    Frame frame;

    JLabel title = new JLabel("Minesweeper");
    JButton easyBtn = new JButton("Easy");
    JButton mediumBtn = new JButton("Medium");
    JButton hardBtn = new JButton("Hard");

    public Welcome(Frame frame) {
        this.frame = frame;
        setLayout(new MigLayout());
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new MigLayout("align"));

        title.setFont(new Font("Arial", Font.BOLD, 44));
        centerPanel.add(title, "wrap");
        centerPanel.setPreferredSize(new Dimension(300, 300));


        JButton[] buttons = {easyBtn, mediumBtn, hardBtn};
        for (JButton button: buttons) {
            button.addActionListener(this);
            button.setPreferredSize(new Dimension(150, 70));
            button.setForeground(new Color(2, 21, 23));
            centerPanel.add(button, "wrap , gapx 50");
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    button.setBackground(new Color(213, 248, 251));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    button.setBackground(new Color(255, 255, 255));
                }
            });
        }

        add(centerPanel, "gapx 20%, gapy 16%");

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object clickedBtn = event.getSource();
        if(clickedBtn == easyBtn) {
            numberOfMines = 10;
            gridSizeX = 9;
            gridSizeY = 9;
            frame.switchPanel(new MainGameWindow(numberOfMines, gridSizeX, gridSizeY));

        } else if(clickedBtn == mediumBtn) {
            numberOfMines = 40;
            gridSizeX = 16;
            gridSizeY = 16;
            frame.switchPanel(new MainGameWindow(numberOfMines, gridSizeX, gridSizeY));

        } else if (clickedBtn == hardBtn) {
            numberOfMines = 99;
            gridSizeX = 30;
            gridSizeY = 16;
            frame.switchPanel(new MainGameWindow(numberOfMines, gridSizeX, gridSizeY));

        }
    }
}