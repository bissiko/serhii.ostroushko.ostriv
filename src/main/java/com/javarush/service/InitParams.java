package com.javarush.service;

import static com.javarush.service.Type.*;
import static com.javarush.service.TypeHerbivore.*;
import static com.javarush.service.TypeHerbivore.CATERPILLAR;
import static com.javarush.service.TypePlants.GRAS;

public class InitParams {
    public static final int widthIsland = 120;

    public static final int heightIsland = 20;
    public static final Type[] typesPredators = {WOLF, BOA, BEAR, EAGLE, FOX};
    public static final int[] speedMaxPredators = {3, 1, 2, 3, 2};
    public static final double[] eatMaxPredators = {8, 3, 80, 1, 2};
    public static final int[] numMaxPredators = {30, 30, 5, 20, 30}; //Max number of Predators in Cell
    public static final int[] numMaxHerbivores = {20, 20, 150, 500, 140, 140, 50, 10, 200, 1000}; //Max number of Herbivores in Cell

                        //HORSE, DEER, RABBIT, MOUSE, GOAT, SHEEP, BOAR, BUFFALO, DUCK, CATERPILLAR
    public static final int[] eatHerbivoreWolf = {10, 15, 60, 80, 60, 70, 15, 10, 40, 0};
    public static final int[] eatHerbivoreBoa = {0, 0, 20, 40, 0, 0, 0, 0, 10, 0};
    public static final int[] eatHerbivoreEagle = {0, 0, 90, 90, 0, 0, 0, 0, 80, 0};
    public static final int[] eatHerbivoreBear = {40, 80, 80, 90, 70, 70, 50, 20, 10, 0};
    public static final int[] eatHerbivoreFox = {0, 0, 70, 90, 0, 0, 0, 0, 60, 40};

    public static final int[] speedMaxHerbivores = {4, 2, 2, 1, 3, 3, 2, 3, 4, 0};
    public static final double[] eatMaxHerbivores = {60, 50, 0.45, 0.01, 10, 15, 50, 100, 0.15, 0};

    public static final TypeHerbivore[] typesHerbivore = {HORSE, DEER, RABBIT, MOUSE, GOAT, SHEEP, BOAR, BUFFALO, DUCK, CATERPILLAR};

    public static final int[] eatHerbivoreHorse = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static final int[] eatHerbivoreDeer = {0, 0, 0, 0, 0, 0, 0, 0, 0, 90};
    public static final int[] eatHerbivoreRabbit = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static final int[] eatHerbivoreMouse = {0, 0, 0, 0, 0, 0, 0, 0, 0, 90};
    public static final int[] eatHerbivoreGoat = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static final int[] eatHerbivoreSheep = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static final int[] eatHerbivoreBoar = {0, 0, 0, 50, 0, 0, 0, 0, 0, 90};
    public static final int[] eatHerbivoreBuffalo = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static final int[] eatHerbivoreDuck = {0, 0, 0, 0, 0, 0, 0, 0, 0, 90};
    public static final int[] eatHerbivoreCaterpillar = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static final TypePlants[] typesPlants = {GRAS};
    public static final int[] eatPlants = {100};
    public static final int againEatMax = 20; //max number of times to eat the same Type Animals for one time
    public static final int againEatMaxPlants = 20; //max number of times to eat the same Type Plants for one time
    public static final int reproductValuePredator = 60; // Predator не може розмножуватися кожен день, а раз на стільки днів
    public static final int reproductValueHerbivore = 15; // Herbivore не може розмножуватися кожен день, а раз на стільки днів
    public static final int reproductValuePlants = 4;
    public static final int numMaxGras = 200; // maximum number of Gras in Cell;
    public static int weightGras = 1; //  weight of Gras;
}
