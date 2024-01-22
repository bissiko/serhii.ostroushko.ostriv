package com.javarush.items.plants;

import com.javarush.items.Organism;
import com.javarush.service.TypePlants;

public class Gras extends Organism {
    public int lifeLevel;
    public final int sumMax;
    public int weight;
    public Gras(){
        lifeLevel = 100;
        weight = 1;
        sumMax = 200;
    }
    public TypePlants getType(){
        return TypePlants.GRAS;
    }
    @Override
    public Organism reproduce() {
        return this;
    }
}
