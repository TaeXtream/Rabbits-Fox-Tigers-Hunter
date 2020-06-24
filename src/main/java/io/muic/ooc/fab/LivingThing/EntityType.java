package io.muic.ooc.fab.LivingThing;

import java.awt.*;

public enum EntityType {
    RABBIT(0.08, Rabbit.class, Color.ORANGE),
    FOX(0.05, Fox.class, Color.BLUE),
    TIGER(0.04, Tiger.class, Color.RED),
    HUNTER(0.001, Hunter.class, Color.BLACK)
    ;

    private final double breedingProbability;

    private final Class entityClass;

    private final Color color;

    EntityType(double probability, Class entityClass, Color color){
        this.breedingProbability = probability;
        this.entityClass = entityClass;
        this.color = color;
    }

    public double getbreedingProbability() {
        return breedingProbability;
    }

    public Class getEntityClass() {
        return entityClass;
    }

    public Color getColor() {
        return color;
    }
}
