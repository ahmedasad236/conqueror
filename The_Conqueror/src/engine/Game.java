package engine;

import java.util.ArrayList;
import java.io.*;
import units.*;

public class Game {

    // [maxSoldiers, idlKeep, marchKeep, SiegeKeep]
    public static final double[][] UNIT_ATTRIBUTES = { { 60, 0.4, 0.5, 0.6 }, // Archer level 1
            { 60, 0.4, 0.5, 0.6 }, // Archer level 2
            { 70, 0.5, 0.6, 0.7 }, // Archer level 3
            { 50, 0.5, 0.6, 0.7 }, // Infantry level 1
            { 50, 0.5, 0.6, 0.7 }, // Infantry level 2
            { 60, 0.7, 0.7, 0.8 }, // Infantry level 3
            { 40, 0.6, 0.7, 0.75 }, // Cavalry level 1
            { 40, 0.6, 0.6, 0.75 }, // Cavalry level 2
            { 60, 0.7, 0.8, 0.9 },// Cavalry level 3
    };

    private Player player;
    private ArrayList<City> availableCities;
    private ArrayList<Distance> distances;
    private int currentTurnCount = 1;
    private final static int maxTurnCount = 30;

    public Game(String playerName, String playerCity) throws IOException {
        this.player = new Player(playerName);
        this.availableCities = new ArrayList<>();
        this.distances = new ArrayList<>();
        loadCitiesAndDistances();
        loadArmy(playerCity, "./CSVs/");
    }

    // Getters
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

    public int getMaxTurnCount() {
        return maxTurnCount;
    }

    // Setters
    public void setCurrentReturnCount(int count) {
        currentTurnCount = count;
    }

    public void loadArmy(String cityName, String path) throws IOException {

        for (City city : availableCities) {

            // if it is not the selected City,
            if (city.getName().compareTo(cityName) != 0) {

                String pathTemp = path + cityName + ".csv";
                ArrayList<String[]> rows = ReadingCSVFiles.readFile(pathTemp);
                ArrayList<Unit> units = createUnits(rows);
                Army defArmy = new Army(cityName);
                defArmy.setUnits(units);
                initializeParentArmy(defArmy, units);
                city.setDefendingArmy(defArmy);
            }

            else
                player.addToControlledCIties(city);

        }
    }

    // Utility functions
    private ArrayList<Unit> createUnits(ArrayList<String[]> rows) {

        ArrayList<Unit> myUnits = new ArrayList<Unit>();

        for (String[] row : rows)
            myUnits.add(createUnit(row));

        return myUnits;
    }

    private int unitData(String[] row, String unit) {

        unit = "";

        int level = 0;

        for (int i = 0; i < row.length; i++) {

            if (i == 0) {
                unit = row[i].toLowerCase();
            }

            else
                level = Integer.parseInt(row[i]);
        }

        return level;
    }

    private Unit createUnit(String[] row) {

        String unit = "";

        int level = unitData(row, unit);

        char c = unit.charAt(0);

        Unit unitObject = null;

        switch (c) {
            case 'a':
                unitObject = new Archer(level, (int) UNIT_ATTRIBUTES[level - 1][0], UNIT_ATTRIBUTES[level - 1][1],
                        UNIT_ATTRIBUTES[level - 1][2], UNIT_ATTRIBUTES[level - 1][3]);
                break;

            case 'c':
                unitObject = new Cavalry(level, (int) UNIT_ATTRIBUTES[level + 2][0], UNIT_ATTRIBUTES[level + 2][1],
                        UNIT_ATTRIBUTES[level + 2][2], UNIT_ATTRIBUTES[level + 2][3]);
                break;

            case 'i':
                unitObject = new Infantry(level, (int) UNIT_ATTRIBUTES[level + 5][0], UNIT_ATTRIBUTES[level + 5][1],
                        UNIT_ATTRIBUTES[level + 5][2], UNIT_ATTRIBUTES[level + 5][3]);
                break;
        }

        return unitObject;

    }

    private void addToCities(City city) {
        if (!availableCities.contains(city))
            availableCities.add(city);
    }

    private void addToDistances(Distance dist) {

        if (!distances.contains(dist))
            distances.add(dist);
    }

    private void initializeParentArmy(Army army, ArrayList<Unit> units) {
        for (Unit unit : units)
            unit.setParentArmy(army);
    }

    private void loadCitiesAndDistances() throws IOException {
        ArrayList<String[]> Csv = ReadingCSVFiles.readFile("./CSVs/distances.csv");

        for (String[] row : Csv) {
            String from = row[0];
            String to = row[1];
            int dist = Integer.parseInt(row[2]);
            Distance distance = new Distance(from, to, dist);
            addToDistances(distance);
            City FROM = new City(from);
            City TO = new City(to);
            addToCities(FROM);
            addToCities(TO);
        }
    }

    int findDistance(String from, String to) {

        for (Distance dist : distances) {
            if ((dist.getFromCity().equals(from) && dist.getToCity().equals(to))
                    || (dist.getFromCity().equals(to) && dist.getToCity().equals(from)))
                return dist.getDistance();
        }

        return 0;
    }

    public void targetCity(Army army, String targetName) {

        if (army.getCurrenStatus() == Status.MARCHING)
            return;

        int dist = findDistance(army.getCurrentLocation(), targetName);
        army.setDistancetoTarget(dist);
        army.setTarget(targetName);
        army.setCurrenStatus(Status.MARCHING);
    }

}