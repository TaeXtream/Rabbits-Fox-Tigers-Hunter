package io.muic.ooc.fab.LivingThing;

import io.muic.ooc.fab.Field;
import io.muic.ooc.fab.Location;

import java.util.List;

public class Hunter extends Entity {


    @Override
    public void behavior(List<Entity> newAnimals) {
        if(this.isAlive()){
            Location nextLocation = moveToNewLocation();
            if (nextLocation != null) {
                setLocation(nextLocation);
                this.field.place(this, nextLocation);
            } else {
                setLocation(this.getLocation());
                this.field.place(this, this.getLocation());
            }
        }
    }

    @Override
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
            if (animal instanceof Animal) {
                Animal prey = (Animal) animal;
                if (prey.isAlive()) {
                    prey.setDead();
                }
            }
            return where;
        }
        return null;
    }

}
