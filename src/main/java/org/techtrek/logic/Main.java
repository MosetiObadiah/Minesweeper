package org.techtrek.logic;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import org.techtrek.gui.Frame;
import org.techtrek.gui.Welcome;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame();
        try {
            //TODO add an option to change themes
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        SwingUtilities.invokeLater(() -> {
            frame.switchPanel(new Welcome(frame));
        });
    }
}