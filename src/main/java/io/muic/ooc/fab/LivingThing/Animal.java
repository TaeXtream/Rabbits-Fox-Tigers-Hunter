package io.muic.ooc.fab.LivingThing;

import io.muic.ooc.fab.Field;
import io.muic.ooc.fab.Location;

import java.util.*;

public abstract class Animal extends Entity {
    private int age = 0;
    // Random generator
    protected static final Random RANDOM = new Random();
    private final Map<Class, FoodLevel> preys = new HashMap<>();
    private int foodLevel;

    public void initialize(boolean randomAge, Field field, Location location) {
        super.initialize(randomAge,field, location);
        foodLevel = RANDOM.nextInt(FoodLevel.BIGFOOD.getFoodLevel());
        if (randomAge) {
            age = RANDOM.nextInt(getmax_age());
        }
    }

    public void behavior(List<Entity> newEntities){
        incrementAge();
        if (isAlive()) {
            giveBirth(newEntities);
            // Try to move into a free location.
            Location newLocation = this.moveToNewLocation();
            if (newLocation != null) {
                setLocation(newLocation);
                field.place(this, newLocation);
            } else {
                // Overcrowding.
                setDead();
            }
        }
    }

    protected Location findFood() {
        List<Location> adjacent = field.adjacentLocations(getLocation());
        for (Location where : adjacent) {
            Object animal = field.getObjectAt(where);
            if (animal!=null && preys.containsKey(animal.getClass())) {
                Animal prey = (Animal) animal;
                if (prey.isAlive()) {
                    prey.setDead();
                    foodLevel += preys.get(animal.getClass()).getFoodLevel();
                    return where;
                }
            }
        }
        return null;
    }

    @Override
    protected Location moveToNewLocation() {
        Location newLocation = findFood();
        if (newLocation == null) {
            // No food found - try to move to a free location.
            newLocation = field.freeAdjacentLocation(getLocation());
        }
        return newLocation;
    }

    protected Animal breed(Field field, Location location){
        return (Animal) EntityFactory.createEntity(this.getClass(), field, location);
    }


    private void giveBirth(List<Entity> newAnimals) {
        // New rabbits are born into adjacent locations.
        // Get a list of adjacent free locations.
        List<Location> free = field.getFreeAdjacentLocations(getLocation());
        int births = breed();
        for (int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Animal young = breed(field, loc);
            newAnimals.add(young);
        }
    }

    public Map<Class, FoodLevel> getPreys() {
        return preys;
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

    protected void incrementHunger(){
        foodLevel--;
        if (foodLevel <= 0) {
            this.setDead();
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
