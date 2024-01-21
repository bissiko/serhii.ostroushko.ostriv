package com.javarush.items.animals;

import com.javarush.abstracts.Movable;
import com.javarush.abstracts.Reproductable;
import com.javarush.items.Organism;

public abstract class Animals extends Organism implements Movable, Reproductable {
    @Override
    public void move() {

    }

}
