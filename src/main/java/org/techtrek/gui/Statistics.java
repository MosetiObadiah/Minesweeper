package org.techtrek.gui;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class Statistics extends JPanel {
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

        JButton closeBtn = new JButton("Close");
        JButton resetBtn = new JButton("Reset");
        add(closeBtn, "split 2, gapx 20");
        add(resetBtn);
    }
}
