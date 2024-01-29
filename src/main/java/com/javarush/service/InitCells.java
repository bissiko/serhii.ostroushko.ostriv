package com.javarush.service;

import com.javarush.items.animals.herbivores.*;
import com.javarush.items.animals.predators.*;
import com.javarush.items.plants.Gras;
import com.javarush.items.plants.Plants;
import com.javarush.place.Cell;
import com.javarush.place.IslandPlace;

import java.util.*;

//import static com.javarush.service.Type.WOLF;

public class InitCells {
    public IslandPlace islandPlace = new IslandPlace();
    public void initCells() {
        for (int x = 0; x < islandPlace.getWidth(); x++) {
            for (int y = 0; y < islandPlace.getHeight(); y++) {
                Cell cell = new Cell(new HashMap<Type, Set< Predator >>(),
                        new HashMap<TypeHerbivore, Set< Herbivore >>(),
                        new HashMap<TypePlants, Set<Plants>>());
                fulfillPredators(cell);
                fulfillHerbivores(cell);
                fulfillPlants(cell);
                islandPlace.getCells()[x][y] = cell;

                System.out.println("Cell: " + x + "-" + y +
                        ". Predators: " + islandPlace.getCells()[x][y].getPredators().size() +
                        " Gras: " + islandPlace.getCells()[x][y].getPlants().size() +
                        " Herbivore: " + islandPlace.getCells()[x][y].getHerbivore().size());
            }
        }
    }

    private void fulfillPlants(Cell cell) {
        Random random = new Random();
        Map<TypePlants, Integer> maxPlantsCount = new EnumMap<>(TypePlants.class);
        maxPlantsCount.put(TypePlants.GRAS, Gras.numMax); //20.

        for (TypePlants type : TypePlants.values()) {
            int maxCount = maxPlantsCount.getOrDefault(type, 0);
            int plantsCount = random.nextInt(maxCount + 1);

            for (int i = 0; i < plantsCount; i++) {
                Plants plant = createPlantByType(type);
                addPlantsToCell(cell, plant);
            }
        }
    }

    private void addPlantsToCell(Cell cell, Plants plant) {
        TypePlants typePlants = getTypePlants(plant);
        cell.getPlants().computeIfAbsent(typePlants, k -> new HashSet<>()).add(plant); //52.32
    }

    private void fulfillHerbivores(Cell cell) {
        Random random = new Random();

        Map<TypeHerbivore, Integer> maxHerbivoresCount = new EnumMap<>(TypeHerbivore.class);
        maxHerbivoresCount.put(TypeHerbivore.HORSE, Horse.numMax); //20.
        maxHerbivoresCount.put(TypeHerbivore.DEER, Deer.numMax); //20
        maxHerbivoresCount.put(TypeHerbivore.RABBIT, Rabbit.numMax); //150
        maxHerbivoresCount.put(TypeHerbivore.MOUSE, Mouse.numMax); //500
        maxHerbivoresCount.put(TypeHerbivore.GOAT, Goat.numMax); //140
        maxHerbivoresCount.put(TypeHerbivore.SHEEP, Sheep.numMax); //140
        maxHerbivoresCount.put(TypeHerbivore.BOAR, Boar.numMax); //50
        maxHerbivoresCount.put(TypeHerbivore.BUFFALO, Buffalo.numMax); //10
        maxHerbivoresCount.put(TypeHerbivore.DUCK, Duck.numMax); //200
        maxHerbivoresCount.put(TypeHerbivore.CATERPILLAR, Caterpillar.numMax); //1000

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
        maxPredatorsCount.put(Type.WOLF, Wolf.numMax); //30
        maxPredatorsCount.put(Type.BEAR, Bear.numMax); //5
        maxPredatorsCount.put(Type.FOX, Fox.numMax); //30
        maxPredatorsCount.put(Type.EAGLE, Eagle.numMax); //20
        maxPredatorsCount.put(Type.BOA, Boa.numMax); //30

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
            case BOA -> new Boa(); //удав
            case BEAR -> new Bear();
            case EAGLE -> new Eagle();
            case FOX -> new Fox();
        };
        //throw new IllegalArgumentException("Unknown Animal: " + type);
    }
    public Herbivore createHerbivoreByType(TypeHerbivore type) {
        return switch (type) {
            case DEER -> new Deer(); //Олень
            case RABBIT -> new Rabbit();
            case MOUSE -> new Mouse();
            case GOAT -> new Goat(); // козел
            case SHEEP -> new Sheep();
            case BOAR -> new Boar(); //кабан
            case BUFFALO -> new Buffalo(); //буйвол
            case DUCK -> new Duck(); //утка
            case CATERPILLAR -> new Caterpillar(); // гусеница
            case HORSE -> new Horse();
        };
        //throw new IllegalArgumentException("Unknown Animal: " + type);
    }
    public Plants createPlantByType(TypePlants type) {
        return switch (type) {
            case GRAS -> new Gras();
            default -> new Gras();
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
            return ((Herbivore)herbivore).getType();
        }
        throw new IllegalArgumentException("Невідомий тип тварини" + herbivore.getClass().getSimpleName());
    }
    public Type getTypePredator(Predator predator) {
        if (predator instanceof Predator){
            //Виявлення типу тварини
            return ((Predator)predator).getType();
        }
        throw new IllegalArgumentException("Невідомий тип тварини" + predator.getClass().getSimpleName());
    }
    public TypePlants getTypePlants(Plants plants) {
        if (plants instanceof Plants){
            //Виявлення типу рослини
            return ((Plants)plants).getType();
        }
        throw new IllegalArgumentException("Невідомий тип рослини" + plants.getClass().getSimpleName());
    }
}
