package engine;

import java.util.ArrayList;

import buildings.ArcheryRange;
import buildings.Barracks;
import buildings.Building;
import buildings.EconomicBuilding;
import buildings.Farm;
import buildings.Market;
import buildings.MilitaryBuilding;
import buildings.Stable;
import exceptions.NotEnoughGoldException;
import exceptions.BuildingInCoolDownException;
import exceptions.MaxRecruitedException;
import exceptions.MaxLevelException;
import units.Army;
import units.Unit;

public class Player {
    private String name; //The name of the player
    private ArrayList<City> controlledCities; //An ArrayList containing the player’s controlled cities.
    private ArrayList<Army> controlledArmies; //An ArrayList containing the player’s controlled Armies.
    private double treasury; //The amount of gold the player has.
    private double food=0.0; //The amount of food the player has.

    public Player(String name) {
        this.name = name;
        controlledCities = new ArrayList<>();
        controlledArmies = new ArrayList<>();
    }

    //Getters
    public String getName() {
        return name;
    }

    public ArrayList<City> getControlledCities() {
        return controlledCities;
    }

    public ArrayList<Army> getControlledArmy() {
        return controlledArmies;
    }

    public double getTreasury() {
        return treasury;
    }

    public double getFood() {
        return food;
    }
    
    // Setters
    public void setTreasury(double t) {
        treasury = t;
    } 

    public void setFood(double f) {
        food = f;
    }

    public void addToControlledCIties(City city) {
        controlledCities.add(city);
    }

    private City findCity(String cityName) {

        for(City city : controlledCities)
            if(city.getName().equals(cityName))
                return city;

        return null;
    }

    public void recruitUnit(String type,String cityName) throws
        BuildingInCoolDownException, MaxRecruitedException, NotEnoughGoldException {

        City city = findCity(cityName);
        MilitaryBuilding mBuilding = city.findMilitaryBuilding(type);
        int cost = mBuilding.getRecruitmentCost();
        if(cost > treasury)
            throw new NotEnoughGoldException("Not Enough  gold for recruit the unit");
        
        Unit u = mBuilding.recruirt();
        city.getDefendingArmy().addUnit(u);
        u.setParentArmy(city.getDefendingArmy());
        treasury -= cost;
    }

    private Building creatBuilding(String type, String buildingType) {

        if(type == "Farm"){
            buildingType = "E";
            return new Farm();
        }

        if(type == "Market") {
            buildingType = "E";
            return new Market();
        }

        buildingType = "M";
        if(type == "ArcheryRange")
            return new ArcheryRange();
        
        if(type == "Stable")
            return new Stable();

        return new Barracks();
    }

    public void build(String type,String cityName) throws NotEnoughGoldException {
        City city = findCity(cityName);
        String buildingType = "";
        Building building = creatBuilding(type, buildingType);
        int cost = building.getCost();
        if(cost > treasury)
            throw new NotEnoughGoldException("Not Enough  gold for recruit the unit");
        
        if(buildingType == "E")
            city.getEconomicBuildings().add((EconomicBuilding)building);
        
        else 
            city.getMilitaryBuildings().add((MilitaryBuilding)building);
        
        treasury -= cost;
        building.setCoolDown(true);
    }

    public void upgradeBuilding(Building b) throws NotEnoughGoldException,
        BuildingInCoolDownException, MaxLevelException {
        
        int cost = b.getUpgradeCost();
        if(cost > treasury)
            throw new NotEnoughGoldException("Not Enough  gold for recruit the unit");
        
        b.upgrade();
        treasury -= cost;
    }
}
