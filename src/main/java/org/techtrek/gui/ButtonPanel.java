package org.techtrek.gui;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel implements ActionListener{
    String[] options = {"New Game", "High scores", "Statistics", "Options", "Exit"};
    JButton[] buttons;
    ShowDialog showDialog = new ShowDialog();

    public ButtonPanel() {
        super();
        setLayout(new MigLayout());

        buttons = new JButton[options.length];
        for (int i = 0; i < options.length; i++) {
            buttons[i] = new JButton(options[i]);
            buttons[i].addActionListener(this);
            add(buttons[i], "wrap");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object clickedBtn = e.getSource();

        if (clickedBtn == buttons[0]) {
            //TODO add new game

        } else if (clickedBtn == buttons[1]) {
            showDialog.dialog(SwingUtilities.getWindowAncestor(this), "High Score", new HighScorePanel());

        } else if (clickedBtn == buttons[2]) {
            showDialog.dialog(SwingUtilities.getWindowAncestor(this), "Statistics", new Statistics());

        } else if (clickedBtn == buttons[3]) {
            showDialog.dialog(SwingUtilities.getWindowAncestor(this), "Options", new OptionPanel());

        } else if (clickedBtn == buttons[4]) {
            System.exit(0);
        }
    }
}

