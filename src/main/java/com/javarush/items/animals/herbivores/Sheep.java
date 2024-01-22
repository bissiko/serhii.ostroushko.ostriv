package com.javarush.items.animals.herbivores;

import com.javarush.items.Organism;
import com.javarush.service.TypeHerbivore;

public class Sheep extends Herbivore {
    public int lifeLevel;
    public final int numMax;
    public final double eatMax;
    public final int speedMax;
    public double weight;
    public Sheep(){
        numMax = 140;
        lifeLevel = 100;
        weight = 70;
        speedMax = 3;
        eatMax = 15;
    }
    @Override
    public TypeHerbivore getType(){
        return TypeHerbivore.SHEEP;
    }
    @Override
    public Organism reproduce() {
        return this;
    }
}

