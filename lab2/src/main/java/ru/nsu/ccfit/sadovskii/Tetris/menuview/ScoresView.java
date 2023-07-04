package ru.nsu.ccfit.sadovskii.Tetris.menuview;

import ru.nsu.ccfit.sadovskii.Tetris.model.Score;

import javax.swing.*;
import java.util.List;

public class ScoresView extends JFrame {

    List<Integer> scoreArrayList;
    private static final int NUMBER_OF_RECORDS = 5;
    private static final int J_WIDTH = 300;
    private static final int J_HEIGHT = 150;

    public ScoresView() {
        scoreArrayList = Score.getResults();

        JTextArea textArea = new JTextArea();
        int numberOfShowingRecords = NUMBER_OF_RECORDS < scoreArrayList.size() ? NUMBER_OF_RECORDS : scoreArrayList.size();
        for (Integer i = 1; i <= numberOfShowingRecords; i++) {
            textArea.append(i + ": " + scoreArrayList.get(scoreArrayList.size()-i) + "\n");
        }

        add(textArea);
        setSize(J_WIDTH, J_HEIGHT);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setFocusable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
