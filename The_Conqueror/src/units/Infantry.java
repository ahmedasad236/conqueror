package units;

public class Infantry extends Unit {
    
    public Infantry(int level, int maxSoldierConunt, double idleUpkeep, double marchingUpkeep, double siegeUpkeep)
    {
        super(level, maxSoldierConunt, idleUpkeep, marchingUpkeep, siegeUpkeep);
        setArcherFactor(0.3, 0.4, 0.5);
        setInfantryFactor(0.1, 0.2, 0.3);
        setCavalryFactor(0.1, 0.2, 0.25);
    }

    @Override
    public String getType() {
        return "Infantry";
    }
}
