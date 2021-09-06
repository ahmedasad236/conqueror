package buildings;
import exceptions.*;
import units.Unit;

public abstract class MilitaryBuilding extends Building {
    private int recruitmentCost; //The cost for recruiting a unit.
    private int currentRecruit; //Current number of units recruited by a building inside a turn.
    private static final int maxRecruit = 3; //Maximum number of units a building can recruit per turn.

    public void setRecruitmentCost(int RecCost){
        recruitmentCost=RecCost;
    }
    public int getRecruitmentCost(){
        return recruitmentCost;
    }
    public void setCurrentRecuruit(int CurRec){
        currentRecruit=CurRec;
    }
    public int getCurrentRecruit(){
        return currentRecruit;
    }
    public int getMaxRecruit(){
        return maxRecruit;}

    public MilitaryBuilding(int cost, int upgradeCost,int recruitmentCost) {
        super(cost, upgradeCost);
        this.recruitmentCost = recruitmentCost;
    }
    
    public abstract Unit recruirt()throws BuildingInCoolDownException, MaxRecruitedException;
    public abstract String getUnitType();    
}
