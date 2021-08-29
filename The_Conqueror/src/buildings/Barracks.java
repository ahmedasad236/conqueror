package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;

public class Barracks extends MilitaryBuilding {
    private final static int BARRCK_COST = 2000;
    private final static int [] BARRACK_UPGRADE_COSTS = {1000, 1500};
    private final static int [] BARRACK_RECRUITMENT_COSTS = {500, 550, 600};
   
    
    public Barracks() {
            
        super(BARRCK_COST, BARRACK_UPGRADE_COSTS[0], BARRACK_RECRUITMENT_COSTS[0]);
        
    }

    @Override
    public void upgrade() throws BuildingInCoolDownException, MaxLevelException {
        
        int lev = this.getLevel();
        
        if(this.isCoolDown())
            throw new BuildingInCoolDownException();
        

        switch(lev) {
            case 1:
                this.setLevel(2);
                this.setUpgradeCost(BARRACK_UPGRADE_COSTS[1]);
                this.setCurrentRecuruit(BARRACK_RECRUITMENT_COSTS[1]);
                break;
            
            case 2:
                this.setLevel(3);
                this.setCurrentRecuruit(BARRACK_RECRUITMENT_COSTS[2]);
                break;
            
            default:
                throw new MaxLevelException();
        }
        
        //this.setCoolDown(false);
    }
}
