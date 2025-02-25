package ParkingLot.Ticket;

import ParkingLot.Parking.ParkingSpot.ParkingSpot;
import java.time.Instant;

public class Ticket {

    long entryTime;
    ParkingSpot parkingSpot;

    public Ticket(ParkingSpot parkingSpot, long entryTime) {
        this.parkingSpot = parkingSpot;
        this.entryTime = entryTime;
    }

    public long getEntryTime() {
        return entryTime;
    }
    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

}
