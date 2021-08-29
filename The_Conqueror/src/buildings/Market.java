package buildings;
import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;

public class Market extends EconomicBuilding {
    private final static int MARKET_COST = 1500;
    private final static int []MARKET_UPGRADE_COSTS = {700, 1000};

    public Market() {
        super(MARKET_COST, MARKET_UPGRADE_COSTS[0]);
    }

    @Override
    public void upgrade() throws BuildingInCoolDownException, MaxLevelException {
            
        int lev = this.getLevel();
        
        switch(lev) {
            case 1:
                this.setLevel(2);
                this.setUpgradeCost(MARKET_UPGRADE_COSTS[1]);
                break;
            
            case 2:
                this.setLevel(3);
                break;
            
            default:
                throw new MaxLevelException();
        }
        
    }

}
