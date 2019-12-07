package Bikes;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Bike> bikes = createBikes();
        HashMap<Integer, Station> stations = createStations();
        ArrayList<User> users = createUsers();
        RBikes(bikes, stations);
        User(bikes, stations, users.get(0));
        demoUpperLimit(bikes, stations, users.get(1));
        ArrayList<Rental> rentals1 = users.get(0).getRentals();
        Rental(bikes, stations, users.get(0));
        for(Rental rental : rentals1){
            System.out.println(rental);
        }
        ArrayList<Rental> rentals2 = users.get(1).getRentals();
        for(Rental rental : rentals2){
            System.out.println(rental);
        }
    }

    private static HashMap<Integer, Bike> createBikes(){
        Bike bike1 = new Bike(Color.black);
        Bike bike2 = new Bike(Color.red);
        Bike bike3 = new Bike(Color.green);
        Bike bike4 = new Bike(Color.white);
        Bike bike5 = new Bike(Color.blue);
        Bike bike6 = new Bike(Color.yellow);
        Bike bike7 = new Bike(Color.gray);
        Bike bike8 = new Bike(Color.orange);

        HashMap<Integer, Bike> bikes = new HashMap<>();
        bikes.put(bike1.getBikeID(), bike1);
        bikes.put(bike2.getBikeID(), bike2);
        bikes.put(bike3.getBikeID(), bike3);
        bikes.put(bike4.getBikeID(), bike4);
        bikes.put(bike5.getBikeID(), bike5);
        bikes.put(bike6.getBikeID(), bike6);
        bikes.put(bike7.getBikeID(), bike7);
        bikes.put(bike8.getBikeID(), bike8);
        return bikes;
    }

    private static HashMap<Integer, Station> createStations(){
        Station station1 = new Station("Hauptbahnhof", 10);
        Station station2 = new Station("Karlsplatz", 5);
        Station station3 = new Station ("Schwedenplatz", 8);

        HashMap<Integer, Station> stations = new HashMap<>();
        stations.put(station1.getStationID(), station1);
        stations.put(station2.getStationID(), station2);
        stations.put(station3.getStationID(), station3);
        return stations;
    }

    private static void RBikes(HashMap<Integer, Bike> bikes, HashMap<Integer, Station> stations){
        for(int i = 1; i < 4; i++){
            if(bikes.get(i).getState()==State.CanBeRented){
                stations.get(1).addBike(bikes.get(i));
            }
        }
        for(int i = 4; i < 8; i++){
            if(bikes.get(i).getState()==State.CanBeRented){
                stations.get(2).addBike(bikes.get(i));
            }
        }
    }

    private static ArrayList<User> createUsers(){
        User user1 = new User ("sam", "lee");
        User user2 = new User ("robert", "mad");
        User user3 = new User ("no ", "way");
        User user4 = new User ("lucifer", "the first");

        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        return users;
    }

    private static void User(HashMap<Integer, Bike> bikes, HashMap<Integer, Station> stations, User user){
        System.out.println("Bikes available in the stations :  \n station 1 : ");
        BStation(stations, 1);
        System.out.println(" \n station 2 : ");
        BStation(stations, 2);
        System.out.println();
        if(bikes.get(1).canRentBike()){
            System.out.println("Renting bike "+bikes.get(1).getBikeID());
            if(stations.get(1).removeBike(bikes.get(1), State.CanNotBeRented)){
                user.setCurrentlyRentedBike(bikes.get(1));
                user.addRental(bikes.get(1).getBikeID(), stations.get(1).getStationID());

                System.out.println("======================================================");
                System.out.println("Bikes in station 1 after rent: \n ************************************** \n");
                BStation(stations, 1);
                System.out.println("======================================================");
                System.out.println("Bikes  in station 2 after rent:\n ************************************** \n ");
                BStation(stations, 2);
                System.out.println("======================================================");
                if(stations.get(2).addBike(bikes.get(1))){
                    user.returnBike(bikes.get(1).getBikeID(), stations.get(2).getStationID());
                    System.out.println("Bike returned successfully !!! \n ************************************** \n");
                    System.out.println("Bikes in station 2 after Return: ");
                    BStation(stations, 2);
                    System.out.println();
                }
            }
        }
    }

    private static void BStation(HashMap<Integer, Station> stations, int id){
        ArrayList<Bike> bikes = stations.get(id).getBikesL();
        for(Bike bike : bikes){
            System.out.print(bike.getBikeID()+"\t");
        }
        System.out.println();
    }

    private static void demoUpperLimit(HashMap<Integer, Bike> bikes, HashMap<Integer, Station> stations, User user){
        if(bikes.get(2).canRentBike()){
            System.out.println("Renting "+bikes.get(2).getBikeID());
            if(stations.get(1).removeBike(bikes.get(2), State.CanNotBeRented)){
                user.setCurrentlyRentedBike(bikes.get(2));
                user.addRental(bikes.get(2).getBikeID(), stations.get(1).getStationID());

                System.out.println("Bikes available in station : ");
                BStation(stations, 2);
                System.out.println("================================");
                System.out.println("RETURN PROCESS");
                System.out.println("==\n====\n===\n=====\n==================");
                if(stations.get(2).addBike(bikes.get(2))){
                    user.returnBike(bikes.get(2).getBikeID(), stations.get(2).getStationID());
                    System.out.println("Bike returned successfully");
                    System.out.println("Bikes available in station 2 after return: ");
                    BStation(stations, 2);
                    System.out.println();
                }
            }
        }
    }

    private static void Rental(HashMap<Integer, Bike> bikes, HashMap<Integer, Station> stations, User user){
        if(bikes.get(5).canRentBike()){
            System.out.println("Renting"+bikes.get(5).getBikeID());
            if(stations.get(2).removeBike(bikes.get(5), State.CanNotBeRented)){
                user.setCurrentlyRentedBike(bikes.get(5));
                user.addRental(bikes.get(5).getBikeID(), stations.get(2).getStationID());


            }
            ArrayList<Rental> rentals1 = user.getRentals();
            for(Rental rental : rentals1){
                System.out.println(rental);
            }
        }
    }
}