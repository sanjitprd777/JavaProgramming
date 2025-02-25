package ParkingLot.Parking.ParkingStrategy;

import ParkingLot.Parking.ParkingSpot.ParkingSpot;

public class NearToElevator implements ParkingStrategy {

    public ParkingSpot findSpace() {
        // Returns an empty 'parking spot' near to elevator.
        return new ParkingSpot();
    }
}
