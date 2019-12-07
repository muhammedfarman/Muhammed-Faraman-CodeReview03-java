package Bikes;

import java.util.ArrayList;
import java.util.Iterator;

public class User {
    private int userID;
    private String firstName;
    private String surname;
    private Bike currentlyRentedBike = null;
    private ArrayList<Rental> rentals = new ArrayList<>();
    private static int counter = 1;

    public User(String firstName, String surname){
        this.userID = counter;
        this.firstName = firstName;
        this.surname = surname;
        counter++;
    }

    public void setCurrentlyRentedBike(Bike currentlyRentedBike) {
        this.currentlyRentedBike = currentlyRentedBike;
    }

    public ArrayList<Rental> getRentals() {
        return rentals;
    }

    public void addRental(int bikeID, int stationID){
        rentals.add(new Rental(bikeID, stationID));
    }

    public void returnBike(int bikeID, int stationID){
        Iterator<Rental> iterate = rentals.iterator();
        for(Rental rental : rentals){
            if(rental.getBikeID() == bikeID && rental.isAv()){
                rental.closeRental(stationID);
                currentlyRentedBike = null;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return " ------- \nUser \n -------\n" +
                "userID=" + userID +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", currentlyRentedBike=" + currentlyRentedBike +
                ", rentals=" + rentals +
                "\n------- \n -------\n";
    }
}



