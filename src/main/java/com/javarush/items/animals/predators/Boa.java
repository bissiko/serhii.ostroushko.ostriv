package com.javarush.items.animals.predators;

import com.javarush.items.Organism;
import com.javarush.items.animals.herbivores.Herbivore;
import com.javarush.service.Type;
import com.javarush.service.TypeHerbivore;

//Удав
public class Boa extends Predator{
    public int lifeLevel;
    public static final int numMax = 30;
    public final double eatMax;
    public final int speedMax;
    public double weight;
    public static final int[] eatHerbivore = {0, 0, 20, 40, 0, 0, 0, 0, 10, 0};
    //HORSE, DEER, RABBIT, MOUSE, GOAT, SHEEP, BOAR, BUFFALO, DUCK, CATERPILLAR

    public Boa(){
        //numMax = 30;
        lifeLevel = 100;
        weight = 15;
        speedMax = 1;
        eatMax = 3;
    }
    public int getNumMax() {
        return this.numMax;
    }

    @Override
    public Type getType(){
        return Type.BOA;
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
