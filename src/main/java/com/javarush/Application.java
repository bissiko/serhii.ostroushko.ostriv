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

        getStatistik(cells, "  ", " plants");


        RunLife runLifeNew = new RunLife();
        for (int i = 0; i < 2; i++) {
            runLifeNew.runLife(cells.islandPlace.getCells());
        }

        getStatistik(cells, " +++++++++++++++++++++++++++++++++++++++++++++++++ ", " +++++++++++++++++++++++++++++++++++++++++++++++++++++++++ plants");
    }

    private static void getStatistik(InitCells cells, String spaces, String x) {
        for (Map.Entry<Type, Set<Predator>> entry : cells.islandPlace.getCells()[2][1].getPredators().entrySet()) {
            Type predatorType = entry.getKey();
            Set<Predator> predatorSet = entry.getValue();
            System.out.println("Pre... " + predatorSet.size() + spaces + predatorType);
        }
        for (Map.Entry<TypeHerbivore, Set<Herbivore>> entry : cells.islandPlace.getCells()[2][1].getHerbivore().entrySet()) {
            TypeHerbivore herbivoreType = entry.getKey();
            Set<Herbivore> herbivoreSet = entry.getValue();
            System.out.println(herbivoreSet.size() + spaces + herbivoreType);
        }
        for (Map.Entry<TypePlants, Set<Plants>> entryPlants : cells.islandPlace.getCells()[2][1].getPlants().entrySet()) {
            TypePlants plantType = entryPlants.getKey();
            Set<Plants> plantSet = entryPlants.getValue();
            System.out.println(plantSet.size() + x);
        }
    }
}
