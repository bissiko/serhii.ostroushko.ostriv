package com.javarush.place;

import com.javarush.items.animals.herbivores.Herbivore;
import com.javarush.items.animals.predators.Predator;
import com.javarush.items.plants.Gras;
import com.javarush.service.Type;
import com.javarush.service.TypeHerbivore;
import com.javarush.service.TypePlants;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cell {
    private final HashMap<Type, Set<Predator>> predators;
    private final HashMap<TypeHerbivore, Set<Herbivore>> herbivore;
    private final HashMap<TypePlants, Set<Gras>> gras;

    public Cell(HashMap<Type, Set<Predator>> predators,
                HashMap<TypeHerbivore, Set<Herbivore>> herbivore,
                HashMap<TypePlants, Set<Gras>> gras) {
        this.predators = predators;
        this.herbivore = herbivore;
        this.gras = gras;
    }

    public Map<Type, Set<Predator>> getPredators() {
        return predators;
    }
    public Map<TypeHerbivore, Set<Herbivore>> getHerbivore() {
        return herbivore;
    }
    public Map<TypePlants, Set<Gras>> getGrases() {
        return gras;
    }
}
