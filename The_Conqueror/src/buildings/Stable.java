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
        
        int lev = this.getLevel();
        
        if(this.isCoolDown())
            throw new BuildingInCoolDownException();
        

        switch(lev) {
            case 1:
                this.setLevel(2);
                this.setUpgradeCost(STABLE_UPGRADE_COSTS[1]);
                this.setCurrentRecuruit(STABLE_RECRUITMENT_COSTS[1]);
                break;
            
            case 2:
                this.setLevel(3);
                this.setCurrentRecuruit(STABLE_RECRUITMENT_COSTS[2]);
                break;
            
            default:
                throw new MaxLevelException();
        }
        
        //this.setCoolDown(false);

    }
}
