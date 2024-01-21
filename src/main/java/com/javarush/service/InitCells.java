package com.javarush.service;

import com.javarush.items.animals.herbivores.Herbivore;
import com.javarush.items.animals.predators.Bear;
import com.javarush.items.animals.predators.Fox;
import com.javarush.items.animals.predators.Predator;
import com.javarush.items.animals.predators.Wolf;
import com.javarush.items.plants.Gras;
import com.javarush.place.Cell;
import com.javarush.place.IslandPlace;

import java.util.*;

public class InitCells {
    IslandPlace islandPlace = new IslandPlace();
    public void initCells() {
        for (int x = 0; x < islandPlace.getWidth(); x++) {
            for (int y = 0; y < islandPlace.getHeight(); y++) {
                Cell cell = new Cell(new HashMap<Type, Set< Predator >>(),
                        new HashMap<TypeHerbivore, Set< Herbivore >>(),
                        new HashMap<TypePlants, Set< Gras >>());
                fulfillPredators(cell);
                fulfillHerbivores(cell);
                fulfillPlants(cell);
                islandPlace.getCells()[x][y] = cell;

            }
        }
    }

    private void fulfillPlants(Cell cell) {
        Random random = new Random();
        int plantsCount = random.nextInt(200);
        for (int i = 0; i < plantsCount; i++) {
            Gras gras = new Gras();
            addPlantsToCell(cell, gras);
        }
    }

    private void addPlantsToCell(Cell cell, Gras gras) {
        cell.getGrases().computeIfAbsent(TypePlants.GRAS, k -> new HashSet<>()).add(gras); //52.32
    }

    private void fulfillHerbivores(Cell cell) {
        Random random = new Random();

        Map<TypeHerbivore, Integer> maxHerbivoresCount = new EnumMap<>(TypeHerbivore.class);
        maxHerbivoresCount.put(TypeHerbivore.HORSE, 20);
        maxHerbivoresCount.put(TypeHerbivore.DEER, 20);
        maxHerbivoresCount.put(TypeHerbivore.RABBIT, 150);
        maxHerbivoresCount.put(TypeHerbivore.MOUSE, 500);
        maxHerbivoresCount.put(TypeHerbivore.GOAT, 140);
        maxHerbivoresCount.put(TypeHerbivore.SHEEP, 140);
        maxHerbivoresCount.put(TypeHerbivore.BOAR, 50);
        maxHerbivoresCount.put(TypeHerbivore.BUFFALO, 10);
        maxHerbivoresCount.put(TypeHerbivore.DUCK, 200);
        maxHerbivoresCount.put(TypeHerbivore.CATERPILLAR, 1000);

        for (TypeHerbivore type : TypeHerbivore.values()) {
            int maxCount = maxHerbivoresCount.getOrDefault(type, 0);
            int animalCount = random.nextInt(maxCount + 1);

            for (int i = 0; i < animalCount; i++) {
                Herbivore herbivore = createHerbivoreByType(type);
                addHerbivoreToCell(cell, herbivore);
            }
        }
    }
    private void addHerbivoreToCell(Cell cell, Herbivore herbivore) {
        TypeHerbivore typeHerbivore = getTypeHerbivore(herbivore);
        cell.getHerbivore().computeIfAbsent(typeHerbivore, k -> new HashSet<>()).add(herbivore); //52.32
    }

    private void fulfillPredators(Cell cell) {
        Random random = new Random();
        Map<Type, Integer> maxPredatorsCount = new EnumMap<>(Type.class);
        maxPredatorsCount.put(Type.WOLF, 30);
        maxPredatorsCount.put(Type.BEAR, 5);
        maxPredatorsCount.put(Type.FOX, 30);
        maxPredatorsCount.put(Type.EAGLE, 20);
        maxPredatorsCount.put(Type.BOA, 30);

        for (Type type : Type.values()) {
            int maxCount = maxPredatorsCount.getOrDefault(type, 0);
            int animalCount = random.nextInt(maxCount + 1);

            for (int i = 0; i < animalCount; i++) {
                Predator predator = createAnimalByType(type);
                addPredatorsToCell(cell, predator);
            }
        }
    }
    public Predator createAnimalByType(Type type) {
        return switch (type) {
            case WOLF -> new Wolf();
            case BOA -> null; //удав
            case BEAR -> new Bear();
            case EAGLE -> null;
            case FOX -> new Fox();
        };
        //throw new IllegalArgumentException("Unknown Animal: " + type);
    }
    public Herbivore createHerbivoreByType(TypeHerbivore type) {
        return switch (type) {
            case DEER -> null; //Олень
            case RABBIT -> null;
            case MOUSE -> null;
            case GOAT -> null; // козел
            case SHEEP -> null;
            case BOAR -> null; //кабан
            case BUFFALO -> null; //буйвол
            case DUCK -> null; //утка
            case CATERPILLAR -> null; // гусеница
            case HORSE -> null;
        };
        //throw new IllegalArgumentException("Unknown Animal: " + type);
    }
    private void addPredatorsToCell(Cell cell, Predator predator) {
        Type predatorType = getTypePredator(predator);
        cell.getPredators().computeIfAbsent(predatorType, k -> new HashSet<>()).add(predator); //52.32
    }
    public TypeHerbivore getTypeHerbivore(Herbivore herbivore) {
        if (herbivore instanceof Herbivore){
            //Виявлення типу тварини
        }
        throw new IllegalArgumentException("Невідомий тип тварини" + herbivore.getClass().getSimpleName());
    }
    public Type getTypePredator(Predator predator) {
        if (predator instanceof Predator){
            //Виявлення типу тварини
        }
        throw new IllegalArgumentException("Невідомий тип тварини" + predator.getClass().getSimpleName());
    }
}
