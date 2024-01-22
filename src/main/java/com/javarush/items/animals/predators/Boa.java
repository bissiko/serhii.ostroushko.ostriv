package com.javarush.items.animals.predators;

import com.javarush.items.Organism;
import com.javarush.service.Type;
//Удав
public class Boa extends Predator{
    public int lifeLevel;
    public final int numMax;
    public final double eatMax;
    public final int speedMax;
    public double weight;
    public Boa(){
        numMax = 30;
        lifeLevel = 100;
        weight = 15;
        speedMax = 1;
        eatMax = 3;
    }
    @Override
    public Type getType(){
        return Type.BOA;
    }
    @Override
    public Organism reproduce() {
        return this;
    }

}
