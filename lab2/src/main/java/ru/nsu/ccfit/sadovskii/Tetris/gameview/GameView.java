package ru.nsu.ccfit.sadovskii.Tetris.gameview;

import ru.nsu.ccfit.sadovskii.Tetris.model.block.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class GameView extends JPanel {
    private static final Color CUBE_COLOR = new Color(204, 102, 102);
    private static final Color LBLOCK_COLOR = new Color(102, 204, 102);
    private static final Color LINEBLOCK_COLOR = new Color(102, 102, 204);
    private static final Color MIRRORED_COLOR = new Color(204, 204, 102);
    private static final Color SBLOCK_COLOR = new Color(204, 102, 204);
    private static final Color TBLOCK_COLOR = new Color(102, 204, 204);
    private static final Color ZBLOCK_COLOR = new Color(218, 170, 0);


    static HashMap<Class<?>, Color> colorMap = new HashMap<>();
    static {
        colorMap.put(CubeBlock.class, CUBE_COLOR);
        colorMap.put(LBlock.class, LBLOCK_COLOR);
        colorMap.put(LineBlock.class, LINEBLOCK_COLOR);
        colorMap.put(MirroredLBlock.class, MIRRORED_COLOR);
        colorMap.put(SBlock.class, SBLOCK_COLOR);
        colorMap.put(TBlock.class, TBLOCK_COLOR);
        colorMap.put(ZBlock.class, ZBLOCK_COLOR);
    }

    int fieldHeight;
    int fieldWidth;

    public GameView(int width, int height) {
        fieldHeight = height;
        fieldWidth = width;
    }

    int squareHeight() {
        return (int) getSize().getHeight() / fieldHeight;
    }

    int squareWidth() {
        return (int) getSize().getWidth() / fieldWidth;
    }

    void drawSquare(Graphics g, int j, int i, Class<?> blockClass) {
        int x = j * squareWidth();
        int y = i * squareHeight();

        Color color = colorPicker(blockClass);

        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);

        g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight() - 1, x, y);
        g.drawLine(x, y, x + squareWidth() - 1, y);

        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight() - 1,
                x + squareWidth() - 1, y + squareHeight() - 1);
        g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1,
                x + squareWidth() - 1, y + 1);
    }

    private Color colorPicker(Class<?> blockClass) {
        return blockClass == null?  new Color(0,0,0) : colorMap.get(blockClass);
    }
}
