package buildings;

public class Market extends EconomicBuilding {
    private final static int MARKET_COST = 1500;
    private final static int MARKET_UPGRADE = 700;

    public Market() {
        super(MARKET_COST, MARKET_UPGRADE);
    }

}
