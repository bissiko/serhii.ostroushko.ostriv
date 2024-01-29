package com.javarush.place;

import com.javarush.items.animals.herbivores.Herbivore;
import com.javarush.items.animals.predators.Predator;
import com.javarush.items.plants.Plants;
import com.javarush.service.Type;
import com.javarush.service.TypeHerbivore;
import com.javarush.service.TypePlants;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Cell {
    private final HashMap<Type, Set<Predator>> predators;
    private final HashMap<TypeHerbivore, Set<Herbivore>> herbivore;
    private final HashMap<TypePlants, Set<Plants>> plants;

    public Cell(HashMap<Type, Set<Predator>> predators,
                HashMap<TypeHerbivore, Set<Herbivore>> herbivore,
                HashMap<TypePlants, Set<Plants>> plants) {
        this.predators = predators;
        this.herbivore = herbivore;
        this.plants = plants;
    }

    public Map<Type, Set<Predator>> getPredators() {
        return predators;
    }
    public Map<TypeHerbivore, Set<Herbivore>> getHerbivore() {
        return herbivore;
    }
    public Map<TypePlants, Set<Plants>> getPlants() {
        return plants;
    }
    public Cell getCell(){
        return this;
    }
    public void removePredator(Predator predator) {
        for (Set<Predator> predators : getPredators().values()){
            Iterator<Predator> iterator = predators.iterator();
            while (iterator.hasNext()){
                Predator predator1 = iterator.next();
                if (predator1.equals(predator)) {
                    //Знайдена потрібна тварина
                    iterator.remove();
                    return; //Видаляємо тільки 1 тварину
                }
            }
        }
    }
}
