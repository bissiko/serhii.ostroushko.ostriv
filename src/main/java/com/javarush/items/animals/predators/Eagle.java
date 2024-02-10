package com.javarush.items.animals.predators;

import com.javarush.items.Organism;
import com.javarush.items.animals.herbivores.Herbivore;
import com.javarush.service.InitParams;
import com.javarush.service.Type;
import com.javarush.service.TypeHerbivore;

public class Eagle extends Predator{
    public int lifeLevel;
    public static final int numMax = getNumMaxPredator(Type.EAGLE); //20
    public static final int speedMax = getSpeedMaxPredators(Type.EAGLE); //3
    public static final double eatMax = getEatMaxPredators(Type.EAGLE); //1
    public double weight;
    public static final int[] eatHerbivore = InitParams.eatHerbivoreEagle; // {0, 0, 90, 90, 0, 0, 0, 0, 80, 0};
    //HORSE, DEER, RABBIT, MOUSE, GOAT, SHEEP, BOAR, BUFFALO, DUCK, CATERPILLAR

    public Eagle(){
        lifeLevel = 100;
        weight = 6;
    }
    @Override
    public Type getType(){
        return Type.EAGLE;
    }
    public int getEatHerbivoreChance(TypeHerbivore type){
        return eatHerbivore[Herbivore.getTypeIndex(type)];
    }
    public double getWeight() {
        return this.weight;
    }
    public double getEatMax() {
        return Eagle.eatMax;
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
        return Eagle.speedMax;
    }

    @Override
    public Organism reproduce() {
        return this;
    }

}
