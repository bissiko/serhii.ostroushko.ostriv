package com.javarush.items.animals.herbivores;

import com.javarush.items.Organism;
import com.javarush.service.TypeHerbivore;
import com.javarush.service.TypePlants;

public class Mouse extends Herbivore {
    public int lifeLevel;
    public static final int numMax = 500;
    public static final int speedMax = 1;
    public static final double eatMax = 0.01;
    public double weight;
    public Mouse(){
        //numMax = 500;
        lifeLevel = 100;
        weight = 0.05;
        //speedMax = 1;
        //eatMax = 0.01;
    }
    public static final int[] eatHerbivore = {0, 0, 0, 0, 0, 0, 0, 0, 0, 90};
    //HORSE, DEER, RABBIT, MOUSE, GOAT, SHEEP, BOAR, BUFFALO, DUCK, CATERPILLAR
    public static final int[] eatPlants = {100};

    @Override
    public TypeHerbivore getType(){
        return TypeHerbivore.MOUSE;
    }
    public int getEatHerbivoreChance(TypeHerbivore type){
        return eatHerbivore[Herbivore.getTypeIndex(type)];
    }

    @Override
    public int getEatPlantsChance(TypePlants type) {
        return 100;
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
