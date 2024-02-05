package com.javarush.service;

import com.javarush.items.animals.herbivores.Herbivore;
import com.javarush.items.animals.predators.Predator;
import com.javarush.items.plants.Gras;
import com.javarush.items.plants.Plants;
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
                /*System.out.println("Cell: " + x + "-" + y +
                        ". Predators: " + cell.getPredators().size() +
                        " Gras: " + cell.getPlants().size() +
                        " Herbivore: " + cell.getHerbivore().size());*/
                eatingPredators(cell);
                eatingHerbivores(cell);
                /*System.out.println("Cell after Eating: " + x + "-" + y +
                        ". Predators: " + cell.getPredators().size() +
                        " Gras: " + cell.getPlants().size() +
                        " Herbivore: " + cell.getHerbivore().size());*/
                reproductPredators(cell);
                reproductHerbivores(cell);
                reproductPlants(cell);
                //this.cells[x][y] = cell;

                /*System.out.println("Cell after reproduct: " + x + "-" + y +
                        ". Predators: " + cell.getPredators().size() +
                        " Gras: " + cell.getPlants().size() +
                        " Herbivore: " + cell.getHerbivore().size());*/
            }
        }
        return cells;
    }
    public void eatingPredators(Cell cell){
        //Random random = new Random();
        //System.out.println("Start Predator eating: ");
        for (Map.Entry<Type, Set<Predator>> entry : cell.getPredators().entrySet()) {
            Type predatorType = entry.getKey();
            Set<Predator> predatorSet = entry.getValue();

            Iterator<Predator> iterator = predatorSet.iterator();
            while (iterator.hasNext()) {
                Predator predator = iterator.next();
                boolean isPredatorEat = false;
                double eatNow = 0;

                //System.out.println(predator.getLifeLevel() + " ================Vor======================================== PRE " + predator.getType().toString());

                isPredatorEat = predator.tryEating(cell, predator);

                if (predator.getLifeLevel() < 1) {
                    iterator.remove();
                    //System.out.println("LifeLevel " + predator.getLifeLevel() + " ======================================================== PRE " + predator.getType().toString());
                    break;
                }
                //System.out.println(predator.getLifeLevel() + " ==========================No============================== PRE " + predator.getType().toString());
                if (isPredatorEat) {
                    predator.setLifeLevel(100);
                    break;
                }
            }
        }
    }
    public void eatingHerbivores(Cell cell){
        //System.out.println("Start Herbivore eating: ");
        for (Map.Entry<TypeHerbivore, Set<Herbivore>> entry : cell.getHerbivore().entrySet()) {
            TypeHerbivore herbivoreType = entry.getKey();
            Set<Herbivore> herbivoreSet = entry.getValue();

            Iterator<Herbivore> iterator = herbivoreSet.iterator();
            while (iterator.hasNext()) {
                Herbivore herbivore = iterator.next();
                boolean isHerbivoreEat = false;
                double eatNow = 0;

                /*if (herbivore.getEatMax() > 0) {
                    System.out.println("---------------- " + herbivore.getEatMax());
                }*/

                isHerbivoreEat = herbivore.tryEating(cell, herbivore);

                if (herbivore.getLifeLevel() < 1) {
                    iterator.remove();
                    //System.out.println("========================================================");
                    break;
                }
                if (isHerbivoreEat) {
                    herbivore.setLifeLevel(100);
                    break;
                }
            }
        }
    }
    public void reproductPredators(Cell cell) {
        //System.out.println("Start reproduct Predators: ");
        for (Map.Entry<Type, Set<Predator>> entry : cell.getPredators().entrySet()) {
            Type predatorType = entry.getKey();
            Set<Predator> predatorSet = entry.getValue();
            int predatorCount = predatorSet.size();

            if (predatorCount > 1) {
                for (int i = 0; i < Math.max(1, predatorCount/(2*Predator.reproductValue)); i++) {
                    Predator predator = new InitCells().createAnimalByType(predatorType);
                    if (predatorSet.size() < predator.getNumMax()) {
                        //System.out.print(predatorSet.size() + " > ");
                        predatorSet.add(predator);
                        //System.out.println(predatorSet.size() + " After " + predator.getType() + ": numMax " + predator.getNumMax());
                        //System.out.println(Math.max(1, predatorCount/Predator.reproductValue) + " - " + predatorType + " = " + predatorSet.size());
                    }
                }
            }
        }
    }
    public void reproductHerbivores(Cell cell){
        //System.out.println("Start reproduct Herbivores: ");
        for (Map.Entry<TypeHerbivore, Set<Herbivore>> entry : cell.getHerbivore().entrySet()) {
            TypeHerbivore herbivoreType = entry.getKey();
            Set<Herbivore> herbivoreSet = entry.getValue();
            int herbivoreCount = herbivoreSet.size();

            if (herbivoreCount > 1) {
                for (int i = 0; i < Math.max(1, herbivoreCount/(2*Herbivore.reproductValue)); i++) {
                    Herbivore herbivore = new InitCells().createHerbivoreByType(herbivoreType);

                    if (herbivoreSet.size() < herbivore.getNumMax()) {

                    //System.out.print(herbivoreCount + " " + herbivoreSet.size() + " > ");
                    herbivoreSet.add(herbivore);
                    //System.out.println(herbivoreSet.size() + " After " + herbivore.getType() + ": numMax " + herbivore.getNumMax());
                    }
                }
            }
        }
    }
    public void reproductPlants(Cell cell) {
        //System.out.println("Start reproduct Plants: ");
        Random random = new Random();
        for (Map.Entry<TypePlants, Set<Plants>> entry : cell.getPlants().entrySet()) {
            TypePlants plantsType = entry.getKey();
            Set<Plants> plantsSet = entry.getValue();
            int plantsCount = random.nextInt(Gras.numMax + 1); //plantsSet.size();

            for (int i = 0; i < Math.max(1, plantsCount/Plants.reproductValue); i++) {
                Plants plant = new InitCells().createPlantByType(plantsType);
                plantsSet.add(plant);
            }
        }
    }
    public Cell[][] runMove (Cell[][] cells){
        this.cells = cells;
        for (int x = cells.length -1; x >= 0; x--) {
            for (int y = cells[x].length - 1; y >= 0; y--) {
                Cell cell = cells[x][y];
                /*System.out.println("Cell before Moving: " + x + "-" + y +
                        ". Predators: " + cell.getPredators().size() +
                        " Gras: " + cell.getPlants().size() +
                        " Herbivore: " + cell.getHerbivore().size());*/
                movePredators(cell, x, y);
                moveHerbivores(cell, x, y);
                //this.cells[x][y] = cell;

                /*System.out.println("Cell after Moving: " + x + "-" + y +
                        ". Predators: " + cell.getPredators().size() +
                        " Gras: " + cell.getPlants().size() +
                        " Herbivore: " + cell.getHerbivore().size());*/
            }
        }
        return cells;
    }
    public void movePredators(Cell cell, int x, int y) {
        //System.out.println("Start moving Predators: ");
        for (Map.Entry<Type, Set<Predator>> entry : cell.getPredators().entrySet()) {
            Type predatorType = entry.getKey();
            Set<Predator> predatorSet = entry.getValue();

            Iterator<Predator> iterator = predatorSet.iterator();
            while (iterator.hasNext()) {
                Predator predator = iterator.next();
                boolean isMoved = false;

                //System.out.println("XY: " + x + " : " + y + " ================Vor moving======================================== PRE " + predator.getType().toString());

                isMoved = predator.movePredator(cell, predator, x, y);

                if (isMoved) {
                    iterator.remove();
                    //System.out.println("XY: " + x + " : " + y + " =============Moved=========================================== PRE " + predator.getType().toString());
                }
            }
        }
    }
    public void moveHerbivores(Cell cell, int x, int y){
        //System.out.println("Start moving Herbivores: ");
        for (Map.Entry<TypeHerbivore, Set<Herbivore>> entry : cell.getHerbivore().entrySet()) {
            TypeHerbivore herbivoreType = entry.getKey();
            Set<Herbivore> herbivoreSet = entry.getValue();

            Iterator<Herbivore> iterator = herbivoreSet.iterator();
            while (iterator.hasNext()) {
                Herbivore herbivore = iterator.next();
                boolean isMoved = false;

                //System.out.println("XY: " + x + " : " + y + " ================Vor moving======================================== Herbivore " + herbivore.getType().toString());

                isMoved = herbivore.moveHerbivore(cell, herbivore, x, y);

                if (isMoved) {
                    //System.out.print(herbivoreSet.size() + " > ");
                    iterator.remove();
                    //System.out.println(herbivoreSet.size() + " After");
                    //System.out.println("XY: " + x + " : " + y + " =============Moved=========================================== Herbivore " + herbivore.getType().toString());
                }
            }
        }
    }
}
