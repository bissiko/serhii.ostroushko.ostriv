package com.javarush.items.animals.herbivores;

import com.javarush.items.Organism;
import com.javarush.service.TypeHerbivore;

public class Horse   extends Herbivore {
    public int lifeLevel;
    public final int numMax;
    public final double eatMax;
    public final int speedMax;
    public double weight;
    public Horse(){
        numMax = 20;
        lifeLevel = 100;
        weight = 400;
        speedMax = 4;
        eatMax = 60;
    }
    @Override
    public TypeHerbivore getType(){
        return TypeHerbivore.HORSE;
    }
    @Override
    public Organism reproduce() {
        return this;
    }
}

