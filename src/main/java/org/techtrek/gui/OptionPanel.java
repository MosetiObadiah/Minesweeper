package org.techtrek.gui;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OptionPanel extends JPanel implements ActionListener {
    JButton okBtn;
    JButton cancelBtn;

    public OptionPanel() {
        super();
        setLayout(new MigLayout());
        JLabel difficultyLabel = new JLabel("Difficulty *");
        add(difficultyLabel, "wrap");

        JRadioButton[] radioGroup = {
                new JRadioButton("Beginner(10mines, 9x9 tile grid)"),
                new JRadioButton("Intermediate(40mines, 16x16 tile grid)"),
                new JRadioButton("Advanced(99mines, 16x30 tile grid)")
        };

        //TODO add listener anc actions for radioBtns
        for (JRadioButton radioButton: radioGroup) {
            add(radioButton, "wrap");
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);

                }
            });
        }

        //TODO add actions to the checkBoxes
        JCheckBox playSounds = new JCheckBox("Play sounds");
        JCheckBox openArea = new JCheckBox("Allow open area(If used no high scores are recorded) *");
        JCheckBox showMines = new JCheckBox("Show mines");

        add(playSounds, "wrap");
        add(openArea, "wrap");
        add(showMines, "wrap");

        //TODO record player name and write use it for high score
        JLabel playerName = new JLabel("Player Name");
        JTextField playerNameField = new JTextField();

        add(playerName, "wrap");
        add(playerNameField, "wrap");

        JLabel notice = new JLabel("* changes will apply in a new game");
        add(notice, "wrap");
        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");

        add(okBtn, "split 2, gapx 20");
        add(cancelBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object clickedBtn = e.getSource();
        if(clickedBtn == okBtn) {
            //TODO save the settings changes

        } else if (clickedBtn == cancelBtn) {
            //TODO clear all entries

        }
    }
}
