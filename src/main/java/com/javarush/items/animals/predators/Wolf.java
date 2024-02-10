package com.javarush.items.animals.predators;

import com.javarush.items.Organism;
import com.javarush.items.animals.herbivores.Herbivore;
import com.javarush.service.InitParams;
import com.javarush.service.Type;
import com.javarush.service.TypeHerbivore;

public class Wolf extends Predator {
    public int lifeLevel;
    public static final int numMax = getNumMaxPredator(Type.WOLF); //30
    public static final int speedMax = getSpeedMaxPredators(Type.WOLF); //3
    public static final double eatMax = getEatMaxPredators(Type.WOLF); //8
    public double weight;
    public static final int[] eatHerbivore = InitParams.eatHerbivoreWolf; //{10, 15, 60, 80, 60, 70, 15, 10, 40, 0};
    //HORSE, DEER, RABBIT, MOUSE, GOAT, SHEEP, BOAR, BUFFALO, DUCK, CATERPILLAR
    public Wolf(){
        lifeLevel = 100;
        weight = 50;
    }
    @Override
    public Type getType(){
        return Type.WOLF;
    }
    public int getEatHerbivoreChance(TypeHerbivore type){
        return eatHerbivore[Herbivore.getTypeIndex(type)];
    }
    public double getWeight() {
        return this.weight;
    }
    public double getEatMax() {
        return Wolf.eatMax;
    }
    @Override
    public int getSpeedMax() {
        return Wolf.speedMax;
    }

    @Override
    public Organism reproduce() {
        return this;
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
// 3 video - 21.51