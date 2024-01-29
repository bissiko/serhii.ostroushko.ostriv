package com.javarush.items.animals.predators;

import com.javarush.items.animals.Animals;
import com.javarush.items.animals.herbivores.Herbivore;
import com.javarush.place.Cell;
import com.javarush.service.Type;
import com.javarush.service.TypeHerbivore;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import static com.javarush.service.Type.*;

public abstract class Predator extends Animals {
    public double eatMax;

    public abstract Type getType();
    public abstract double getEatMax();
    public abstract double getWeight();
    public Type[] types = {WOLF, BOA, BEAR, EAGLE, FOX};
    public int getTypeIndex(Type type) {
        for (int i = 0; i < types.length; i++) {
            if (types[i] == type){
                return i;
            }
        }
        return -1;
    }
    public abstract int getEatHerbivoreChance(TypeHerbivore type);
    //@Override
    public boolean tryEating(Cell cell, Predator predator) {
        Random random = new Random();
        boolean isPredatorEat = false;
        double eatNow = 0;
        double predatorEatMax = predator.getEatMax();
        int getLifeLevel = predator.getLifeLevel();

        for (Map.Entry<TypeHerbivore, Set<Herbivore>> entryHerbivore : cell.getHerbivore().entrySet()) {
            TypeHerbivore herbivoreType = entryHerbivore.getKey();
            Set<Herbivore> herbivoreSet = entryHerbivore.getValue();
            int canEaten = predator.getEatHerbivoreChance(herbivoreType);

            if ((canEaten > 0) && (random.nextInt(101) <= canEaten)) {
                Iterator<Herbivore> iteratorH = herbivoreSet.iterator();
                int i = 0;
                while ((iteratorH.hasNext() && !isPredatorEat) && (i < Herbivore.againEatMax)) {

                    Herbivore herbivore = iteratorH.next();
                    if (herbivore.getWeight() > predatorEatMax) {
                        eatNow = predatorEatMax;
                        isPredatorEat = true;
                        System.out.println("Predator " + getLifeLevel + " " + predator.getType().toString() + " eat now " + herbivore.getType().toString());
                    } else {
                        eatNow = eatNow + herbivore.getWeight();
                        if (eatNow >= predatorEatMax) {
                            isPredatorEat = true;
                        }
                        System.out.println("$$$ " + getLifeLevel + " Predator " + eatNow + " - " + predator.getType().toString() + " eat now " + herbivore.getType().toString());
                    }
                    //System.out.println("Herbivore deleted: " + herbivore.getType().toString());
                    iteratorH.remove();
                    i++;
                }
            }
            if (isPredatorEat) {
                predator.setLifeLevel(100);
                break;
            }
        }
        if (eatNow > 0) {
            predator.setLifeLevel(getLifeLevel - 5);
        } else if (eatNow == 0) {
            predator.setLifeLevel(getLifeLevel - 10);
        }
        return isPredatorEat;
    }
}
