package units;

import java.util.ArrayList;

public class Army {
    
    Status currenStatus; //The current status of an army. Initially, an army is IDLE
    ArrayList<Unit> units;  //An ArrayList containing the units of the army
    int distancetoTarget;   //The distance needed to reach the target city.
    String target;          //The target city. Initially the target location is ""
    String currentLocation; //The current location of the army.
    final static int MAX_TO_HOLD = 10;          //The maximum number of units a unit can hold

    public Army(String currentLocation) {
        this.currentLocation = currentLocation;
        this.currenStatus = Status.IDLE;
        this.distancetoTarget = -1;
        this.target = "";
        this.units = new ArrayList<>();
    }
    
}
