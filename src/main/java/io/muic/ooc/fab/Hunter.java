package io.muic.ooc.fab;

import java.util.List;
import java.util.Random;

public class Hunter extends Animal {

    @Override
    public void initialize(boolean randomAge, Field field, Location location) {
        super.initialize(randomAge, field, location);
    }

    protected Location moveToNewLocation() {
        Location newLocation = findTarget();
        if (newLocation == null) {
            newLocation = field.freeAdjacentLocation(getLocation());
        }
        return newLocation;
    }

    private Location findTarget() {
        List<Location> adjacent = field.adjacentLocations(getLocation());
        for (Location where : adjacent) {
            Object animal = field.getObjectAt(where);
            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if (rabbit.isAlive()) {
                    rabbit.setDead();
                    return where;
                }
            } else if (animal instanceof Fox) {
                Fox fox = (Fox) animal;
                if (fox.isAlive()) {
                    fox.setDead();
                    return where;
                }
            } else if (animal instanceof Tiger) {
                Tiger tiger = (Tiger) animal;
                if (tiger.isAlive()) {
                    tiger.setDead();
                    return where;
                }
            }
        }
        return null;
    }


    @Override
    protected int getmax_age() {
        return Integer.MAX_VALUE;
    }

    @Override
    protected double getBreedingProp() {
        return 0;
    }

    @Override
    protected int getMaxLitterSize() {
        return 0;
    }

    @Override
    protected int getBreedingAge() {
        return 0;
    }

}
