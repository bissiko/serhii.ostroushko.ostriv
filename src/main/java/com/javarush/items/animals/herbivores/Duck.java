package com.javarush.items.animals.herbivores;

import com.javarush.items.Organism;
import com.javarush.service.TypeHerbivore;

public class Duck   extends Herbivore {
    public int lifeLevel;
    public final int numMax;
    public final double eatMax;
    public final int speedMax;
    public double weight;
    public Duck(){
        numMax = 200;
        lifeLevel = 100;
        weight = 1;
        speedMax = 4;
        eatMax = 0.15;
    }
    @Override
    public TypeHerbivore getType(){
        return TypeHerbivore.DUCK;
    }
    @Override
    public Organism reproduce() {
        return this;
    }
}

