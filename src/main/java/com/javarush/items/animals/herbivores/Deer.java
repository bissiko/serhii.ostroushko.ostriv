package com.javarush.items.animals.herbivores;

import com.javarush.items.Organism;
import com.javarush.service.TypeHerbivore;

public class Deer extends Herbivore {
    public int lifeLevel;
    public final int numMax;
    public final double eatMax;
    public final int speedMax;
    public double weight;
    public Deer(){
        numMax = 20;
        lifeLevel = 100;
        weight = 400;
        speedMax = 2;
        eatMax = 50;
    }
    @Override
    public TypeHerbivore getType(){
        return TypeHerbivore.DEER;
    }
    @Override
    public Organism reproduce() {
        return this;
    }
}
