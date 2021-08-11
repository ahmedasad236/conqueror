package buildings;

public class Barracks extends MilitaryBuilding {
    final static int BARRCK_COST = 1500;
    final static int BARRACK_UPGRADE_COST = 800;
    final static int BARRACK_RECRUITMENT_COST = 400;
    
    public Barracks() {
            
        super(BARRCK_COST, BARRACK_UPGRADE_COST, BARRACK_RECRUITMENT_COST);
        
    }
}
