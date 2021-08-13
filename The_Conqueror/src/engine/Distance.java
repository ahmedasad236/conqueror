package engine;

public class Distance {
    
    String from; //The name of the city that the army will begin moving from
    String to;  //The name of the city that the army will move to
    int distance;   // the distance between the two cities

    public Distance(String from,String to, int distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    public String getFromCity() {
        return from;
    }

    public String getToCity() {
        return to;
    }

    public int getDistance() {
        return distance;
    }

}
