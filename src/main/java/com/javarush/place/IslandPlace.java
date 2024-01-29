package com.javarush.place;

public class IslandPlace {
    private  int width = 3;
    private int height = 2;
    private final Cell[][] cells = new Cell[width][height];

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
