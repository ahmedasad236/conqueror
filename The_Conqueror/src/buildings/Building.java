package buildings;
import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;

public abstract class Building {
    private int cost;
    private int level=1;
    private int upgradeCost;
    private boolean coolDown=true;
    final static int MAX_LEVEL = 3; 

    public int getCost(){
        return cost;
    }
    public void setLevel(int l){
        this.level=l;
    }
    public int getLevel(){
        return level;
    }
    public void setUpgradeCost(int upgrade){
        this.upgradeCost=upgrade;
    }
    public int getUpgradeCost(){
        return upgradeCost;
    }
    public void setCoolDown(boolean cool){
        this.coolDown=cool;
    }
    public boolean isCoolDown(){
        return coolDown;
    }
    public Building(int cost,int upgradeCost) {
        this.cost = cost;
        this.upgradeCost = upgradeCost;
    }
    

    public void upgrade() throws BuildingInCoolDownException, MaxLevelException{
        
        if(isCoolDown()){
            throw new BuildingInCoolDownException("Building is cooling down");
        }

        if (getLevel() == MAX_LEVEL){
            throw new MaxLevelException("Max Level has been reached");
        }
 
        setLevel(getLevel()+1);
        setCoolDown(true);   
    }
    
}