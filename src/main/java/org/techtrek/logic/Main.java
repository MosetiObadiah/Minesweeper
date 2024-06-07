package org.techtrek.logic;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import org.techtrek.panels.Frame;

import javax.swing.*;
import org.techtrek.panels.WelcomePage;

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame();
        
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
            SwingUtilities.invokeLater(() -> {
                frame.switchPanel(new WelcomePage(frame));
            });
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
    }
}