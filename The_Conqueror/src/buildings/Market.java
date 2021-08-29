package buildings;

public class Market extends EconomicBuilding {
    private final static int MARKET_COST = 1500;
    private final static int MARKET_UPGRADE = 700;
    private final static int[] MARKET_HARVEST={1000,1500,2000};

    public Market() {
        super(MARKET_COST, MARKET_UPGRADE);
    }

    @Override
    public int harvest() {
        return MARKET_HARVEST[getLevel()-1];
    }

}
