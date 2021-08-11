package buildings;

public class Stable extends MilitaryBuilding {
    final static int STABLE_COST = 1500;
    final static int STABLE_UPGRADE_COST = 800;
    final static int STABLE_RECRUITMENT_COST = 400;

    public Stable() {
        super(STABLE_COST, STABLE_UPGRADE_COST, STABLE_RECRUITMENT_COST);
    }
}
