package com.javarush.items.plants;

import com.javarush.items.Organism;
import com.javarush.service.TypeHerbivore;
import com.javarush.service.TypePlants;

import static com.javarush.service.TypePlants.GRAS;

public abstract class Plants extends Organism {
    public static TypePlants[] typesPlants = {GRAS};
    public static final int againEatMax = 12;

    public static int getTypeIndex(TypePlants type) {
        for (int i = 0; i < typesPlants.length; i++) {
            if (typesPlants[i] == type){
                return i;
            }
        }
        return -1;
    }
    public TypePlants getType(){
        return GRAS;
    }
    public abstract double getWeight();
    @Override
    public Organism reproduce() {
        return this;
    }
}
