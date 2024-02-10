package com.javarush.items.animals.herbivores;

import com.javarush.items.Organism;
import com.javarush.items.plants.Plants;
import com.javarush.service.InitParams;
import com.javarush.service.TypeHerbivore;
import com.javarush.service.TypePlants;

public class Deer extends Herbivore {
    public int lifeLevel;
    public static final int numMax = getNumMaxHerbivore(TypeHerbivore.DEER); //20
    public static final int speedMax = getSpeedMaxHerbivore(TypeHerbivore.DEER); //2
    public static final double eatMax = getEatMaxHerbivore(TypeHerbivore.DEER); //50;
    public double weight;
    public static final int[] eatHerbivore = InitParams.eatHerbivoreDeer; //{0, 0, 0, 0, 0, 0, 0, 0, 0, 90};
    //HORSE, DEER, RABBIT, MOUSE, GOAT, SHEEP, BOAR, BUFFALO, DUCK, CATERPILLAR
    public Deer(){
        lifeLevel = 100;
        weight = 400;
    }
    public TypeHerbivore getType(){
        return TypeHerbivore.DEER;
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
        return Deer.eatMax;
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
        return Deer.speedMax;
    }

    @Override
    public Organism reproduce() {
        return this;
    }

}
