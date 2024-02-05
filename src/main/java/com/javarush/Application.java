package com.javarush;

import com.javarush.items.animals.herbivores.Herbivore;
import com.javarush.items.animals.predators.Predator;
import com.javarush.items.plants.Plants;
import com.javarush.place.Cell;
import com.javarush.service.*;

import java.util.Map;
import java.util.Set;

public class Application {
    public static void main(String[] args){
        System.out.println("Hello world!!!! How are You?");
        InitCells cells = new InitCells();
        cells.initCells();

        RunLife runLifeNew = new RunLife();

        boolean isCanRun = true;
        int lifeSteps = 1;
        while (isCanRun) {
            System.out.println("\n Start RunLife !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! "  + lifeSteps);
            getStatistik(cells, "  ", " befor");

            runLifeNew.runLife(cells.islandPlace.getCells());
            isCanRun = canRunLife(cells);
            runLifeNew.runMove(cells.islandPlace.getCells());
            lifeSteps++;
        }
    }
    private static boolean canRunLife (InitCells cells) {
        int totalHerbivores = 0;
        for (int x = 0; x < cells.islandPlace.getCells().length; x++) {
            for (int y = 0; y < cells.islandPlace.getCells()[x].length; y++) {
                Cell cell = cells.islandPlace.getCells()[x][y];
                for (Map.Entry<TypeHerbivore, Set<Herbivore>> entry : cell.getHerbivore().entrySet()) {
                    //TypeHerbivore herbivoreType = entry.getKey();
                    Set<Herbivore> herbivoreSet = entry.getValue();
                    totalHerbivores = totalHerbivores + herbivoreSet.size();
                }
            }
        }
        System.out.println("Total Herbivores now " + totalHerbivores);
        if (totalHerbivores == 0) {return false;} else {return true;}
    }
    private static void getStatistik(InitCells cells, String spaces, String x) {
        int itX = 2;
        int itY = 1;
        System.out.print("Pre... ");
        for (Map.Entry<Type, Set<Predator>> entry : cells.islandPlace.getCells()[itX][itY].getPredators().entrySet()) {
            Type predatorType = entry.getKey();
            Set<Predator> predatorSet = entry.getValue();
            System.out.print(predatorSet.size() + spaces + predatorType + ", ");
        }
        System.out.print("\n Cell XY " + itX + " : " + itY + " __________________________________________________ Herbi... ");
        for (Map.Entry<TypeHerbivore, Set<Herbivore>> entry : cells.islandPlace.getCells()[itX][itY].getHerbivore().entrySet()) {
            TypeHerbivore herbivoreType = entry.getKey();
            Set<Herbivore> herbivoreSet = entry.getValue();
            System.out.print(herbivoreSet.size() + spaces + herbivoreType + ", ");
        }
        System.out.print("\n +++++++++ Plants... ");
        for (Map.Entry<TypePlants, Set<Plants>> entryPlants : cells.islandPlace.getCells()[itX][itY].getPlants().entrySet()) {
            TypePlants plantType = entryPlants.getKey();
            Set<Plants> plantSet = entryPlants.getValue();
            System.out.println(plantSet.size());
        }
    }
}
