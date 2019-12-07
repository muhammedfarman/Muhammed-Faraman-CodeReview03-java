package Bikes;

import java.awt.*;

public class Bike {
    private int bikeID;
    private Color bikeColor;
    private State state;
    private static int counter = 0;


    public Bike(Color bikeColor) {
        counter++;
        this.bikeID = counter;
        this.bikeColor = bikeColor;
        this.state = State.CanBeRented;
    }

    public int getBikeID() {
        return bikeID;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean canRentBike(){
        if(this.state == State.CanBeRented){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return " \n------- \n -------\n" +
                "bikeID=" + bikeID +
                ", bikeColor=" + bikeColor +
                ", state=" + state +
                "\n------- \n -------\n";
    }
}
