package io.muic.ooc.fab.LivingThing;

import io.muic.ooc.fab.Field;
import io.muic.ooc.fab.Location;

import java.util.List;

public abstract class Entity {
    private boolean alive = true;
    private Location location;
    // The field occupied.
    protected Field field;

    public void initialize(Field field, Location location) {
        this.field = field;
        setLocation(location);
    }

    public abstract void behavior(List<Animal> newAnimals);

    protected abstract Location moveToNewLocation();

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
        this.location = newLocation;
        field.place(this, newLocation);
    }

    protected void setLocation(int row, int col) {
        Location newLocation = new Location(row, col);
        if (this.location != null) {
            field.clear(this.location);
        }
        this.location = newLocation;
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
}
