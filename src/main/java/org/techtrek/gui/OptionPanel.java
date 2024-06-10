package org.techtrek.gui;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class OptionPanel extends JPanel {
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

        for (JRadioButton radioButton: radioGroup) {
            add(radioButton, "wrap");
        }

        JCheckBox playSounds = new JCheckBox("Play sounds");
        JCheckBox openArea = new JCheckBox("Allow open area(If used no high scores are recorded) *");
        JCheckBox showMines = new JCheckBox("Show mines");

        add(playSounds, "wrap");
        add(openArea, "wrap");
        add(showMines, "wrap");

        JLabel playerName = new JLabel("Player Name");
        JTextField playerNameField = new JTextField();

        add(playerName, "wrap");
        add(playerNameField, "wrap");

        JLabel notice = new JLabel("* changes will apply in a new game");
        add(notice, "wrap");
        JButton okBtn = new JButton("OK");
        JButton cancelBtn = new JButton("Cancel");

        add(okBtn, "split 2, gapx 20");
        add(cancelBtn);
    }
}
