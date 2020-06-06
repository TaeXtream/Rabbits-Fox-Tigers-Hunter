package io.muic.ooc.fab;


public class Rabbit extends Animal {



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
        return 0.15;
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
