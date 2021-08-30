package buildings;
import exceptions.*;

public abstract class Building {
    private int cost;
    private int level=1;
    private int upgradeCost;
    private boolean coolDown=true;

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
            throw new BuildingInCoolDownException("Building is cooling down");}
        if (getLevel()==3){
            throw new MaxLevelException("Max Level has been reached");
        }
        setLevel(getLevel()+1);
        setCoolDown(true);   
    }
    
}