package com.javarush.items.animals.predators;

import com.javarush.items.animals.Animals;
import com.javarush.service.Type;

public abstract class Predator extends Animals {
    public abstract Type getType();
}
