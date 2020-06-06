package io.muic.ooc.fab;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FieldPopulator {

    private final Map<AnimalType, Double> propbailityMap = new HashMap<AnimalType, Double>() {{
        AnimalType[] animalTypes = AnimalType.values();
        for (AnimalType animalType : animalTypes) {
            put(animalType, animalType.getbreedingProbability());
        }
    }};

    // Random generator
    private static final Random RANDOM = new Random();


    /**
     * Randomly populate the field with Animals.
     */
    public void populate(Field field, List<Animal> animals) {

        field.clear();
        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                for (Map.Entry<AnimalType, Double> entry: propbailityMap.entrySet()){
                    if (RANDOM.nextDouble() <= entry.getValue()){
                        Location location = new Location(row, col);
                        Animal animal = AnimalFactory.createAnimal(entry.getKey(), field, location);
                        animals.add(animal);
                        break;
                    }
                }

            }
        }
    }
}
