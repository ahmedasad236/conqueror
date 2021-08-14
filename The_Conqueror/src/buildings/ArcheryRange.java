package buildings;

public class ArcheryRange extends MilitaryBuilding {
    private final static int ARCH_COST = 1500;
    private final static int ARCH_UPGRADE_COST = 800;
    private final static int ARCH_RECRUITMENT_COST = 400;

    public ArcheryRange() {
        super(ARCH_COST, ARCH_UPGRADE_COST, ARCH_RECRUITMENT_COST);
    }
}
