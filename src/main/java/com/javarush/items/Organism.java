package com.javarush.items;

import com.javarush.abstracts.Reproductable;

public abstract class Organism<T> implements Reproductable {
    public int lifeLevel = 100;
    //public int numMax;

    public void setLifeLevel(int lifeLevel) {
        this.lifeLevel = lifeLevel;
    }
    public int getLifeLevel() {
        return this.lifeLevel;
    }

}
