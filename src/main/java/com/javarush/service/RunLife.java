package com.javarush.service;

import com.javarush.items.animals.herbivores.Herbivore;
import com.javarush.items.animals.predators.Predator;
import com.javarush.place.Cell;

import java.util.*;

public class RunLife {
    public Cell[][] cells;
    public Cell[][] runLife (Cell[][] cells){
        this.cells = cells;
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                Cell cell = cells[x][y];
                /*Cell cell = new Cell(new HashMap<Type, Set<Predator>>(),
                        new HashMap<TypeHerbivore, Set<Herbivore>>(),
                        new HashMap<TypePlants, Set<Gras>>());*/
                System.out.println("Cell: " + x + "-" + y +
                        ". Predators: " + cell.getPredators().size() +
                        " Gras: " + cell.getPlants().size() +
                        " Herbivore: " + cell.getHerbivore().size());
                eatingPredators(cell);
                //this.cells[x][y] = cell;
                eatingHerbivores(cell);
                //this.cells[x][y] = cell;
                reproductPredators(cell);
                reproductHerbivores(cell);
                reproductPlants(cell);
                movePredators(cell);
                moveHerbivores(cell);
                this.cells[x][y] = cell;

                System.out.println("Cell after: " + x + "-" + y +
                        ". Predators: " + cell.getPredators().size() +
                        " Gras: " + cell.getPlants().size() +
                        " Herbivore: " + cell.getHerbivore().size());
            }
        }
        return cells;
    }
    public void eatingPredators(Cell cell){
        //Random random = new Random();
        System.out.println("Start: ");
        for (Map.Entry<Type, Set<Predator>> entry : cell.getPredators().entrySet()) {
            Type predatorType = entry.getKey();
            Set<Predator> predatorSet = entry.getValue();

            Iterator<Predator> iterator = predatorSet.iterator();
            while (iterator.hasNext()) {
                Predator predator = iterator.next();
                boolean isPredatorEat = false;
                double eatNow = 0;

                System.out.println(predator.getLifeLevel() + " ================Vor======================================== PRE " + predator.getType().toString());

                isPredatorEat = predator.tryEating(cell, predator);

                if (predator.getLifeLevel() < 1) {
                    iterator.remove();
                    System.out.println(predator.getLifeLevel() + " ======================================================== PRE " + predator.getType().toString());
                    break;
                }
                if (isPredatorEat) {
                    predator.setLifeLevel(100);
                    break;
                }
            }
        }
    }
    public void eatingHerbivores(Cell cell){
        System.out.println("Start Herbivore: ");
        for (Map.Entry<TypeHerbivore, Set<Herbivore>> entry : cell.getHerbivore().entrySet()) {
            TypeHerbivore herbivoreType = entry.getKey();
            Set<Herbivore> herbivoreSet = entry.getValue();

            Iterator<Herbivore> iterator = herbivoreSet.iterator();
            while (iterator.hasNext()) {
                Herbivore herbivore = iterator.next();
                boolean isHerbivoreEat = false;
                double eatNow = 0;

                if (herbivore.getEatMax() > 0) {
                    System.out.println("---------------- " + herbivore.getEatMax());
                }

                isHerbivoreEat = herbivore.tryEating(cell, herbivore);

                if (herbivore.getLifeLevel() < 1) {
                    iterator.remove();
                    System.out.println("========================================================");
                    break;
                }
                if (isHerbivoreEat) {
                    herbivore.setLifeLevel(100);
                    break;
                }
            }
        }
    }
    public void reproductPredators(Cell cell){

    }
    public void reproductHerbivores(Cell cell){

    }
    public void reproductPlants(Cell cell){

    }
    public void movePredators(Cell cell){

    }
    public void moveHerbivores(Cell cell){

    }
}
