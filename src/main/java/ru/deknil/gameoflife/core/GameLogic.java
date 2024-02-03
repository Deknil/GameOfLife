package ru.deknil.gameoflife.core;

import ru.deknil.gameoflife.Config;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author Deknil
 * @GitHub <a href=https://github.com/Deknil>https://github.com/Deknil</a>
 * @Date 03.02.2024
 * @Description The class responsible for processing game logic
 * <p></p>
 * GameOfLife © 2024. All rights reserved.
 */
public class GameLogic {
    private static Cell[][] cells = new Cell[Config.CELL_MAX_INDEX_X][Config.CELL_MAX_INDEX_Y];

    /**
     * Initializing game logic
     */
    public static void init() {
        // Filling the game map with cells
        for (int x = 0; x < Config.CELL_MAX_INDEX_X; x++) {
            for (int y = 0; y < Config.CELL_MAX_INDEX_Y; y++) {
                cells[x][y] = new Cell(x, y);

                // We revive a cell with a certain chance
                if (Math.random() < Config.CELL_CHANCE_ALIVE) {
                    cells[x][y].isAlive = true;
                }
            }
        }
    }

    /**
     * Obtaining neighboring cells for a given
     * @param cell main cell
     * @return array of neighboring cells
     */
    private static ArrayList<Cell> getCellNeighbors(Cell cell) {
        ArrayList<Cell> neighbors = new ArrayList<>();

        int[][] neighborsRule = new int[][] {
                // Up
                {cell.cellXIndex - 1, cell.cellYIndex - 1},
                {cell.cellXIndex, cell.cellYIndex - 1},
                {cell.cellXIndex + 1, cell.cellYIndex - 1},
                // Center Left and Right
                {cell.cellXIndex + 1, cell.cellYIndex},
                {cell.cellXIndex - 1, cell.cellYIndex},
                // Bottom
                {cell.cellXIndex - 1, cell.cellYIndex + 1},
                {cell.cellXIndex, cell.cellYIndex + 1},
                {cell.cellXIndex + 1, cell.cellYIndex + 1},
        };

        for (int[] rule : neighborsRule) {
            int x = rule[0];
            int y = rule[1];

            if (x < 0 || x > Config.CELL_MAX_INDEX_X - 1 || y < 0 || y > Config.CELL_MAX_INDEX_Y - 1) continue;

            Cell neighborCell = getCells()[x][y];
            neighbors.add(neighborCell);
        }

        return neighbors;
    }

    /**
     * Obtaining the number of living neighboring cells next to a given one
     * @param cell this cell
     * @return number of living neighbors
     */
    private static int getCountAliveNeighbors(Cell cell) {
        int count = 0;

        for (Cell neighbor : getCellNeighbors(cell)){
            if (neighbor.isAlive) count += 1;
        }

        return count;
    }

    /**
     * Getting an array of game cells
     * @return Array of game cells
     */
    public static Cell[][] getCells() {
        return cells;
    }

    /**
     * Game logic update method
     */
    public static void update() {
        Cell[][] tempCells = new Cell[Config.CELL_MAX_INDEX_X][Config.CELL_MAX_INDEX_Y];

        for (int x = 0; x < Config.CELL_MAX_INDEX_X; x++) {
            for (int y = 0; y < Config.CELL_MAX_INDEX_Y; y++) {
                Cell cell = cells[x][y];
                int aliveNeighbors = getCountAliveNeighbors(cell);

                tempCells[x][y] = new Cell(x, y);

                // Logic of cell preservation and birth
                if ((cell.isAlive && Utils.arrayContainsInt(Config.CELL_SAVE_RULE, aliveNeighbors)) || (!cell.isAlive && Utils.arrayContainsInt(Config.CELL_BORN_RULE, aliveNeighbors))) {
                    tempCells[x][y].isAlive = true;
                }
            }
        }

        for (int x = 0; x < Config.CELL_MAX_INDEX_X; x++) {
            System.arraycopy(tempCells[x], 0, cells[x], 0, Config.CELL_MAX_INDEX_Y);
        }
    }
}
