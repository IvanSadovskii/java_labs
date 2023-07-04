package ru.nsu.ccfit.sadovskii.Tetris.menuview;

import javax.swing.*;

public class AboutView extends JFrame {
    private static final int J_WIDTH = 300;
    private static final int J_HEIGHT = 150;

    public AboutView() {
        JTextArea textArea = new JTextArea("TETRIS BY SADOVSKII IVAN 21206");
        add(textArea);
        setSize(J_WIDTH, J_HEIGHT);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setFocusable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
