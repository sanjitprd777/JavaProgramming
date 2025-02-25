package ParkingLot.Parking.ParkingManager;

import ParkingLot.Parking.ParkingSpot.ParkingSpot;
import ParkingLot.Parking.ParkingStrategy.NearToEntrance;
import ParkingLot.Parking.ParkingStrategy.ParkingStrategy;

import java.util.List;

public class TwoWheelerSpotManager extends ParkingSpotManager {

//    List<ParkingSpot> twoWheelerParkingSpotList = null;
//    ParkingStrategy parkingStrategy = new NearToEntrance();
//    int parkingSpotCount = 600;

    public TwoWheelerSpotManager(List<ParkingSpot> twoWheelerParkingSpotList, ParkingStrategy parkingStrategy,
                                 int parkingSpotCount) {
        super(twoWheelerParkingSpotList, parkingStrategy, parkingSpotCount);
    }
}
