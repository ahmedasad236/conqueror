package units;

import exceptions.FriendlyFireException;

public abstract class Unit {
    private int level; 
    private int maxSoldierCount; 
    private int currentSoldierCount; 
    private double idleUpkeep; 
    private double marchingUpkeep; 
    private double siegeUpkeep; 
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
