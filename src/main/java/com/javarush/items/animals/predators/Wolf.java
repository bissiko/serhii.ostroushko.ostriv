package com.javarush.items.animals.predators;

import com.javarush.items.Organism;
import com.javarush.items.animals.herbivores.Herbivore;
import com.javarush.service.Type;
import com.javarush.service.TypeHerbivore;

public class Wolf extends Predator {
    public int lifeLevel;
    public static final int numMax = 30;
    public final double eatMax;
    public final int speedMax;
    public double weight;
    public static final int[] eatHerbivore = {10, 15, 60, 80, 60, 70, 15, 10, 40, 0};
    //HORSE, DEER, RABBIT, MOUSE, GOAT, SHEEP, BOAR, BUFFALO, DUCK, CATERPILLAR
    public Wolf(){
        //numMax = 30;
        lifeLevel = 100;
        weight = 50;
        speedMax = 3;
        eatMax = 8;
    }
    public int getNumMax() {
        return this.numMax;
    }

    @Override
    public Type getType(){
        return Type.WOLF;
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
    public int getSpeedMax() {
        return this.speedMax;
    }

    @Override
    public Organism reproduce() {
        return this;
    }
    @Override
    public void setLifeLevel(int lifeLevel) {
        this.lifeLevel = lifeLevel;
    }
    @Override
    public int getLifeLevel() {
        return this.lifeLevel;
    }

}
// 3 video - 21.51