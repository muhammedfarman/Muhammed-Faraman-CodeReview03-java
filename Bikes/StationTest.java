package Bikes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

class StationTest {
    Station testStation = new Station("test-station", 3);
    Bike bike1 = new Bike(Color.yellow);
    Bike bike2 = new Bike(Color.blue);
    Bike bike3 = new Bike(Color.white);



    @Test
    @DisplayName("FUll CAPACITY CASE")
    void addBike(){
        testStation.addBike(bike1);
        testStation.addBike(bike2);
        testStation.addBike(bike3);
        boolean actual = testStation.addBike(new Bike(Color.orange));
        assertFalse(actual);
    }



    @Test
    @DisplayName("Renting")
    void renting() {
        testStation.addBike(bike1);
        boolean actual = testStation.removeBike(bike1, State.Discarded);
        assertTrue(actual);
    }

    @Test
    @DisplayName("Returning the bike and removing it from service")
    void Return(){
        testStation.addBike(bike2);
        boolean actual = testStation.removeBike(bike3, State.InService);
        assertFalse(actual);
    }

    @Test
    @DisplayName("Check if the bikes are still there")
    void removeBike_Scenario3(){
        testStation.addBike(bike2);
        testStation.removeBike(bike2, State.InService);
        boolean actual = testStation.getBikesL().contains(bike2);
        assertFalse(actual);
    }
}