package ParkingLot.Parking.ParkingStrategy;

import ParkingLot.Parking.ParkingSpot.ParkingSpot;

public class NearToEntrance implements ParkingStrategy {

    public ParkingSpot findSpace() {
        // Returns an empty 'parking spot' near to entrance.
        return new ParkingSpot();
    }
}
