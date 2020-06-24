package io.muic.ooc.fab.LivingThing;

import java.awt.*;

public enum EntityType {
    RABBIT(0.3, Rabbit.class, Color.ORANGE),
    FOX(0.015, Fox.class, Color.BLUE),
    TIGER(0.06, Tiger.class, Color.RED),
    HUNTER(0.005, Hunter.class, Color.BLACK)
    ;

    private final double spawnProbability;

    private final Class entityClass;

    private final Color color;

    EntityType(double probability, Class entityClass, Color color){
        this.spawnProbability = probability;
        this.entityClass = entityClass;
        this.color = color;
    }

    public double getSpawningProbability() {
        return spawnProbability;
    }

    public Class getEntityClass() {
        return entityClass;
    }

    public Color getColor() {
        return color;
    }
}
