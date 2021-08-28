package engine;

import java.util.ArrayList;
import java.io.*;
import units.*;

public class Game {

    //{maxSoldiers, idlKeep, marchKeep, SiegeKeep}
    private static final double[][] UNIT_ATTRIBUTES = {
       {60, 0.4, 0.5, 0.6}, //Archer level 1
       {60, 0.4, 0.5, 0.6}, //Archer level 2
       {70, 0.5, 0.6, 0.7}, //Archer level 3
       {50, 0.5, 0.6, 0.7}, //Infantry level 1
       {50, 0.5, 0.6, 0.7}, //Infantry level 2
       {60, 0.7, 0.7, 0.8}, //Infantry level 3
       {40, 0.6, 0.7, 0.75},//Cavalry level 1
       {40, 0.6, 0.6, 0.75},//Cavalry level 2
       {60, 0.7, 0.8, 0.9},//Cavalry level 3
    };
    
    private Player player; //The current player of the game.
    private ArrayList<City> availableCities; //An ArrayList containing the cities in the game.
    private ArrayList<Distance> distances; //An ArrayList containing the distances between the cities.
    private int currentTurnCount=1; //Current number of turns.
    private final static int maxTurnCount = 30; //Maximum number of the turns int the game;

    public Game(String playerName,String playerCity) throws IOException {
        this.player = new Player(playerName);
        this.availableCities = new ArrayList<>();
        this.distances = new ArrayList<>();
        loadCitiesAndDistances();
        loadArmy(playerCity, "./CSVs/");
    }

    //Getters
    public Player getPlayer() {
        return player;
    }

    public ArrayList<City> getAvailableCities() {
        return availableCities;
    }

    public ArrayList<Distance> getDistances() {
        return distances;
    }

    public int getCurrentTurnCount() {
        return currentTurnCount;
    }
    public int getMaxTurnCount(){
        return maxTurnCount;
    }

    //Setters
    public void setCurrentReturnCount(int count) {
        currentTurnCount = count;
    }
    
    
    public void loadArmy(String cityName,String path) throws IOException {
        
        for(City city : availableCities) {
            
            // if it is not the selected City, 
            if(city.getName().compareTo(cityName) != 0) {
                String pathTemp = path + cityName + ".csv";
                ArrayList <String[]> rows = ReadingCSVFiles.readFile(pathTemp); // read the city File.
                ArrayList<Unit> units = createUnits(rows); // Create its unit.
                Army defArmy = new Army(cityName); // Create an army.
                defArmy.setUnits(units); // set Army's Units.
                city.setDefendingArmy(defArmy); // Initialize City's Defending Army.
            }

            else
                player.addToControlledCIties(city);
            
        }
    }

    //Utility functions
    private ArrayList<Unit> createUnits(ArrayList <String[]> rows) { 
        
        ArrayList<Unit> myUnits = new ArrayList<Unit>();

        for(String[] row : rows) 
            myUnits.add(createUnit(row));

        return myUnits;
    }
    
    private Unit createUnit(String[] row) {
        
        String unit = "";
        int level = 0;

        for(int i = 0; i < row.length; i++) {
            
            if(i == 0) {
                unit = row[i].toLowerCase();
            }

            else
                level = Integer.parseInt(row[i]); 
        }

        if(unit == "archer") {
            Archer archer = new Archer(level,  (int)UNIT_ATTRIBUTES[level - 1][0], UNIT_ATTRIBUTES[level - 1][1], 
            UNIT_ATTRIBUTES[level - 1][2], UNIT_ATTRIBUTES[level - 1][3]);

            return archer;
        }

        else if(unit == "cavalry") {
            
            Cavalry cav = new Cavalry(level, (int)UNIT_ATTRIBUTES[level + 2][0], UNIT_ATTRIBUTES[level + 2][1], 
            UNIT_ATTRIBUTES[level + 2][2], UNIT_ATTRIBUTES[level + 2][3]);

            return cav;
        }

        else {

            Infantry infantry = new Infantry(level, (int)UNIT_ATTRIBUTES[level + 5][0], UNIT_ATTRIBUTES[level + 5][1], 
            UNIT_ATTRIBUTES[level + 5][2], UNIT_ATTRIBUTES[level + 5][3]);

            return infantry;
        }

    }

    private void addToCities(City city) {
        if(!availableCities.contains(city))
            availableCities.add(city);
    }

    private void addToDistances(Distance dist) {

        if(!distances.contains(dist))
            distances.add(dist);
    }



    private void loadCitiesAndDistances() throws IOException {
        ArrayList<String[]> Csv= ReadingCSVFiles.readFile("./CSVs/distances.csv");
        for(String[]row :Csv) {
            String from = row[0];
            String to = row[1];
            int dist = Integer.parseInt(row[2]);
            Distance distance = new Distance(from, to, dist);
            addToDistances(distance);
            City FROM =  new City(from);
            City TO = new City(to);
            addToCities(FROM);
            addToCities(TO);
        }
    }
    
    

}