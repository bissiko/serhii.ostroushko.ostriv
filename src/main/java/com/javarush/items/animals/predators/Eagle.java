package com.javarush.items.animals.predators;

import com.javarush.items.Organism;
import com.javarush.items.animals.herbivores.Herbivore;
import com.javarush.service.Type;
import com.javarush.service.TypeHerbivore;

public class Eagle extends Predator{
    public int lifeLevel;
    public static final int numMax = 20;
    public final double eatMax;
    public final int speedMax;
    public double weight;
    public static final int[] eatHerbivore = {0, 0, 90, 90, 0, 0, 0, 0, 80, 0};
    //HORSE, DEER, RABBIT, MOUSE, GOAT, SHEEP, BOAR, BUFFALO, DUCK, CATERPILLAR

    public Eagle(){
        //numMax = 20;
        lifeLevel = 100;
        weight = 6;
        speedMax = 3;
        eatMax = 1;
    }
    public int getNumMax() {
        return this.numMax;
    }

    @Override
    public Type getType(){
        return Type.EAGLE;
    }
    public int getEatHerbivoreChance(TypeHerbivore type){
        return eatHerbivore[Herbivore.getTypeIndex(type)];
    }
    public double getWeight() {
        return this.weight;
    }
    public double getEatMax() {
        return this.eatMax;
    }
    @Override
    public void setLifeLevel(int lifeLevel) {
        this.lifeLevel = lifeLevel;
    }
    @Override
    public int getLifeLevel() {
        return this.lifeLevel;
    }
    @Override
    public int getSpeedMax() {
        return this.speedMax;
    }

    @Override
    public Organism reproduce() {
        return this;
    }

}
