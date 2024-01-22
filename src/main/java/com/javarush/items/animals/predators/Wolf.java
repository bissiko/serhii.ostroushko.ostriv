package com.javarush.items.animals.predators;

import com.javarush.items.Organism;
import com.javarush.service.Type;

public class Wolf extends Predator {
    public int lifeLevel;
    public final int numMax;
    public final double eatMax;
    public final int speedMax;
    public double weight;
    public Wolf(){
        numMax = 30;
        lifeLevel = 100;
        weight = 50;
        speedMax = 3;
        eatMax = 8;
    }
    @Override
    public Type getType(){
        return Type.WOLF;
    }
    @Override
    public Organism reproduce() {
        return this;
    }

}
