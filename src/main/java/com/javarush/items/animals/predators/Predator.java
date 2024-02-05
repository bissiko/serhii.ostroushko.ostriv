package com.javarush.items.animals.predators;

import com.javarush.items.animals.Animals;
import com.javarush.items.animals.herbivores.Herbivore;
import com.javarush.place.Cell;
import com.javarush.place.IslandPlace;
import com.javarush.service.InitCells;
import com.javarush.service.Type;
import com.javarush.service.TypeHerbivore;

import java.util.*;

import static com.javarush.place.IslandPlace.cells;
import static com.javarush.service.Type.*;

public abstract class Predator extends Animals {
    public double eatMax;
    public static final int reproductValue = 50; // Predator не може розмножуватися кожен день, а раз на стільки днів

    public abstract int getSpeedMax();
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
                        //System.out.println("Predator " + getLifeLevel + " " + predator.getType().toString() + " eat now " + herbivore.getType().toString());
                    } else {
                        eatNow = eatNow + herbivore.getWeight();
                        if (eatNow >= predatorEatMax) {
                            isPredatorEat = true;
                            //System.out.println("### " + getLifeLevel + " Predator " + eatNow + " - " + predator.getType().toString() + " eat now " + herbivore.getType().toString());
                        }
                        //System.out.println("$$$ " + getLifeLevel + " Predator " + eatNow + " - " + predator.getType().toString() + " eat now " + herbivore.getType().toString());
                    }
                    //System.out.println("Herbivore deleted: " + herbivore.getType().toString());
                    //System.out.print(herbivoreSet.size() + " >> ");
                    iteratorH.remove();
                    //System.out.println(herbivoreSet.size() + " After " + herbivore.getType());
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
    public boolean movePredator(Cell cell, Predator predator, int x, int y) {
        boolean isMoved = false;
        Random random = new Random();
        int whereMove = random.nextInt(5);
        int howManyMove = random.nextInt(predator.getSpeedMax() + 1);
        int newX = x;
        int newY = y;
        if (whereMove == 1) {
            newX = Math.min(x + howManyMove, IslandPlace.width - 1); // Вправо
        }
        else if (whereMove == 3) {
            newX = Math.max(x - howManyMove, 0); // Вліво
        }
        if (whereMove == 2) {
            newY = Math.max(y - howManyMove, 0); // Вниз
        }
        else if (whereMove == 4) {
            newY = Math.min(y + howManyMove, IslandPlace.height - 1); // Вгору
        }
        if ((newX != x) || (newY != y)) {
            cells[newX][newY].getPredators().computeIfAbsent(predator.getType(), k -> new HashSet<>());
            //System.out.print("Predator befor to move " + cells[newX][newY].getPredators().get(predator.getType()).size() + " >>> ");

            cells[newX][newY].getPredators().computeIfAbsent(predator.getType(), k -> new HashSet<>()).add(predator);

            //System.out.println(cells[newX][newY].getPredators().get(predator.getType()).size() + " after " + predator.getType());
            isMoved = true;
        }
        return isMoved;
    }
}
