package com.javarush.items.animals.herbivores;

import com.javarush.items.Organism;
import com.javarush.items.plants.Plants;
import com.javarush.service.TypeHerbivore;
import com.javarush.service.TypePlants;

public class Horse   extends Herbivore {
    public int lifeLevel;
    public static final int numMax = 20;
    public static final int speedMax = 4;
    public static final double eatMax = 60;
    public double weight;
    public Horse(){
        //numMax = 20;
        lifeLevel = 100;
        weight = 400;
        //speedMax = 4;
        //eatMax = 60;
    }
    public int getNumMax() {
        return this.numMax;
    }

    public static final int[] eatHerbivore = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    //HORSE, DEER, RABBIT, MOUSE, GOAT, SHEEP, BOAR, BUFFALO, DUCK, CATERPILLAR
    public static final int[] eatPlants = {100};

    @Override
    public TypeHerbivore getType(){
        return TypeHerbivore.HORSE;
    }
    @Override
    public int getEatHerbivoreChance(TypeHerbivore type){
        return eatHerbivore[Herbivore.getTypeIndex(type)];
    }

    @Override
    public int getEatPlantsChance(TypePlants type) {
        return eatPlants[Plants.getTypeIndex(type)];
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

