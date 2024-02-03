package ru.deknil.gameoflife.core;

/**
 * @Author Deknil
 * @GitHub <a href=https://github.com/Deknil>https://github.com/Deknil</a>
 * @Date 03.02.2024
 * @Description A set of auxiliary utilities for the application
 * <p></p>
 * GameOfLife © 2024. All rights reserved.
 */
public class Utils {
    /**
     * Checking the presence of a given number in the array
     * @param array array
     * @param value number
     * @return true - containing, false - missing
     */
    public static boolean arrayContainsInt(int[] array, int value) {
        for (int j : array) {
            if (j == value) {
                return true;
            }
        }
        return false;
    }
}
