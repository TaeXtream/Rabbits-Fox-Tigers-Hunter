package io.muic.ooc.fab;

import java.util.List;
import java.util.Random;

public abstract class Animal {
    private boolean alive = true;
    private Location location;
    // The field occupied.
    protected Field field;
    private int age = 0;
    // Random generator
    protected static final Random RANDOM = new Random();

    public void initialize(boolean randomAge,Field field, Location location) {
        this.field = field;
        setLocation(location);
        if (randomAge) {
            age = RANDOM.nextInt(getmax_age());
        }
    }

    protected abstract Location moveToNewLocation();

    public void behavior(List<Animal> newAnimals){
        incrementAge();
        if (isAlive()) {
            giveBirth(newAnimals);
            // Try to move into a free location.
            Location newLocation = moveToNewLocation();
            if (newLocation != null) {
                setLocation(newLocation);
            } else {
                // Overcrowding.
                setDead();
            }
        }
    }

    protected Animal breed(boolean randomAge,Field field, Location location){
        return AnimalFactory.createAnimal(this.getClass(), field, location);
    }


    private void giveBirth(List<Animal> newAnimals) {
        // New rabbits are born into adjacent locations.
        // Get a list of adjacent free locations.
        List<Location> free = field.getFreeAdjacentLocations(getLocation());
        int births = breed();
        for (int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Animal young = breed(false, field, loc);
            newAnimals.add(young);
        }
    }


    public boolean isAlive() {
        return alive;
    }

    /**
     * Indicate that the rabbit is no longer alive. It is removed from the
     * field.
     */
    protected void setDead() {
        alive = false;
        if (location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    /**
     * Place the rabbit at the new location in the given field.
     *
     * @param newLocation The rabbit's new location.
     */
    protected void setLocation(Location newLocation) {
        if (location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    /**
     * Return the rabbit's location.
     *
     * @return The rabbit's location.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Increase the age. This could result in the fox's death.
     */
    protected void incrementAge() {
        age++;
        if (age > getmax_age()) {
            setDead();
        }
    }

    protected abstract int getmax_age();


    protected abstract double getBreedingProp();
    protected abstract int getMaxLitterSize();
    protected abstract int getBreedingAge();

    /**
     * Generate a number representing the number of births, if it can breed.
     *
     * @return The number of births (may be zero).
     */
    protected int breed() {
        int births = 0;
        if (canBreed() && RANDOM.nextDouble() <= getBreedingProp()) {
            births = RANDOM.nextInt(getMaxLitterSize()) + 1;
        }
        return births;
    }

    /**
     * A fox can breed if it has reached the breeding age.
     */
    private boolean canBreed() {
        return age >= getBreedingAge();
    }

}
