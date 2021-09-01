package units;

import java.util.ArrayList;

import exceptions.MaxCapacityException;

public class Army {
    
    private Status currenStatus=Status.IDLE; 
    private ArrayList<Unit> units;  
    private int distancetoTarget=-1;   
    private String target="";          
    private String currentLocation; 
    private final static int maxToHold = 10;          

    public void setCurrenStatus(Status x){
        this.currenStatus=x;
    }
    public Status getCurrenStatus(){
        return currenStatus;
    }
    public void setUnits( ArrayList<Unit> units){
        this.units=units;
    }
    public ArrayList<Unit> getUnits(){
        return units;
    }
    public void setDistancetoTarget( int distance){
        this.distancetoTarget=distance;
    }
    public int getDistancetoTarget(){
        return distancetoTarget;
    }
    public void setTarget(String tar){
        this.target=tar;
    }
    public String getTarget(){
        return target;
    }
    public void setCurrentLocation(String current){
        this.currentLocation=current;
    }
    public String getCurrentLocation(){
        return currentLocation;
    }
    public int getMaxToHold(){
        return maxToHold;
    }
    public Army(String currentLocation) {
        setCurrentLocation(currentLocation);
        this.units = new ArrayList<>();
    }

    private void removeUnit(Unit unit) {
        units.remove(unit);
    }

    private void addUnit(Unit unit) {
        units.add(unit);
    }

    public void relocateUnit(Unit unit) throws MaxCapacityException {
        if(this.units.size() == maxToHold) 
            throw new MaxCapacityException("The units of the army are full");
        
        removeUnit(unit);
        addUnit(unit);
    }

    public void handleAttackedUnit(Unit u) {
        if(u.getCurrentSoldierCount() <= 0)
            removeUnit(u);
    }
    

    public double foodNeeded() {
        double food = 0.0;
        for(Unit unit : units)
            food += unit.getFoodNeeded();

        return food;
    }
}
