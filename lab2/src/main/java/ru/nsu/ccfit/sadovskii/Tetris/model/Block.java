package ru.nsu.ccfit.sadovskii.Tetris.model;


public interface Block {

    int[][] getPattern();


    void setPattern(int[][] newPattern);

    int getSize();
}
