package org.techtrek.gui;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Statistics extends JPanel implements ActionListener {
    JButton closeBtn;
    JButton resetBtn;

    public Statistics() {
        super();
        setLayout(new MigLayout());

        JLabel statistics = new JLabel("Statistics");
        add(statistics, "wrap");

        JLabel beginner = new JLabel("Beginner");
        add(beginner, "wrap");

        JLabel bestTimes = new JLabel("Best Times");
        add(bestTimes, "wrap");

        JLabel gamesPlayed = new JLabel("Games Played: 7");
        add(gamesPlayed, "wrap");

        JLabel gamesWon = new JLabel("Games Won: 3");
        add(gamesWon, "wrap");

        JLabel winPercentage = new JLabel("Win Percentage: 42.86%");
        add(winPercentage, "wrap");

        JLabel longestWinningStreak = new JLabel("Longest Winning Streak: 2");
        add(longestWinningStreak, "wrap");

        JLabel longestLosingStreak = new JLabel("Longest Losing Streak: 2");
        add(longestLosingStreak, "wrap");

        JLabel currentWins = new JLabel("Current Wins: 0");
        add(currentWins, "wrap");

        JLabel currentLosses = new JLabel("Current Losses: 0");
        add(currentLosses, "wrap");

        closeBtn = new JButton("Close");
        resetBtn = new JButton("Reset");

        closeBtn.addActionListener(this);
        resetBtn.addActionListener(this);

        add(closeBtn, "split 2, gapx 20");
        add(resetBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == closeBtn) {
            //TODO close the dialog
        } else if (e.getSource() == resetBtn) {
            //TODO reset user inputs
        }
    }
}
