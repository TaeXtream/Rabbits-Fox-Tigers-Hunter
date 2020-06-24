package io.muic.ooc.fab.LivingThing;

import io.muic.ooc.fab.Field;
import io.muic.ooc.fab.Location;

import java.util.List;

public class Fox extends Animal {
    // Characteristics shared by all foxes (class variables).


    /**
     * Create a fox. A fox can be created as a new born (age zero and not
     * hungry) or with a random age and food level.
     *
     * @param randomAge If true, the fox will have random age and hunger level.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */

    @Override
    public void initialize(boolean randomAge, Field field, Location location) {
        super.initialize(randomAge, field, location);
        this.getPreys().put(Rabbit.class, FoodLevel.SMALLFOOD);
    }



    /**
     * This is what the fox does most of the time: it hunts for rabbits. In the
     * process, it might breed, die of hunger, or die of old age.
     *
     * @param newAnimal A list to return newly born foxes.
     */
    @Override
    public void behavior(List<Animal> newAnimal) {
        this.incrementHunger();
        super.behavior(newAnimal);
    }


    @Override
    protected int getmax_age() {
        return 150;
    }

    @Override
    protected double getBreedingProp() {
        return 0.1;
    }

    @Override
    protected int getMaxLitterSize() {
        return 2;
    }

    @Override
    protected int getBreedingAge() {
        return 15;
    }


}
