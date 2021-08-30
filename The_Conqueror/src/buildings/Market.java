package buildings;
import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;

public class Market extends EconomicBuilding {
    private final static int MARKET_COST = 1500;
    private final static int []MARKET_UPGRADE_COSTS = {700, 1000};
    private final static int[] MARKET_HARVEST={1000,1500,2000};

    public Market() {
        super(MARKET_COST, MARKET_UPGRADE_COSTS[0]);
    }

    @Override
    public int harvest() {
        return MARKET_HARVEST[getLevel()-1];
    }

    @Override
    public void upgrade() throws BuildingInCoolDownException, MaxLevelException {

        super.upgrade();
        setUpgradeCost(MARKET_UPGRADE_COSTS[getLevel()]);
        }
    
    }