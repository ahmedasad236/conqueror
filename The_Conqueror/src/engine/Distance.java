package engine;

public class Distance {

    private String from; // The name of the city that the army will begin moving from
    private String to; // The name of the city that the army will move to
    private int distance; // the distance between the two cities

    public Distance(String from, String to, int distance) {
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

    @Override
    public boolean equals(Object obj) {

        if (obj == this)
            return true;

        if (!(obj instanceof City)) {

            return false;
        }

        Distance dist = (Distance) obj;
        return dist.getFromCity().compareTo(this.getFromCity()) == 0
                && dist.getToCity().compareTo(this.getToCity()) == 0 && this.distance == dist.distance;
    }

}
