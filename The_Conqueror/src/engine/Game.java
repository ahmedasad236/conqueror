package engine;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.*;

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

        String filePath = "/home/a_asaad22/Ahmed/Courses/Java/projects/the_conqueror/conqueror/The_Conqueror/src/engine/distances.csv";
        BufferedReader reader = null;
        String line = "";

        reader = new BufferedReader(new FileReader(filePath));
        
        while((line = reader.readLine()) != null) {
            String[] row = line.split(",");
            String to = "", from = "";
            int dist = 0;
            for(int i = 0; i < row.length; i++) {
                if(i == 0)
                    from = row[i];
                
                else if (i == 1)
                    to = row[i];
                
                else 
                    dist = Integer.parseInt(row[i]);
            }

            Distance distance = new Distance(from, to, dist);
            addToDistances(distance);
            City FROM =  new City(from);
            City TO = new City(to);
            addToCities(FROM);
            addToCities(TO);
        }

        reader.close();
    }   
}
