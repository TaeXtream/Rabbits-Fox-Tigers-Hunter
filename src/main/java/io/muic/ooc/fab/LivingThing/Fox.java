package io.muic.ooc.fab.LivingThing;


import java.util.List;

public class Fox extends Animal {
    // Characteristics shared by all foxes (class variables).
    {
        this.getPreys().put(Rabbit.class, FoodLevel.BIGFOOD);
    }




    /**
     * This is what the fox does most of the time: it hunts for rabbits. In the
     * process, it might breed, die of hunger, or die of old age.
     *
     * @param newAnimal A list to return newly born foxes.
     */
    @Override
    public void behavior(List<Entity> newAnimal) {
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
        return 10;
    }


}
