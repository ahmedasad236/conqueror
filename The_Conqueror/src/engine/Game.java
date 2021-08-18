package engine;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.*;
import engine.ReadingCSVFile;

public class Game {

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
    
    /*
    public void loadArmy(String cityName,String path) throws IOException {

    }*/

    //Utility functions
    private void addToCities(City city) {
        if(!availableCities.contains(city))
            availableCities.add(city);
    }

    private void addToDistances(Distance dist) {

        if(!distances.contains(dist))
            distances.add(dist);
    }

    private void loadCitiesAndDistances() throws IOException {
        ArrayList<String[]> Csv= ReadingCSVFile.readFile("./CSVs/distances.csv");
        for(String[]row :Csv) {
            from = row[0];
            to = row[1];
            dist = Integer.parseInt(row[2]);
            Distance distance = new Distance(from, to, dist);
            addToDistances(distance);
            City FROM =  new City(from);
            City TO = new City(to);
            addToCities(FROM);
            addToCities(TO);
        }
    }   
}