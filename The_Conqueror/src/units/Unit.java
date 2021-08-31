package units;

import exceptions.FriendlyFireException;

public abstract class Unit {
    private int level; //The current level of a unit.
    private int maxSoldierCount; //The maximum number of soldiers a unit can hold.
    private int currentSoldierCount; //The current number of soldiers inside a unit.
    private double idleUpkeep; //The amount of food a unit will consume when being idle.
    private double marchingUpkeep; //The amount of food a unit will consume when marching to another city.
    private double siegeUpkeep; //The amount of food a unit will consume when laying siege.
    private double [] ArcherFactor = new double[3]; 
    private double [] InfantryFactor = new double[3];
    private double [] CavalryFactor = new double[3];
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
    protected void setArcherFactor(double x,double y,double z){
        ArcherFactor[0]=x;
        ArcherFactor[1]=y;
        ArcherFactor[2]=z;
    }
    protected void setInfantryFactor(double x,double y,double z){
        InfantryFactor[0]=x;
        InfantryFactor[1]=y;
        InfantryFactor[2]=z;
    }
    protected void setCavalryFactor(double x,double y,double z){
        CavalryFactor[0]=x;
        CavalryFactor[1]=y;
        CavalryFactor[2]=z;
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

    //other methods
    public void attack(Unit target)throws FriendlyFireException{
        if(target.getParentArmy().equals(this.getParentArmy())){
            throw new FriendlyFireException("Error:You are trying to attack a Friend ");
        }
        if(target.getCurrentSoldierCount()<=0){
            target.setCurrentSoldierCount(0);
            //handleAttackedUnit(target);
        }
        else{
            if(target instanceof Archer){
                attack(target, ArcherFactor);
            }
            else if(target instanceof Cavalry){
                attack(target,CavalryFactor);
            }
            else{
                attack(target,InfantryFactor);
            }
        }

    }
    protected void attack(Unit target,double[] attacked){
        target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(attacked[this.getLevel()-1]*this.getCurrentSoldierCount()));
    }
    
}
