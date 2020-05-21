package io.muic.ooc.fab;

import java.util.List;
import java.util.Random;

public class Rabbit extends Animal {
    // Characteristics shared by all rabbits (class variables).

    // The age at which a rabbit can start to breed.
    private static final int BREEDING_AGE = 5;
    // The age to which a rabbit can live.
    private static final int MAX_AGE = 40;
    // The likelihood of a rabbit breeding.
    private static final double BREEDING_PROBABILITY = 0.12;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 4;


    // Individual characteristics (instance fields).
    // The rabbit's age.
    private int age;


    @Override
    protected Location moveToNewLocation() {
        return field.freeAdjacentLocation(getLocation());
    }



    /**
     * A rabbit can breed if it has reached the breeding age.
     *
     * @return true if the rabbit can breed, false otherwise.
     */

    @Override
    protected int getmax_age() {
        return 40;
    }

    @Override
    protected double getBreedingProp() {
        return 0.12;
    }

    @Override
    protected int getMaxLitterSize() {
        return 4;
    }

    @Override
    protected int getBreedingAge() {
        return 5;
    }
}
