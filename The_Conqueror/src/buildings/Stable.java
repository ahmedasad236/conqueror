package buildings;
import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;

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
}
