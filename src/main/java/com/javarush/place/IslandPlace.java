package com.javarush.place;

public class IslandPlace {
    private  int width = 12;
    private int height = 10;
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
