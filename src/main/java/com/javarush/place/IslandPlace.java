package com.javarush.place;

import com.javarush.service.InitParams;

public class IslandPlace {
    public static final int width = InitParams.widthIsland;
    public static final int height = InitParams.heightIsland;
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
