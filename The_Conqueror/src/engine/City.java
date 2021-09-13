package engine;

import java.util.ArrayList;
import buildings.EconomicBuilding;
import buildings.MilitaryBuilding;
import units.Army;

public class City {
    private String name;
    private ArrayList<EconomicBuilding> economicBuildings;
    private ArrayList<MilitaryBuilding> militaryBuildings;
    private Army defendingArmy;
    private int turnsUnderSiege = 0;
    private boolean underSiege = false;

    public City(String name) {
        this.name = name;
        this.defendingArmy = new Army(name);
        this.economicBuildings = new ArrayList<>();
        this.militaryBuildings = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public ArrayList<EconomicBuilding> getEconomicBuildings() {
        return economicBuildings;
    }

    public ArrayList<MilitaryBuilding> getMilitaryBuildings() {
        return militaryBuildings;
    }

    public Army getDefendingArmy() {
        return defendingArmy;
    }

    public int getTurnsUnderSiege() {
        return turnsUnderSiege;
    }

    public boolean isUnderSiege() {
        return underSiege;
    }

    // Setters
    public void setDefendingArmy(Army army) {
        defendingArmy = army;
    }

    public void setTurnsUnderSiege(int turns) {
        turnsUnderSiege = turns;
    }

    public void setUnderSiege(boolean s) {
        underSiege = s;
    }

    public MilitaryBuilding findMilitaryBuilding(String type) {

        for (MilitaryBuilding building : militaryBuildings)
            if (type.equals(building.getUnitType()))
                return building;

        return null;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this)
            return true;

        if (!(o instanceof City)) {

            return false;
        }

        City city = (City) o;

        return city.getName().compareTo(this.getName()) == 0;
    }

}
