package io.muic.ooc.fab.LivingThing;

public enum FoodLevel {

    SMALLFOOD(5),
    BIGFOOD(10);

    private int foodLevel;

    FoodLevel(int foodLevel){
        this.foodLevel = foodLevel;
    }

    public int getFoodLevel() {
        return foodLevel;
    }

    public void setFoodLevel(int foodLevel) {
        this.foodLevel = foodLevel;
    }
}
