package com.javarush.items.animals.herbivores;

import com.javarush.items.Organism;
import com.javarush.service.TypeHerbivore;

public class Rabbit extends Herbivore {
    public int lifeLevel;
    public final int numMax;
    public final double eatMax;
    public final int speedMax;
    public double weight;
    public Rabbit(){
        numMax = 150;
        lifeLevel = 100;
        weight = 2;
        speedMax = 2;
        eatMax = 0.45;
    }
    @Override
    public TypeHerbivore getType(){
        return TypeHerbivore.RABBIT;
    }
    @Override
    public Organism reproduce() {
        return this;
    }
}
