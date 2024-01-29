package com.javarush.items.animals.herbivores;

import com.javarush.items.animals.Animals;
import com.javarush.items.plants.Plants;
import com.javarush.place.Cell;
import com.javarush.service.Type;
import com.javarush.service.TypeHerbivore;
import com.javarush.service.TypePlants;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import static com.javarush.service.Type.*;
import static com.javarush.service.TypeHerbivore.*;

public abstract class Herbivore  extends Animals {
    //public double eatMax;
    public abstract TypeHerbivore getType();
    public static TypeHerbivore[] typesHerbivore = {HORSE, DEER, RABBIT, MOUSE, GOAT, SHEEP, BOAR, BUFFALO, DUCK, CATERPILLAR};
    public static int getTypeIndex(TypeHerbivore type) {
        for (int i = 0; i < typesHerbivore.length; i++) {
            if (typesHerbivore[i] == type){
                return i;
            }
        }
        return -1;
    }
    public static final int againEatMax = 10;

    public abstract double getWeight();
    public abstract double getEatMax();
    public abstract int getEatHerbivoreChance(TypeHerbivore type);
    public abstract int getEatPlantsChance(TypePlants type);
    //@Override
    public boolean tryEating(Cell cell, Herbivore herbivore) {
        Random random = new Random();
        boolean isHerbivoreEat = false;
        double eatNow = 0;
        double herbivoreEatMax = herbivore.getEatMax();

        Result result = getResultHerbivoreEatHerbivore(cell, random, isHerbivoreEat, eatNow, herbivore);
        if (herbivoreEatMax > 0) {
            System.out.println("Need Gras Need Gras Need Gras :" + result.eatNow() + " of " + herbivoreEatMax + " -- " + herbivore.getType() + "");
        }
        if (result.eatNow() < herbivoreEatMax) {
            ResultPlant resultPlant = getResultHerbivoreEatPlants(cell, random, result.isHerbivoreEat(), result.eatNow(), herbivore);
            return resultPlant.isHerbivoreEat();
        }
        return result.isHerbivoreEat();
    }

    private Result getResultHerbivoreEatHerbivore(Cell cell, Random random, boolean isHerbivoreEat, double eatNow, Herbivore herbivore) {
        double herbivoreEatMax = herbivore.getEatMax();
        int getLifeLevel = herbivore.getLifeLevel();

        for (Map.Entry<TypeHerbivore, Set<Herbivore>> entryHerbivore2 : cell.getHerbivore().entrySet()) {
            TypeHerbivore herbivoreType2 = entryHerbivore2.getKey();
            Set<Herbivore> herbivoreSet2 = entryHerbivore2.getValue();
            int canEaten = herbivore.getEatHerbivoreChance(herbivoreType2);

            if ((canEaten > 0) && (random.nextInt(101) <= canEaten)) {
                Iterator<Herbivore> iteratorH = herbivoreSet2.iterator();
                int i = 0;
                while ((iteratorH.hasNext() && !isHerbivoreEat) && (i < Herbivore.againEatMax)) {
                    Herbivore herbivore2 = iteratorH.next();
                    if (herbivore2.getWeight() >= herbivoreEatMax) {
                        eatNow = herbivoreEatMax;
                        isHerbivoreEat = true;
                        System.out.println(eatNow + " ###### Herbivore " + herbivore.getType().toString() + " eat now Herbivore " + herbivore2.getType().toString());
                    } else {
                        eatNow = eatNow + herbivore2.getWeight();
                        if (eatNow >= herbivoreEatMax) {
                            isHerbivoreEat = true;
                        }
                        System.out.println(eatNow + " $$$$$$$ " + getLifeLevel + " Herbivore " + herbivore.getType().toString() + " eat now Herbivore " + herbivore2.getType().toString());
                    }
                    //System.out.println("2 Herbivore deleted: " + herbivore2.getType().toString());
                    iteratorH.remove();
                    i++;
                }
            }
            if (isHerbivoreEat) {
                herbivore.setLifeLevel(100);
                break;
            }
        }
        if (eatNow > 0) {
            herbivore.setLifeLevel(getLifeLevel - 5);
        } else if (eatNow == 0) {
            herbivore.setLifeLevel(getLifeLevel - 10);
        }
        return new Result(isHerbivoreEat, eatNow);
    }

    private record Result(boolean isHerbivoreEat, double eatNow) {
    }

    private ResultPlant getResultHerbivoreEatPlants(Cell cell, Random random, boolean isHerbivoreEat, double eatNow, Herbivore herbivore) {
        double herbivoreEatMax = herbivore.getEatMax();
        int getLifeLevel = herbivore.getLifeLevel();

        for (Map.Entry<TypePlants, Set<Plants>> entryPlants : cell.getPlants().entrySet()) {
            TypePlants plantType = entryPlants.getKey();
            Set<Plants> plantSet = entryPlants.getValue();
            int canEaten = herbivore.getEatPlantsChance(plantType);

            if ((canEaten > 0) && (random.nextInt(101) <= canEaten)) {
                Iterator<Plants> iteratorH = plantSet.iterator();
                int i = 0;
                //int getLifeLevel = herbivore.getLifeLevel();
                while ((iteratorH.hasNext() && !isHerbivoreEat) && (i < Plants.againEatMax)) {
                    Plants plant = iteratorH.next();
                    if (plant.getWeight() > herbivoreEatMax) {
                        eatNow = herbivoreEatMax;
                        isHerbivoreEat = true;
                        System.out.println("HerbivorePlant " + herbivore.getType().toString() + " eat now Plant " + plant.getType().toString());
                    } else {
                        eatNow = eatNow + plant.getWeight();
                        if (eatNow >= herbivoreEatMax) {
                            isHerbivoreEat = true;
                        }
                        System.out.println("%%% HerbivorePlant " + herbivore.getType().toString() + " eat now Plant " + plant.getType().toString());
                    }
                    //System.out.println("Plant deleted: " + plant.getType().toString());
                    iteratorH.remove();
                    i++;
                }
            }
            if (isHerbivoreEat) {
                herbivore.setLifeLevel(100);
                break;
            }
        }
        if (eatNow > 0) {
            herbivore.setLifeLevel(getLifeLevel - 5);
        } else if (eatNow == 0) {
            herbivore.setLifeLevel(getLifeLevel - 10);
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++ LifeLevel " + herbivore.getLifeLevel());

        return new ResultPlant(isHerbivoreEat, eatNow);
    }

    private record ResultPlant(boolean isHerbivoreEat, double eatNow) {
    }
}
