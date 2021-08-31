package units;

public abstract class Unit {
    private int level; //The current level of a unit.
    private int maxSoldierCount; //The maximum number of soldiers a unit can hold.
    private int currentSoldierCount; //The current number of soldiers inside a unit.
    private double idleUpkeep; //The amount of food a unit will consume when being idle.
    private double marchingUpkeep; //The amount of food a unit will consume when marching to another city.
    private double siegeUpkeep; //The amount of food a unit will consume when laying siege.
    private Army ParentArmy;

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

    public void setParentArmy(Army Parent){
        this.ParentArmy=Parent;
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
    
    public Army getParentArmy(){
        return this.ParentArmy;
    }

    public double getFoodNeeded() {
        
        Status stat = ParentArmy.getCurrenStatus();
        double keepUp = 0.0;

        switch (stat) {
            case IDLE :
                keepUp = idleUpkeep;
                break;
            
            case MARCHING:
                keepUp = marchingUpkeep;
                break;
            
            case BESIEGING:
                keepUp = siegeUpkeep;
                break;
        }    

        return keepUp * currentSoldierCount;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Unit))
            return false;
        
        Unit unit = (Unit)obj;
        return (this.currentSoldierCount == unit.currentSoldierCount && this.level == unit.level
        && this.idleUpkeep == unit.idleUpkeep && this.marchingUpkeep == unit.marchingUpkeep &&
        this.siegeUpkeep == unit.siegeUpkeep && this.ParentArmy == unit.ParentArmy);
    }    
}
