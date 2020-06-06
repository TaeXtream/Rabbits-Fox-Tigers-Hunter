package io.muic.ooc.fab;

import java.awt.*;

public enum AnimalType {
    RABBIT(0.08, Rabbit.class, Color.ORANGE),
    FOX(0.05, Fox.class, Color.BLUE),
    TIGER(0.03, Tiger.class, Color.RED),
    HUNTER(0.001, Hunter.class, Color.BLACK);

    private final double breedingProbability;

    private final Class animalClass;

    private final Color color;

    AnimalType(double probability, Class animalClass, Color color){
        this.breedingProbability = probability;
        this.animalClass = animalClass;
        this.color = color;
    }

    public double getbreedingProbability() {
        return breedingProbability;
    }

    public Class getAnimalClass() {
        return animalClass;
    }

    public Color getColor() {
        return color;
    }
}
