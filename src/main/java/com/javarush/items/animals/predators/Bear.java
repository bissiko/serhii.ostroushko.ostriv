package com.javarush.items.animals.predators;

import com.javarush.items.Organism;
import com.javarush.service.Type;

public class Bear extends Predator {
    public int lifeLevel;
    public final int numMax;
    public final double eatMax;
    public final int speedMax;
    public double weight;
    public Bear(){
        numMax = 5;
        lifeLevel = 100;
        weight = 500;
        speedMax = 2;
        eatMax = 80;
    }
    @Override
    public Type getType(){
        return Type.BEAR;
    }
    @Override
    public Organism reproduce() {
        return this;
    }
}