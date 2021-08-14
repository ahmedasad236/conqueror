package buildings;


public class Farm extends EconomicBuilding {
    
    private final static int FARM_COST = 1000;
    private final static int FARM_UPGRADE = 500;

    public Farm() {
        super(FARM_COST, FARM_UPGRADE);
    }
}