package io.muic.ooc.fab.LivingThing;

import io.muic.ooc.fab.Field;
import io.muic.ooc.fab.Location;

import java.util.List;

public class Tiger extends Animal {
    // Characteristics shared by all foxes (class variables).
    {
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
    public void behavior(List<Entity> newAnimal) {
        incrementHunger();
        super.behavior(newAnimal);
    }



    @Override
    protected int getmax_age() {
        return 200;
    }

    @Override
    protected double getBreedingProp() {
        return 0.01;
    }

    @Override
    protected int getMaxLitterSize() {
        return 3;
    }

    @Override
    protected int getBreedingAge() {
        return 25;
    }


}
