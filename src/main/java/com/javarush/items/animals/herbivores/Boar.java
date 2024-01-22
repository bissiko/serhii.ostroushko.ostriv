package com.javarush.items.animals.herbivores;

import com.javarush.items.Organism;
import com.javarush.service.TypeHerbivore;
//кабан
public class Boar extends Herbivore {
    public int lifeLevel;
    public final int numMax;
    public final double eatMax;
    public final int speedMax;
    public double weight;
    public Boar(){
        numMax = 50;
        lifeLevel = 100;
        weight = 400;
        speedMax = 2;
        eatMax = 50;
    }
    @Override
    public TypeHerbivore getType(){
        return TypeHerbivore.BOAR;
    }
    @Override
    public Organism reproduce() {
        return this;
    }
}
