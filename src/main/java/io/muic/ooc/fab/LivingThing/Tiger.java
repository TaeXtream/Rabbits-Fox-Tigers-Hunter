package io.muic.ooc.fab.LivingThing;

import io.muic.ooc.fab.Field;
import io.muic.ooc.fab.Location;

import java.util.List;

public class Tiger extends Animal {
    // Characteristics shared by all foxes (class variables).


    // Individual characteristics (instance fields).
    // The fox's food level, which is increased by eating rabbits.

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
        this.getPreys().put(Fox.class, FoodLevel.BIGFOOD);
    }



    /**
     * This is what the fox does most of the time: it hunts for rabbits. In the
     * process, it might breed, die of hunger, or die of old age.
     *
     * @param newAnimal A list to return newly born foxes.
     */
    @Override
    public void behavior(List<Animal> newAnimal) {
        incrementHunger();
        super.behavior(newAnimal);
    }



    @Override
    protected int getmax_age() {
        return 200;
    }

    @Override
    protected double getBreedingProp() {
        return 0.05;
    }

    @Override
    protected int getMaxLitterSize() {
        return 2;
    }

    @Override
    protected int getBreedingAge() {
        return 28;
    }


}
