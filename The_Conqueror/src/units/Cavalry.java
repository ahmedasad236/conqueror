package units;

public class Cavalry extends Unit{

    public Cavalry(int level, int maxSoldierConunt, double idleUpkeep, double marchingUpkeep, double siegeUpkeep)
    {
        super(level, maxSoldierConunt, idleUpkeep, marchingUpkeep, siegeUpkeep);
        setArcherFactor(0.5, 0.6, 0.7);
        setInfantryFactor(0.3, 0.4, 0.5);
        setCavalryFactor(0.2, 0.2, 0.3);
    }
    
}
