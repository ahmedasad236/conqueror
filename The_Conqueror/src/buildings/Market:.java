package buildings;

public class Market extends EconomicBuilding {
    final static int MARKET_COST = 1500;
    final static int MARKET_UPGRADE = 700;

    public Market() {
        super(MARKET_COST, MARKET_UPGRADE);
    }

}
