package ParkingLot.EntryGate;

import ParkingLot.Parking.ParkingManager.ParkingSpotManager;
import ParkingLot.Parking.ParkingSpot.ParkingSpot;
import ParkingLot.Ticket.Ticket;
import ParkingLot.Vehicle.Vehicle;
import ParkingLot.Vehicle.VehicleType;

import java.time.Instant;

public class EntryGate {
    ParkingSpotManager parkingSpotManager;

    public EntryGate(ParkingSpotManager parkingSpotManager) {
        this.parkingSpotManager = parkingSpotManager;
    }

    public ParkingSpot findParkingSpot(VehicleType vehicleType) {
        return this.parkingSpotManager.findParkingSpace(vehicleType);
    }

    public void bookParkingSpot(ParkingSpot parkingSpot, Vehicle vehicle) {
        this.parkingSpotManager.parkVehicle(parkingSpot, vehicle);
        System.out.println("Vehicle parked!");
    }

    public Ticket generateTicket(ParkingSpot parkingSpot) {
        Ticket ticket = new Ticket(parkingSpot, Instant.now().getEpochSecond());
        System.out.println("Ticket issued!");
        return ticket;
    }
}
