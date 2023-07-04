package ru.nsu.ccfit.sadovskii.Tetris;

import ru.nsu.ccfit.sadovskii.Tetris.controller.TetrisController;

public class Main {
    public static void main(String[] args) {
        (new TetrisController(10, 22)).run();
    }
}
