package engine;
import java.util.ArrayList;
import java.io.IOException;

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
}
