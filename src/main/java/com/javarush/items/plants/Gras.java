package com.javarush.items.plants;

import com.javarush.items.Organism;
import com.javarush.service.InitParams;
import com.javarush.service.TypePlants;

import static com.javarush.service.TypePlants.GRAS;

public class Gras extends Plants {
    public int lifeLevel;
    public static final int numMax = InitParams.numMaxGras; // maximum number of Gras in Cell;
    public double weight;
    public Gras(){
        lifeLevel = 100;
        weight = InitParams.weightGras; // 1
    }
    public TypePlants getType(){
        return GRAS;
    }
    public double getWeight() {return this.weight;}
    public int getNumMax() {return this.numMax;}
    @Override
    public Organism reproduce() {
        return this;
    }
}
