package engine;
import java.util.ArrayList;
import java.io.IOException;

public class Game {

    Player player; //The current player of the game.
    ArrayList<City> availableCities; //An ArrayList containing the cities in the game.
    ArrayList<Distance> distances; //An ArrayList containing the distances between the cities.
    int currentTurnCount; //Current number of turns.
    final static int MAX_TURN_COUNT = 30; //Maximum number of the turns int the game;
    final static double INITIAL_TRES = 5000;
    public Game(String playerName,String playerCity) throws IOException {
        this.player = new Player(playerName);
        player.setTreasury(INITIAL_TRES);
        this.currentTurnCount = 1;
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

    //Setters
    public void setCurrentReturnCount(int count) {
        currentTurnCount = count;
    }
}
