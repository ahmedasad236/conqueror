package units;

public abstract class Unit {
    private int level; //The current level of a unit.
    private int maxSoldierCount; //The maximum number of soldiers a unit can hold.
    private int currentSoldierCount; //The current number of soldiers inside a unit.
    private double idleUpkeep; //The amount of food a unit will consume when being idle.
    private double marchingUpkeep; //The amount of food a unit will consume when marching to another city.
    private double siegeUpkeep; //The amount of food a unit will consume when laying siege.
    
    public Unit(int level,int maxSoldierConunt,double idleUpkeep, double
            marchingUpkeep,double siegeUpkeep)
    {
        this.level = level;
        this.maxSoldierCount = maxSoldierConunt;
        this.idleUpkeep = idleUpkeep;
        this.marchingUpkeep = marchingUpkeep;
        this.siegeUpkeep = siegeUpkeep;
    }

    //Setters
    public void setCurrentSoldierCount(int count){
        this.currentSoldierCount=count;
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

    public double getMarchingUpkeep(){
        return marchingUpkeep;
    }

    public double getSiegeUpKeep() {
        return siegeUpkeep;
    }
    
}
