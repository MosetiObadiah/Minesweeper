package org.techtrek.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class HighScorePanel extends JPanel {
    public HighScorePanel() {
        super();
        String[] columnNames = {"#", "Today", "This Week", "Overall"};
        Object[][] data = {};

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        model.addRow(new Object[]{"1", "Obadiah: 10", "00:00", "00:00"});
        model.addRow(new Object[]{"2", "Obadiah: 20", "00:00", "00:00"});
        model.addRow(new Object[]{"3", "Obadiah: 30", "00:00", "00:00"});
        model.addRow(new Object[]{"4", "Obadiah: 10", "00:00", "00:00"});

        JTable table = new JTable(model);

        this.add(new JScrollPane(table));
        table.setRowHeight(20);
    }
}