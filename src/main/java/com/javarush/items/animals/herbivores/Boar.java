package com.javarush.items.animals.herbivores;

import com.javarush.items.Organism;
import com.javarush.service.TypeHerbivore;
import com.javarush.service.TypePlants;

//кабан
public class Boar extends Herbivore {
    public int lifeLevel;
    public static final int numMax = 50;
    public static final int speedMax = 2;
    public static final double eatMax = 50;
    public double weight;
    public Boar(){
        //numMax = 50;
        lifeLevel = 100;
        weight = 400;
        //speedMax = 2;
        //eatMax = 50;
    }
    public int getNumMax() {
        return this.numMax;
    }

    public static final int[] eatHerbivore = {0, 0, 0, 50, 0, 0, 0, 0, 0, 90};
    //HORSE, DEER, RABBIT, MOUSE, GOAT, SHEEP, BOAR, BUFFALO, DUCK, CATERPILLAR
    public static final int[] eatPlants = {100};
    @Override
    public TypeHerbivore getType(){
        return TypeHerbivore.BOAR;
    }
    public int getEatHerbivoreChance(TypeHerbivore type) {
        return eatHerbivore[Herbivore.getTypeIndex(type)];
    }
    @Override
    public int getEatPlantsChance(TypePlants type) {
        return 100;
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
