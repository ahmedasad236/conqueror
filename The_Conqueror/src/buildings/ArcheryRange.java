package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;

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
    
}
