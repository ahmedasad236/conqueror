package buildings;

import exceptions.*;
import units.Infantry;
import units.Unit;
import engine.Game;

public class Barracks extends MilitaryBuilding {
    private final static int BARRCK_COST = 2000;
    private final static int [] BARRACK_UPGRADE_COSTS = {1000, 1500};
    private final static int [] BARRACK_RECRUITMENT_COSTS = {500, 550, 600};
   
    
    public Barracks() {
            
        super(BARRCK_COST, BARRACK_UPGRADE_COSTS[0], BARRACK_RECRUITMENT_COSTS[0]);
        
    }

    @Override
    public void upgrade() throws BuildingInCoolDownException, MaxLevelException {

        super.upgrade();
        setUpgradeCost(BARRACK_UPGRADE_COSTS[getLevel()]);
        setRecruitmentCost(BARRACK_RECRUITMENT_COSTS[getLevel()]);

    }

    @Override
    public Unit recruirt() throws BuildingInCoolDownException, MaxRecruitedException{
        if(isCoolDown()){
            throw new BuildingInCoolDownException("Building is cooling down");
        }

        if (getCurrentRecruit() == getMaxRecruit()){
            throw new MaxRecruitedException("Max Recruitment has been reached");
        }
        Unit inf=new Infantry(this.getLevel(),(int)Game.UNIT_ATTRIBUTES[this.getLevel() + 5][0], Game.UNIT_ATTRIBUTES[this.getLevel() + 5][1], 
        Game.UNIT_ATTRIBUTES[this.getLevel() + 5][2], Game.UNIT_ATTRIBUTES[this.getLevel() + 5][3]);
        
        setCurrentRecuruit(getCurrentRecruit()+1);
        return inf;
    }
}
