package ru.deknil.gameoflife.core;

import ru.deknil.gameoflife.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @Author Deknil
 * @GitHub <a href=https://github.com/Deknil>https://github.com/Deknil</a>
 * @Date 03.02.2024
 * @Description The canvas class on which game elements are drawn
 * <p></p>
 * GameOfLife © 2024. All rights reserved.
 */
public class Canvas extends JPanel {
    private final BufferedImage image = new BufferedImage(Config.CELL_MAX_INDEX_X * Config.CELL_SIZE,
            Config.CELL_MAX_INDEX_Y * Config.CELL_SIZE,
            BufferedImage.TYPE_INT_RGB);

    /**
     * Game map constructor
     */
    public Canvas() {
        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
    }

    /**
     * Drawing a game map
     */
    private void render() {
        Graphics2D g = image.createGraphics();
        g.setColor(Config.BACKGROUND_COLOR);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        renderCell(g);
        renderGrid(g);
    }

    /**
     * Drawing cells
     */
    private static void renderCell(Graphics2D g) {
        for (int x = 0; x < Config.CELL_MAX_INDEX_X; x++) {
            for (int y = 0; y < Config.CELL_MAX_INDEX_Y; y++) {
                Cell cell = GameLogic.getCells()[x][y];

                if (!cell.isAlive) continue;

                g.setColor(Config.CELL_ALIVE_COLOR);
                g.fillRect(cell.posStartX, cell.posStartY, Config.CELL_SIZE, Config.CELL_SIZE);
            }
        }
    }

    /**
     * Drawing a game map
     */
    private void renderGrid(Graphics2D g) {
        g.setColor(Config.GRID_COLOR);

        for (int x = 0; x < Config.CELL_MAX_INDEX_X; x++) {
            for (int y = 0; y < Config.CELL_MAX_INDEX_Y; y++) {
                Cell cell = GameLogic.getCells()[x][y];

                g.drawLine(cell.posStartX, cell.posStartY, cell.posEndX, cell.posStartY);
                g.drawLine(cell.posEndX, cell.posStartY, cell.posEndX, cell.posEndY);
            }
        }
    }

    /**
     * Canvas drawing logic
     */
    @Override
    public void paint(Graphics g) {
        render();
        ((Graphics2D)g).drawImage(image, null, 0, 0);
    }
}
