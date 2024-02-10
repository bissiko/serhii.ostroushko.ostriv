package com.javarush.items.animals.predators;

import com.javarush.items.Organism;
import com.javarush.items.animals.herbivores.Herbivore;
import com.javarush.service.InitParams;
import com.javarush.service.Type;
import com.javarush.service.TypeHerbivore;

//Удав
public class Boa extends Predator{
    public int lifeLevel;
    public static final int numMax = getNumMaxPredator(Type.BOA); //30;
    public static final int speedMax = getSpeedMaxPredators(Type.BOA); //1
    public static final double eatMax = getEatMaxPredators(Type.BOA); //3
    public double weight;
    public static final int[] eatHerbivore = InitParams.eatHerbivoreBoa; //{0, 0, 20, 40, 0, 0, 0, 0, 10, 0};
    //HORSE, DEER, RABBIT, MOUSE, GOAT, SHEEP, BOAR, BUFFALO, DUCK, CATERPILLAR

    public Boa(){
        lifeLevel = 100;
        weight = 15;
    }
    @Override
    public Type getType(){
        return Type.BOA;
    }
    public int getEatHerbivoreChance(TypeHerbivore type){
        return eatHerbivore[Herbivore.getTypeIndex(type)];
    }
    public double getWeight() {
        return this.weight;
    }
    public double getEatMax() {
        return Boa.eatMax;
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
        return Boa.speedMax;
    }

    @Override
    public Organism reproduce() {
        return this;
    }
}
