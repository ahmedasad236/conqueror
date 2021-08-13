package engine;

import java.util.ArrayList;

import buildings.EconomicBuilding;
import buildings.MilitaryBuilding;
import units.Army;

public class City {
    String name; //The name of the city
    ArrayList<EconomicBuilding> economicBuildings; 
    ArrayList<MilitaryBuilding> militaryBuildings;
    Army defendingArmy;
    int turnsUnderSiege;
    boolean underSiege;

    public City(String name) {
        this.name = name;
        this.defendingArmy = new Army(name);
        this.turnsUnderSiege = 0;
        this.underSiege = false;
        this.economicBuildings = new ArrayList<>();
        this.militaryBuildings = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public ArrayList<EconomicBuilding> gEconomicBuildings() {
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

}
