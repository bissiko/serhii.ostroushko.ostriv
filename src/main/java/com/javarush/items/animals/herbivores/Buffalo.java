package com.javarush.items.animals.herbivores;

import com.javarush.items.Organism;
import com.javarush.service.TypeHerbivore;

public class Buffalo   extends Herbivore {
    public int lifeLevel;
    public final int numMax;
    public final double eatMax;
    public final int speedMax;
    public double weight;
    public Buffalo(){
        numMax = 10;
        lifeLevel = 100;
        weight = 700;
        speedMax = 3;
        eatMax = 100;
    }
    @Override
    public TypeHerbivore getType(){
        return TypeHerbivore.BUFFALO;
    }
    @Override
    public Organism reproduce() {
        return this;
    }
}

