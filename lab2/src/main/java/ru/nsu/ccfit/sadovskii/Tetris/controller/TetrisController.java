package ru.nsu.ccfit.sadovskii.Tetris.controller;

import ru.nsu.ccfit.sadovskii.Tetris.event.TetrisEvent;
import ru.nsu.ccfit.sadovskii.Tetris.event.EventQueue;
import ru.nsu.ccfit.sadovskii.Tetris.model.*;
import ru.nsu.ccfit.sadovskii.Tetris.gameview.TetrisView;


public class TetrisController implements Runnable{

    private int width, height;
    private Field field;
    private Field preview;
    private BlockFactory factory;
    private Block currentBlock;
    private Block nextBlock;
    private BlockAdapter fieldAdapter;
    private BlockAdapter previewAdapter;
    private TetrisView view;
    private EventQueue<TetrisEvent> eventQueue;
    private Score score;
    private static final int preview_width = 5;
    private static final int preview_height = 5;
    private boolean isScoreset;


    public TetrisController(int width, int height) {
        this.width = width;
        this.height = height;
        createGame(width, height);
    }

    private void createGame(int width, int height) {
        score = new Score();
        field = new Field(width, height);
        preview = new Field(preview_width, preview_height);
        factory = new BlockFactory();
        currentBlock = factory.createRandomBlock();
        nextBlock = factory.createRandomBlock();
        fieldAdapter = new BlockAdapter(currentBlock, field, field.getWidth() / 2, 0);
        previewAdapter = new BlockAdapter(nextBlock, preview, preview.getWidth() / 2, 0);
        eventQueue = new EventQueue<>();
    }

    public void run() {


        view = new TetrisView(field, preview, score, eventQueue);
        view.run();

        while (true) {
            if (eventQueue.hasEvent()) {
                TetrisEvent tetrisEvent = eventQueue.getEvent();
                switch (tetrisEvent) {
                    case NEW_GAME:
                        isScoreset = false;
                        createGame(width, height);
                        view.stop();
                        createGame(width, height);
                        TetrisView new_view = new TetrisView(field, preview, score, eventQueue);
                        new_view.run();
                        break;
                    case MOVE_LEFT:
                        moveBlockLeft();
                        break;
                    case MOVE_RIGHT:
                        moveBlockRight();
                        break;
                    case ROTATE_LEFT:
                        rotateBlockLeft();
                        break;
                    case ROTATE_RIGHT:
                        rotateBlockRight();
                        break;
                    case FALL:
                        fallBlock();
                        break;
                    case GAME_STEP:
                        makeStep();
                        break;
                    case GAME_CLOSED:
                        endGame();
                        break;
                }
            }
        }
    }

    public void makeStep() {
        if (!fieldAdapter.move(0, 1)) {
            for (int i = 0; i < field.getWidth(); i++) {
                if (field.getPointAt(i, 0).getType() != null) {
                    endGame();
                    return;
                }
            }
            score.add(field.clearFilledRows());
            currentBlock = nextBlock;
            fieldAdapter = new BlockAdapter(currentBlock, field, field.getWidth() / 2, 0);
            nextBlock = factory.createRandomBlock();
            previewAdapter.setBlock(nextBlock);
        }
    }

    private void endGame() {
        if(!isScoreset) Score.save(score.get());
        isScoreset = true;
    }

    public void moveBlockLeft() {
        fieldAdapter.move(-1, 0);
    }

    public void moveBlockRight() {
        fieldAdapter.move(1, 0);
    }

    public void fallBlock() {
        fieldAdapter.fall();
    }

    public void rotateBlockLeft() {
        fieldAdapter.rotateLeft();
    }

    public void rotateBlockRight() {
        fieldAdapter.rotateRight();
    }
}
