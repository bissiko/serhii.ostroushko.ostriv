package com.javarush.items.animals.herbivores;

import com.javarush.items.Organism;
import com.javarush.service.TypeHerbivore;

public class Caterpillar   extends Herbivore {
    public int lifeLevel;
    public final int numMax;
    public final double eatMax;
    public final int speedMax;
    public double weight;
    public Caterpillar(){
        numMax = 1000;
        lifeLevel = 100;
        weight = 0.01;
        speedMax = 0;
        eatMax = 0;
    }
    @Override
    public TypeHerbivore getType(){
        return TypeHerbivore.CATERPILLAR;
    }
    @Override
    public Organism reproduce() {
        return this;
    }
}

