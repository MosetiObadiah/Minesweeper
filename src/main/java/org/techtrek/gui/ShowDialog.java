package org.techtrek.gui;

import javax.swing.*;
import java.awt.*;

public class ShowDialog {
    public void dialog(Window window, String title, JPanel panel) {
        JDialog dialog = new JDialog(window, title);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.add(panel);
        dialog.setLocationRelativeTo(window);
        dialog.pack();
        dialog.setVisible(true);
    }
}
