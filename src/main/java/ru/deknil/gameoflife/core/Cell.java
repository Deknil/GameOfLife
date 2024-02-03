package ru.deknil.gameoflife.core;

import ru.deknil.gameoflife.Config;

/**
 * @Author Deknil
 * @GitHub <a href=https://github.com/Deknil>https://github.com/Deknil</a>
 * @Date 03.02.2024
 * @Description Class that implements game cells
 * <p></p>
 * GameOfLife © 2024. All rights reserved.
 */
public class Cell {
    public int cellXIndex; // Horizontal cell index
    public int cellYIndex; // Vertical cell index
    public int posStartX = 0; // Horizontal coordinate of the upper left corner of the cell
    public int posStartY = 0; // Vertical coordinate of the upper left corner of the cell
    public int posEndX = 0; // Horizontal coordinate of the lower right corner of the cell
    public int posEndY = 0; // Vertical coordinate of the lower right corner of the cell
    public boolean isAlive = false; // Flag indicating whether the cell is alive

    /**
     * Game cell constructor
     * @param x horizontal index
     * @param y vertical index
     */
    public Cell(int x, int y) {
        cellXIndex = x;
        cellYIndex = y;
        posStartX = x * Config.CELL_SIZE;
        posStartY = y * Config.CELL_SIZE;
        posEndX = posStartX + Config.CELL_SIZE;
        posEndY = posStartY + Config.CELL_SIZE;
    }
}
