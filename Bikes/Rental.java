package Bikes;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

public class Rental {
    private int bikeID;
    private int stationStart;
    private int stationEnd;
    private LocalDateTime Start;
    private LocalDateTime time;
    private LocalDateTime End;
    private boolean Av;

    public Rental(int bikeID, int stationStart){
        this.bikeID = bikeID;
        this.stationStart = stationStart;
        this.Start = now();
        this.time = Start.plusHours(24);
        this.Av = true;
    }

    public int getBikeID() {
        return bikeID;
    }

    public int getStationStart() {
        return stationStart;
    }

    public int getStationEnd() {
        return stationEnd;
    }

    public LocalDateTime getRentStart() {
        return Start;
    }

    public LocalDateTime getRentDue() {
        return time;
    }

    public LocalDateTime getRentEnd() {
        return End;
    }

    public boolean isAv() {
        return Av;
    }

    public void closeRental(int stationEnd) {
        this.stationEnd = stationEnd;
        this.End = now();
        this.Av = false;
    }

    @Override
    public String toString() {
        return "\n--------- \n Station \n--------" +
                "bikeID=" + bikeID +
                "\n stationStart=" + stationStart +
                "\n stationEnd=" + stationEnd +
                "\n Start=" +Start +
                "\n time=" + time +
                "\n End=" + End +
                "\nAvailable =" + Av +
                "\n-----------------\n";
    }
}

