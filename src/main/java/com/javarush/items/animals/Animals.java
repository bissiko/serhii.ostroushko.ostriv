package com.javarush.items.animals;

import com.javarush.abstracts.Movable;
import com.javarush.abstracts.Reproductable;
import com.javarush.items.Organism;
import com.javarush.items.animals.herbivores.Herbivore;
import com.javarush.items.animals.predators.Predator;
import com.javarush.place.Cell;
import com.javarush.service.Type;
import com.javarush.service.TypeHerbivore;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public abstract class Animals extends Organism implements Movable, Reproductable {
    @Override
    public void move() {

    }

    //public abstract boolean tryEating(Cell cell, Animals animals);
}
