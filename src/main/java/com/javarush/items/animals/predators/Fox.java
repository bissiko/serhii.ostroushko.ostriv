package com.javarush.items.animals.predators;

import com.javarush.items.Organism;
import com.javarush.service.Type;

public class Fox extends Predator {
    public int lifeLevel;
    public final int numMax;
    public final double eatMax;
    public final int speedMax;
    public double weight;
    public Fox(){
        numMax = 30;
        lifeLevel = 100;
        weight = 8;
        speedMax = 2;
        eatMax = 2;
    }
    @Override
    public Type getType(){
        return Type.FOX;
    }
    @Override
    public Organism reproduce() {
        return this;
    }
}
