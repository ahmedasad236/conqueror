package buildings;

public class Barracks extends MilitaryBuilding {
    private final static int BARRCK_COST = 2000;
    private final static int BARRACK_UPGRADE_COST = 1000;
    private final static int BARRACK_RECRUITMENT_COST = 500;
    
    public Barracks() {
            
        super(BARRCK_COST, BARRACK_UPGRADE_COST, BARRACK_RECRUITMENT_COST);
        
    }
}
