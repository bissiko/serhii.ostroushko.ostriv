package com.javarush.items.animals.herbivores;

import com.javarush.items.Organism;
import com.javarush.service.TypeHerbivore;

public class Mouse extends Herbivore {
    public int lifeLevel;
    public final int numMax;
    public final double eatMax;
    public final int speedMax;
    public double weight;
    public Mouse(){
        numMax = 500;
        lifeLevel = 100;
        weight = 0.05;
        speedMax = 1;
        eatMax = 0.01;
    }
    @Override
    public TypeHerbivore getType(){
        return TypeHerbivore.MOUSE;
    }
    @Override
    public Organism reproduce() {
        return this;
    }
}
