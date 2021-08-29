package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;

public class Farm extends EconomicBuilding {
    
    private final static int FARM_COST = 1000;
    private final static int []FARM_UPGRADE_COSTS = {500, 700};
    
    public Farm() {
        super(FARM_COST, FARM_UPGRADE_COSTS[0]);
    }


    @Override
    public void upgrade() throws BuildingInCoolDownException, MaxLevelException {
            
        int lev = this.getLevel();
        
        switch(lev) {
            case 1:
                this.setLevel(2);
                this.setUpgradeCost(FARM_UPGRADE_COSTS[1]);
                break;
            
            case 2:
                this.setLevel(3);
                break;
            
            default:
                throw new MaxLevelException();
        }
        
    }

}