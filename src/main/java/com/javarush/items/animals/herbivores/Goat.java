package com.javarush.items.animals.herbivores;

import com.javarush.items.Organism;
import com.javarush.service.TypeHerbivore;

public class Goat extends Herbivore {
    public int lifeLevel;
    public final int numMax;
    public final double eatMax;
    public final int speedMax;
    public double weight;
    public Goat(){
        numMax = 140;
        lifeLevel = 100;
        weight = 60;
        speedMax = 3;
        eatMax = 10;
    }
    @Override
    public TypeHerbivore getType(){
        return TypeHerbivore.GOAT;
    }
    @Override
    public Organism reproduce() {
        return this;
    }
}

