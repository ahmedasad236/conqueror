package buildings;


public class Farm extends EconomicBuilding {
    
    final static int FARM_COST = 1000;
    final static int FARM_UPGRADE = 500;

    public Farm() {
        super(FARM_COST, FARM_UPGRADE);
    }
}