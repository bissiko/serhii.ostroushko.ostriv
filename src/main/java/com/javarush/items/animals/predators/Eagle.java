package com.javarush.items.animals.predators;

import com.javarush.items.Organism;
import com.javarush.service.Type;

public class Eagle extends Predator{
    public int lifeLevel;
    public final int numMax;
    public final double eatMax;
    public final int speedMax;
    public double weight;
    public Eagle(){
        numMax = 20;
        lifeLevel = 100;
        weight = 6;
        speedMax = 3;
        eatMax = 1;
    }
    @Override
    public Type getType(){
        return Type.EAGLE;
    }
    @Override
    public Organism reproduce() {
        return this;
    }
}
