package com.javarush.items.animals.predators;

import com.javarush.items.Organism;
import com.javarush.items.animals.herbivores.Herbivore;
import com.javarush.service.Type;
import com.javarush.service.TypeHerbivore;

public class Bear extends Predator {
    public int lifeLevel;
    public static final int numMax = 5;
    public final double eatMax;
    public final int speedMax;
    public double weight;
    public static final int[] eatHerbivore = {40, 80, 80, 90, 70, 70, 50, 20, 10, 0};
    //HORSE, DEER, RABBIT, MOUSE, GOAT, SHEEP, BOAR, BUFFALO, DUCK, CATERPILLAR

    public Bear(){
        //numMax = 5;
        lifeLevel = 100;
        weight = 500;
        speedMax = 2;
        eatMax = 80;
    }
    @Override
    public Type getType(){
        return Type.BEAR;
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
    public Organism reproduce() {
        return this;
    }

}