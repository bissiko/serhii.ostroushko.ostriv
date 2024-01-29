package com.javarush.items.animals.herbivores;

import com.javarush.items.Organism;
import com.javarush.service.TypeHerbivore;
import com.javarush.service.TypePlants;

public class Rabbit extends Herbivore {
    public int lifeLevel;
    public static final int numMax = 150;
    public static final int speedMax = 2;
    public static final double eatMax = 0.45;
    public double weight;
    public Rabbit(){
        //numMax = 150;
        lifeLevel = 100;
        weight = 2;
        //speedMax = 2;
        //eatMax = 0.45;
    }
    public static final int[] eatHerbivore = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    //HORSE, DEER, RABBIT, MOUSE, GOAT, SHEEP, BOAR, BUFFALO, DUCK, CATERPILLAR
    public static final int[] eatPlants = {100};

    @Override
    public TypeHerbivore getType(){
        return TypeHerbivore.RABBIT;
    }
    @Override
    public int getEatHerbivoreChance(TypeHerbivore type){
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
    public Organism reproduce() {
        return this;
    }

}
