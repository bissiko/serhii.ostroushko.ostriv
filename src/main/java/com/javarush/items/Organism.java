package com.javarush.items;

import com.javarush.abstracts.Reproductable;

public abstract class Organism implements Reproductable {
    public int lifeLevel = 99;
    public void setLifeLevel(int lifeLevel) {
        this.lifeLevel = lifeLevel;
    }
    public int getLifeLevel() {
        return this.lifeLevel;
    }

}
