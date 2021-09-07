package buildings;
import exceptions.*;
import units.Unit;
import units.Cavalry;
import engine.Game;


public class Stable extends MilitaryBuilding {

    private final static int STABLE_COST = 2500;
    private final static int []STABLE_UPGRADE_COSTS = {1500, 2000};
    private final static int []STABLE_RECRUITMENT_COSTS = {600, 650, 700};

    public Stable() {
        super(STABLE_COST, STABLE_UPGRADE_COSTS[0], STABLE_RECRUITMENT_COSTS[0]);
    }

    @Override
    public void upgrade() throws BuildingInCoolDownException, MaxLevelException {

        super.upgrade();
        setUpgradeCost(STABLE_UPGRADE_COSTS[getLevel()]);
        setRecruitmentCost(STABLE_RECRUITMENT_COSTS[getLevel()]);

    }

    @Override
    public Unit recruirt() throws BuildingInCoolDownException, MaxRecruitedException {
        if(isCoolDown()){
            throw new BuildingInCoolDownException("Building is cooling down");
        }
        
        if (getCurrentRecruit() == getMaxRecruit()){
               throw new MaxRecruitedException("Max Recruitment has been reached");
        }
        
        Unit cav =new Cavalry(this.getLevel(),(int)Game.UNIT_ATTRIBUTES[this.getLevel() +2][0], Game.UNIT_ATTRIBUTES[this.getLevel() +2][1], 
        Game.UNIT_ATTRIBUTES[this.getLevel() +2][2], Game.UNIT_ATTRIBUTES[this.getLevel() +2][3]);
        
        setCurrentRecuruit(getCurrentRecruit()+1);
        return cav;
    }

    @Override
    public String getUnitType() {
        return "Cavalry";
    }
}
