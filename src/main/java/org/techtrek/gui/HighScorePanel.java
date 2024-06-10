package org.techtrek.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class HighScorePanel extends JPanel {
    public HighScorePanel() {
        super();
        String[] columnNames = {"#", "Today", "This Week", "Overall"};
        Object[][] data = {};

        //TODO add real timer data to table in correct format
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        model.addRow(new Object[]{"1", "Stella:30", "00:30", "00:00"});
        model.addRow(new Object[]{"2", "Obadiah:27 ", "00:27", "00:00"});
        model.addRow(new Object[]{"3", "Marshal:56l", "00:56", "00:00"});
        model.addRow(new Object[]{"4", "John:40", "00:40", "00:00"});

        JTable table = new JTable(model);

        this.add(new JScrollPane(table));
        table.setRowHeight(20);
    }
}