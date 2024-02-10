package com.javarush.items.animals.herbivores;

import com.javarush.items.Organism;
import com.javarush.items.plants.Plants;
import com.javarush.service.InitParams;
import com.javarush.service.TypeHerbivore;
import com.javarush.service.TypePlants;

public class Caterpillar   extends Herbivore {
    public int lifeLevel;
    public static final int numMax = getNumMaxHerbivore(TypeHerbivore.CATERPILLAR); //1000
    public static final int speedMax = getSpeedMaxHerbivore(TypeHerbivore.CATERPILLAR); //0
    public static final double eatMax = getEatMaxHerbivore(TypeHerbivore.CATERPILLAR); //0
    public double weight;
    public static final int[] eatHerbivore = InitParams.eatHerbivoreCaterpillar; //{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    //HORSE, DEER, RABBIT, MOUSE, GOAT, SHEEP, BOAR, BUFFALO, DUCK, CATERPILLAR
    public Caterpillar(){
        lifeLevel = 100;
        weight = 0.01;
    }
    public TypeHerbivore getType(){
        return TypeHerbivore.CATERPILLAR;
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

