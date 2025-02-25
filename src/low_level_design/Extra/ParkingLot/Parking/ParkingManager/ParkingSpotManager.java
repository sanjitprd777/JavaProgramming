package ParkingLot.Parking.ParkingManager;

import ParkingLot.Parking.ParkingSpot.FourWheelerSpot;
import ParkingLot.Parking.ParkingSpot.ParkingSpot;
import ParkingLot.Parking.ParkingSpot.TwoWheelerSpot;
import ParkingLot.Parking.ParkingStrategy.ParkingStrategy;
import ParkingLot.Vehicle.Vehicle;
import ParkingLot.Vehicle.VehicleType;

import java.util.List;

public class ParkingSpotManager {

    public List<ParkingSpot> parkingSpotList;
    public ParkingStrategy parkingStrategy;
    public int parkingSpotCount;

    public ParkingSpotManager(List<ParkingSpot> parkingSpots, ParkingStrategy parkingStrategy, int parkingSpotCount) {
        this.parkingSpotList = parkingSpots;
        this.parkingStrategy = parkingStrategy;
        this.parkingSpotCount = parkingSpotCount;
    }

    public ParkingSpot findParkingSpace(VehicleType vehicleType) {
        if (this.parkingSpotCount <= 0)
            return null;
        if (VehicleType.TwoWheeler == vehicleType) {
            this.parkingSpotCount--;
            return new TwoWheelerSpot();
        }
        else if(VehicleType.FourWheeler == vehicleType) {
            this.parkingSpotCount--;
            return new FourWheelerSpot();
        }
        return null;
    }

    public void addParkingSpot() {
        parkingSpotCount++;
    }

    public void removeParkingSpot() {
        parkingSpotCount--;
    }

    public void parkVehicle(ParkingSpot parkingSpot, Vehicle vehicle) {
        parkingSpot.setId(parkingSpot.getId() + 1);
        parkingSpot.setVehicle(vehicle);
        parkingSpot.setEmpty(false);
        this.parkingSpotList.add(parkingSpot);
    }

    public void removeVehicle(ParkingSpot parkingSpot) {
        parkingSpot.setVehicle(null);
        parkingSpot.setEmpty(true);
        this.parkingSpotList.remove(parkingSpot);
    }

}
