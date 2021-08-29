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
        
        int lev = this.getLevel();
        
        if(this.isCoolDown())
            throw new BuildingInCoolDownException();
        

        switch(lev) {
            case 1:
                this.setLevel(2);
                this.setUpgradeCost(ARCH_UPGRADE_COSTS[1]);
                this.setCurrentRecuruit(ARCH_RECRUITMENT_COSTS[1]);
                break;
            
            case 2:
                this.setLevel(3);
                this.setCurrentRecuruit(ARCH_RECRUITMENT_COSTS[2]);
                break;
            
            default:
                throw new MaxLevelException();
        }
        
        //this.setCoolDown(false);

    }
}
