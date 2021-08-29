package buildings;


public class Farm extends EconomicBuilding {
    
    private final static int FARM_COST = 1000;
    private final static int FARM_UPGRADE = 500;
    private final static int[] FARM_HARVEST={500,700,1000};

    public Farm() {
        super(FARM_COST, FARM_UPGRADE);
    }

    @Override
    public int harvest() {        
        return FARM_HARVEST[getLevel()-1];
    }
    
}