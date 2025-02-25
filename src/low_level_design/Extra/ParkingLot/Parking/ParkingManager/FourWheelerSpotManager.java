package ParkingLot.Parking.ParkingManager;

import ParkingLot.Parking.ParkingSpot.ParkingSpot;
import ParkingLot.Parking.ParkingStrategy.NearToElevator;
import ParkingLot.Parking.ParkingStrategy.ParkingStrategy;

import java.util.List;

public class FourWheelerSpotManager extends ParkingSpotManager {

//    List<ParkingSpot> fourWheelerParkingSpotList;
//    ParkingStrategy parkingStrategy = new NearToElevator();
//    int parkingSpotCount = 400;

    public FourWheelerSpotManager(List<ParkingSpot> fourWheelerParkingSpotList, ParkingStrategy parkingStrategy,
                           int parkingSpotCount) {
        super(fourWheelerParkingSpotList, parkingStrategy, parkingSpotCount);
    }
}
