package io.muic.ooc.fab.LivingThing;

import io.muic.ooc.fab.Field;
import io.muic.ooc.fab.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EntityFactory {
    // Random generator
    private static final Random RANDOM = new Random();

    private static final Map<EntityType, Class> entityClassMap = new HashMap<EntityType, Class>() {{
        EntityType[] entityTypes = EntityType.values();
        for (EntityType entityType : entityTypes) {
            put(entityType, entityType.getEntityClass());
        }
    }};

    public static Entity createEntity(EntityType entityType, Field field, Location location) {
        Class entityClass = entityClassMap.get(entityType);
        return createEntity(entityClass, field, location);
    }

    public static Entity createEntity(Class entityClass, Field field , Location location){
        if (entityClass != null){
            try {
                Entity entity = (Entity) entityClass.newInstance();
                entity.initialize(true, field, location);
                return entity;
            }
            catch (IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
        throw new IllegalArgumentException("Unknown Entity Type");
    }



}
