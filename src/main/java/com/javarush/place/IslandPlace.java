package com.javarush.place;

public class IslandPlace {
    public static final int width = 120;
    public static final int height = 20;
    public static final Cell[][] cells = new Cell[width][height];

    public Cell[][] getCells() {
        return cells;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}
