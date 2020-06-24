package io.muic.ooc.fab.LivingThing;

import io.muic.ooc.fab.Field;
import io.muic.ooc.fab.Location;

import java.util.HashMap;
import java.util.Map;

public class EntityFactory {


    private static final Map<EntityType, Class> entityClassMap = new HashMap<EntityType, Class>() {{
        EntityType[] entityTypes = EntityType.values();
        for (EntityType entityType : entityTypes) {
            put(entityType, entityType.getEntityClass());
        }
    }};

    public static Entity createEntity(EntityType entityType, Field field , Location location) {
        Class entityClass = entityClassMap.get(entityType);
        return createEntity(entityClass, field, location);
    }

    public static Entity createEntity(Class entityClass, Field field , Location location){
        if (entityClass != null){
            try {
                Entity entity = (Entity) entityClass.newInstance();
                entity.initialize(field, location);
                return entity;
            }
            catch (IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
        throw  new IllegalArgumentException("Unknown Entity Type");
    }
}
