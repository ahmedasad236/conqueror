package units;

import java.util.ArrayList;

public class Army {
    
    private Status currenStatus=Status.IDLE; //The current status of an army. Initially, an army is IDLE
    private ArrayList<Unit> units;  //An ArrayList containing the units of the army
    private int distancetoTarget=-1;   //The distance needed to reach the target city.
    private String target="";          //The target city. Initially the target location is ""
    private String currentLocation; //The current location of the army.
    private final static int maxToHold = 10;          //The maximum number of units a unit can hold

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
    
}
