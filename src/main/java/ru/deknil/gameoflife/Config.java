package ru.deknil.gameoflife;

import java.awt.*;

/**
 * @Author Deknil
 * @GitHub <a href=https://github.com/Deknil>https://github.com/Deknil</a>
 * @Date 03.02.2024
 * @Description Main application configuration file
 * <p></p>
 * GameOfLife © 2024. All rights reserved.
 */
public class Config {
    public static final String WINDOW_TITLE = "The Game of Life"; // Window title
    public static final int WINDOW_WIDTH = 1280; // Game map width
    public static final int WINDOW_HEIGHT = 720; // Game map height
    public static final int CELL_SIZE = 2; // Size of cells on the game map
    public static final int CELL_MAX_INDEX_X = Config.WINDOW_WIDTH / Config.CELL_SIZE; // Maximum allowed horizontal cell index
    public static final int CELL_MAX_INDEX_Y = Config.WINDOW_HEIGHT / Config.CELL_SIZE; // Maximum allowed vertical cell index
    public static final float CELL_CHANCE_ALIVE = 0.3f; // Chance of a living cell appearing at the start
    public static final int[] CELL_SAVE_RULE = new int[]{2, 3}; // Number of neighbors with which a cell survives
    public static final int[] CELL_BORN_RULE = new int[]{3}; // Number of neighbors at which a cell is born
    public static final int GAME_SPEED = 10; // Game speed in ms.

    public final static Color BACKGROUND_COLOR = new Color(10, 10, 10, 255); // Canvas background color
    public final static Color GRID_COLOR = new Color(255, 255, 255, 5); // Game grid color on canvas
    public final static Color CELL_ALIVE_COLOR = new Color(100, 100, 50, 255); // Color of a living cell
}
