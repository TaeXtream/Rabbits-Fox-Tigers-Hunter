package io.muic.ooc.fab;

import io.muic.ooc.fab.LivingThing.Entity;
import io.muic.ooc.fab.LivingThing.EntityFactory;
import io.muic.ooc.fab.LivingThing.EntityType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FieldPopulator {
    // Random generator
    private static final Random RANDOM = new Random();


    private final Map<EntityType, Double> propbailityMap = new HashMap<EntityType, Double>() {{
        EntityType[] entityTypes = EntityType.values();
        for (EntityType entityType : entityTypes) {
            put(entityType, entityType.getSpawningProbability());
        }
    }};


    /**
     * Randomly populate the field with Animals.
     */
    public void populate(Field field, List<Entity> entities) {
        field.clear();
        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                for(Map.Entry<EntityType, Double> entry : propbailityMap.entrySet()){
                    if(RANDOM.nextDouble() <= entry.getValue()){
                        Location location = new Location(row, col);
                        Entity entity = EntityFactory.createEntity(entry.getKey() , field, location);
                        entities.add(entity);
                        break;
                    }
                }


            }
        }
    }
}
