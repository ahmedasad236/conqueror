package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;

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
}
