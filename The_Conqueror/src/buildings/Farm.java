package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;

public class Farm extends EconomicBuilding {
    
    private final static int FARM_COST = 1000;
    private final static int []FARM_UPGRADE_COSTS = {500, 700};
    private final static int[] FARM_HARVEST={500,700,1000};

    public Farm() {
        super(FARM_COST, FARM_UPGRADE_COSTS[0]);
    }


    @Override
    public int harvest() {        
        return FARM_HARVEST[getLevel()-1];
    }
    
    @Override
    public void upgrade() throws BuildingInCoolDownException, MaxLevelException {
        super.upgrade();
        setUpgradeCost(FARM_UPGRADE_COSTS[getLevel()]); 
    }


}