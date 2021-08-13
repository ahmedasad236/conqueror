package units;

public abstract class Unit {
    int level; //The current level of a unit.
    int maxSoldierCount; //The maximum number of soldiers a unit can hold.
    int currentSoldierCount; //The current number of soldiers inside a unit.
    double idleUpkeep; //The amount of food a unit will consume when being idle.
    double marchingUpkeep; //The amount of food a unit will consume when marching to another city.
    double siegeUpkeep; //The amount of food a unit will consume when laying siege.
    
    public Unit(int level,int maxSoldierConunt,double idleUpkeep, double
            marchingUpkeep,double siegeUpkeep)
    {
        this.level = level;
        this.maxSoldierCount = maxSoldierConunt;
        this.idleUpkeep = idleUpkeep;
        this.marchingUpkeep = marchingUpkeep;
        this.siegeUpkeep = siegeUpkeep;
    }

    //Getters
    public int getLevel() {
        return level;
    }

    public int getMaxSoldierCount() {
        return maxSoldierCount;
    }

    public int getCurrentSoldierCount() {
        return currentSoldierCount;
    }

    public double getIdleUpkeep() {
        return idleUpkeep;
    }

    public double getSiegeUpKeep() {
        return siegeUpkeep;
    }
    
}
