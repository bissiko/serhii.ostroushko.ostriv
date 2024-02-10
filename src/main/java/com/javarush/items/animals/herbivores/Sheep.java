package com.javarush.items.animals.herbivores;

import com.javarush.items.Organism;
import com.javarush.items.plants.Plants;
import com.javarush.service.InitParams;
import com.javarush.service.TypeHerbivore;
import com.javarush.service.TypePlants;

public class Sheep extends Herbivore {
    public int lifeLevel;
    public static final int numMax = getNumMaxHerbivore(TypeHerbivore.SHEEP); //140
    public static final int speedMax = getSpeedMaxHerbivore(TypeHerbivore.SHEEP); //3
    public static final double eatMax = getEatMaxHerbivore(TypeHerbivore.SHEEP); //15;
    public double weight;
    public static final int[] eatHerbivore = InitParams.eatHerbivoreSheep; //{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    //HORSE, DEER, RABBIT, MOUSE, GOAT, SHEEP, BOAR, BUFFALO, DUCK, CATERPILLAR
    public Sheep(){
        lifeLevel = 100;
        weight = 70;
    }
    @Override
    public TypeHerbivore getType(){
        return TypeHerbivore.SHEEP;
    }
    @Override
    public int getEatHerbivoreChance(TypeHerbivore type){
        return eatHerbivore[Herbivore.getTypeIndex(type)];
    }

    @Override
    public int getEatPlantsChance(TypePlants type) {
        return InitParams.eatPlants[Plants.getTypeIndex(type)];
    }
    public double getWeight() {
        return this.weight;
    }
    public double getEatMax() {
        return Sheep.eatMax;
    }

    @Override
    public Organism reproduce() {
        return this;
    }
    @Override
    public int getSpeedMax() {
        return Sheep.speedMax;
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

