package com.javarush.items.animals.predators;

import com.javarush.items.Organism;
import com.javarush.items.animals.herbivores.Herbivore;
import com.javarush.service.Type;
import com.javarush.service.TypeHerbivore;

public class Fox extends Predator {
    public int lifeLevel;
    public static final int numMax = 30;
    public final double eatMax;
    public final int speedMax;
    public double weight;
    public static final int[] eatHerbivore = {0, 0, 70, 90, 0, 0, 0, 0, 60, 40};
    //HORSE, DEER, RABBIT, MOUSE, GOAT, SHEEP, BOAR, BUFFALO, DUCK, CATERPILLAR

    public Fox(){
        //numMax = 30;
        lifeLevel = 100;
        weight = 8;
        speedMax = 2;
        eatMax = 2;
    }
    @Override
    public Type getType(){
        return Type.FOX;
    }
    public int getEatHerbivoreChance(TypeHerbivore type){
        return eatHerbivore[Herbivore.getTypeIndex(type)];
    }
    public int getLifeLevel(){
        return lifeLevel;
    }
    public double getWeight() {
        return this.weight;
    }
    public double getEatMax() {
        return this.eatMax;
    }
    @Override
    public Organism reproduce() {
        return this;
    }
}
