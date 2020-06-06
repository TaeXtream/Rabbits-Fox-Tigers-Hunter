package io.muic.ooc.fab;

import java.util.HashMap;
import java.util.Map;

public class AnimalFactory {


    private static final Map<AnimalType, Class> animalClassMap = new HashMap<AnimalType, Class>() {{
        AnimalType[] animalTypes = AnimalType.values();
        for (AnimalType animalType : animalTypes) {
            put(animalType, animalType.getAnimalClass());
        }
    }};

    public static Animal createAnimal(AnimalType animalType, Field field ,Location location) {
        Class animalClass = animalClassMap.get(animalType);
        return createAnimal(animalClass, field, location);
    }

    public static Animal createAnimal(Class animalClass, Field field ,Location location){
        if (animalClass != null){
            try {
                Animal animal = (Animal) animalClass.newInstance();
                animal.initialize(true, field, location);
                return animal;
            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            catch (InstantiationException e){
                e.printStackTrace();
            }
        }
        throw  new IllegalArgumentException("Unknown Animal Type");
    }
}
