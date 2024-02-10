package com.javarush.items.animals.predators;

import com.javarush.items.Organism;
import com.javarush.items.animals.herbivores.Herbivore;
import com.javarush.service.InitParams;
import com.javarush.service.Type;
import com.javarush.service.TypeHerbivore;

public class Bear extends Predator {
    public int lifeLevel;
    public static final int numMax = getNumMaxPredator(Type.BEAR);
    public static final int speedMax = getSpeedMaxPredators(Type.BEAR); //2
    public static final double eatMax = getEatMaxPredators(Type.BEAR); //80

    public double weight;
    public static final int[] eatHerbivore = InitParams.eatHerbivoreBear; // {40, 80, 80, 90, 70, 70, 50, 20, 10, 0};
    //HORSE, DEER, RABBIT, MOUSE, GOAT, SHEEP, BOAR, BUFFALO, DUCK, CATERPILLAR

    public Bear(){
        super();
        lifeLevel = 100;
        weight = 500;
    }
    @Override
    public Type getType(){
        return Type.BEAR;
    }
    @Override
    public int getSpeedMax() {
        return Bear.speedMax;
    }
    public int getEatHerbivoreChance(TypeHerbivore type){
        return eatHerbivore[Herbivore.getTypeIndex(type)];
    }
    public double getWeight() {
        return this.weight;
    }
    public double getEatMax() {
        return Bear.eatMax;
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
    public Organism reproduce() {
        return this;
    }

}