package Bikes;

import java.util.ArrayList;

public class Station {
    private int stationID;
    private String location;
    private int capacity;
    private ArrayList<Bike> bikesL = new ArrayList<>();
    private static int scounter = 0;

    public Station(String location, int capacity) {
        this.stationID = scounter;
        this.location = location;
        this.capacity = capacity;
        scounter++;
    }

    public ArrayList<Bike> getBikesL() {
        return bikesL;
    }

    public int getStationID() {
        return stationID;
    }

    public boolean addBike(Bike bike) {
        if(bikesL.size() < capacity) {
            bikesL.add(bike);
            bike.setState(State.CanBeRented);
            return true;
        }
        System.out.println("the station is full ");
        return false;
    }

    public boolean removeBike(Bike bike, State state) {
        if(bikesL.contains(bike)){
            bikesL.remove(bike);
            bike.setState(state);
            return true;
        }
        System.out.println("bike not available ");
        return false;
    }

    @Override
    public String toString() {
        return "--------- \n Station \n--------\n" +
                "stationID=" + stationID +
                ", location='" + location + '\'' +
                ", maxCapacity=" + capacity +
                ", bikesAvailable=" + bikesL +
                "\n-----------------\n";
    }
}
