package buildings;

public abstract class MilitaryBuilding extends Building {
    int recruitmentCost; //The cost for recruiting a unit.
    int currentRecruit; //Current number of units recruited by a building inside a turn.
    static final int MAX_RECRUIT = 3; //Maximum number of units a building can recruit per turn.

    public MilitaryBuilding(int cost, int upgradeCost,int recruitmentCost) {
        super(cost, upgradeCost);
        this.recruitmentCost = recruitmentCost;
    }
    
}
