package ru.nsu.ccfit.sadovskii.Tetris.gameview;

import ru.nsu.ccfit.sadovskii.Tetris.event.TetrisEvent;
import ru.nsu.ccfit.sadovskii.Tetris.event.EventQueue;
import ru.nsu.ccfit.sadovskii.Tetris.menuview.AboutView;
import ru.nsu.ccfit.sadovskii.Tetris.menuview.ScoresView;
import ru.nsu.ccfit.sadovskii.Tetris.model.Field;
import ru.nsu.ccfit.sadovskii.Tetris.model.Score;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TetrisView extends JFrame implements ActionListener {
    private EventQueue<TetrisEvent> eventQueue;
    private Timer timer;
    private static final int EXIT_CODE = 0;
    private static final int TIMER_DELAY = 300;

    private static final int fieldView_HEIGHT = 440;
    private static final int fieldView_WEIGHT = 200;

    private static final int scoreView_HEIGHT = 50;
    private static final int scoreView_WEIGHT = 100;

    private static final int previewView_HEIGHT = 100;
    private static final int previewView_WEIGHT = 100;

    private static final int gamePanel_HEIGHT = 440;
    private static final int gamePanel_WEIGHT = 200;

    private static final int previewPanel_HEIGHT = 100;
    private static final int previewPanel_WEIGHT = 100;

    private static final int pointsPanel_HEIGHT = 50;
    private static final int pointsPanel_WEIGHT = 100;

    private static final int backPanel_HEIGHT = 440;
    private static final int backPanel_WEIGHT = 100;



    public TetrisView(Field field, Field preview, Score score, EventQueue<TetrisEvent> eventQueue) {

        timer = new Timer(TIMER_DELAY, this);
        this.eventQueue = eventQueue;
        addKeyListener(new TetrisInputHandler(eventQueue));

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);

        JMenuItem newGameMenuItem = new JMenuItem("New game");
        newGameMenuItem.addActionListener(e -> {
            new TetrisView(field, preview, score, eventQueue);

        });
        menu.add(newGameMenuItem);

        JMenuItem scoresMenuItem = new JMenuItem("Scores");
        scoresMenuItem.addActionListener(e -> new ScoresView());
        menu.add(scoresMenuItem);

        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener(e -> new AboutView());
        menu.add(aboutMenuItem);

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> System.exit(EXIT_CODE));
        menu.add(exitMenuItem);

        setJMenuBar(menuBar);

        createPanels(field, preview, score);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                eventQueue.addEvent(TetrisEvent.GAME_CLOSED);
            }
        });
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setFocusable(true);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);

    }

    void createPanels(Field field, Field preview, Score score) {
        FieldView fieldView = new FieldView(field);
        fieldView.setPreferredSize(new Dimension(fieldView_WEIGHT, fieldView_HEIGHT));

        FieldView previewView = new FieldView(preview);
        previewView.setPreferredSize(new Dimension(previewView_WEIGHT, previewView_HEIGHT));

        ScoreView scoreView = new ScoreView(score);
        scoreView.setPreferredSize(new Dimension(scoreView_WEIGHT, scoreView_HEIGHT));

        JPanel gamePanel = new JPanel();
        gamePanel.setPreferredSize(new Dimension(gamePanel_WEIGHT, gamePanel_HEIGHT));
        gamePanel.add(fieldView);

        JPanel previewPanel = new JPanel();
        previewPanel.setPreferredSize(new Dimension(previewPanel_WEIGHT, previewPanel_HEIGHT));
        previewPanel.add(previewView);

        JPanel pointsPanel = new JPanel();
        pointsPanel.setPreferredSize(new Dimension(pointsPanel_WEIGHT, pointsPanel_HEIGHT));
        pointsPanel.add(scoreView);

        JPanel backPanel = new JPanel();
        backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.Y_AXIS));
        backPanel.setPreferredSize(new Dimension(backPanel_WEIGHT, backPanel_HEIGHT));
        backPanel.add(previewPanel);
        backPanel.add(pointsPanel);

        add(gamePanel, BorderLayout.CENTER);
        add(backPanel, BorderLayout.EAST);
    }

    public void run() {
        timer.start();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        eventQueue.addEvent(TetrisEvent.GAME_STEP);
    }
}
