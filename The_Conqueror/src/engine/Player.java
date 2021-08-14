package engine;

import java.util.ArrayList;
import units.Army;

public class Player {
    String name; //The name of the player
    ArrayList<City> controlledCities; //An ArrayList containing the player’s controlled cities.
    ArrayList<Army> controlledArmies; //An ArrayList containing the player’s controlled Armies.
    double treasury; //The amount of gold the player has.
    double food; //The amount of food the player has.

    public Player(String name) {
        this.name = name;
        food = 0.0;
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

}