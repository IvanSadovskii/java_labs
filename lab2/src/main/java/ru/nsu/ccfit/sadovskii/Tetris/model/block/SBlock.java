package ru.nsu.ccfit.sadovskii.Tetris.model.block;

import ru.nsu.ccfit.sadovskii.Tetris.model.Block;


public class SBlock implements Block {

    int[][] pattern = {
            {0, 0}, {1, 0}, {0, 1}, {-1, 1}
    };

    @Override
    public int[][] getPattern() {
        return pattern;
    }

    @Override
    public void setPattern(int[][] newPattern) {
        this.pattern = newPattern;
    }

    @Override
    public int getSize() {
        return pattern.length;
    }
}
