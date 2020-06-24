package io.muic.ooc.fab.LivingThing;

import io.muic.ooc.fab.Field;
import io.muic.ooc.fab.Location;

import java.util.List;

public abstract class Entity {
    private boolean alive;
    private Location location;
    // The field occupied.
    protected Field field;

    public void initialize(boolean randomAge, Field field, Location location) {
        this.field = field;
        alive = true;
        setLocation(location);
    }

    public abstract void behavior(List<Entity> newEntities);

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
    public void setLocation(Location newLocation) {
        if (location != null) {
            field.clear(location);
        }

        this.location = newLocation;
        field.place(this, location);
    }

    public void setLocation(int row, int col) {
        if (location != null) {
            field.clear(location);
        }
        this.location = new Location(row, col);
        field.place(this, location);
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
