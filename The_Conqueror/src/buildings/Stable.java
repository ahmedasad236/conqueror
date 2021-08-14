package buildings;

public class Stable extends MilitaryBuilding {
    private final static int STABLE_COST = 2500;
    private final static int STABLE_UPGRADE_COST = 1500;
    private final static int STABLE_RECRUITMENT_COST = 600;

    public Stable() {
        super(STABLE_COST, STABLE_UPGRADE_COST, STABLE_RECRUITMENT_COST);
    }
}
