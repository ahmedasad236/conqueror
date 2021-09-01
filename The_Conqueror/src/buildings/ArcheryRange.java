package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.*;
import units.Archer;
import units.Unit;
import engine.Game;

public class ArcheryRange extends MilitaryBuilding {
    private final static int ARCH_COST = 1500;
    private final static int []ARCH_UPGRADE_COSTS = {800, 700};
    private final static int []ARCH_RECRUITMENT_COSTS = {400, 450, 500};
    

    public ArcheryRange() {
        super(ARCH_COST, ARCH_UPGRADE_COSTS[0], ARCH_RECRUITMENT_COSTS[0]);
    }

    @Override
    public void upgrade() throws BuildingInCoolDownException, MaxLevelException {

        super.upgrade();
        setUpgradeCost(ARCH_UPGRADE_COSTS[getLevel()]);
        setRecruitmentCost(ARCH_RECRUITMENT_COSTS[getLevel()]);

    }

    @Override
    public Unit recruirt() throws BuildingInCoolDownException, MaxRecruitedException{
        if(isCoolDown()){
            throw new BuildingInCoolDownException("Building is cooling down");
        }

        if (getCurrentRecruit()== getMaxRecruit()){
            throw new MaxRecruitedException("Max Recruitment has been reached");
        }
        Unit arch =new Archer(this.getLevel(),(int)Game.UNIT_ATTRIBUTES[this.getLevel() -1][0], Game.UNIT_ATTRIBUTES[this.getLevel() -1][1], 
        Game.UNIT_ATTRIBUTES[this.getLevel() -1][2], Game.UNIT_ATTRIBUTES[this.getLevel() -1][3]);
        
        setCurrentRecuruit(getCurrentRecruit()+1);

        return arch;
    }
    
}
