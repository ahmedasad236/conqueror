package buildings;

public abstract class Building {
    int cost;
    int level;
    int upgradeCost;
    boolean coolDown;

    public Building(int cost,int upgradeCost) {
        this.coolDown = true;
        this.cost = cost;
        this.upgradeCost = upgradeCost;
        this.level = 1;
    }
    
}