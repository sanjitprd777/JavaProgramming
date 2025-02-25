package ParkingLot;

import ParkingLot.CostEstimation.CostComputation.CostComputation;
import ParkingLot.CostEstimation.CostComputation.TwoWheelerCostComputation;
import ParkingLot.CostEstimation.PricingStrategy.MinuteType;
import ParkingLot.EntryGate.EntryGate;
import ParkingLot.ExitGate.ExitGate;
import ParkingLot.Parking.ParkingManager.FourWheelerSpotManager;
import ParkingLot.Parking.ParkingManager.ParkingSpotManager;
import ParkingLot.Parking.ParkingManager.TwoWheelerSpotManager;
import ParkingLot.Parking.ParkingSpot.ParkingSpot;
import ParkingLot.Parking.ParkingStrategy.NearToElevator;
import ParkingLot.Parking.ParkingStrategy.NearToEntrance;
import ParkingLot.Ticket.Ticket;
import ParkingLot.Vehicle.Vehicle;
import ParkingLot.Vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        // Two Wheeler Parking spot manager initialize.
        List<ParkingSpot> twoWheelerSpotList = new ArrayList<>();
        ParkingSpotManager twoWheelerSpotManager = new TwoWheelerSpotManager(twoWheelerSpotList,
                new NearToEntrance(), 600);

        // Four Wheeler Parking spot manager initialize.
        List<ParkingSpot> fourWheelerSpotList = new ArrayList<>();
        ParkingSpotManager fourWheelerSpotManager = new FourWheelerSpotManager(fourWheelerSpotList,
                new NearToElevator(), 400);

        /**
         * Case 1:
         * Vehicle Type: Two Wheeler
         * ParkingStrategy: Near to Entrance
         * PricingStrategy: Minute Based
         */
        // Entry Gate
        EntryGate entryGate = new EntryGate(twoWheelerSpotManager);

        Vehicle vehicle = new Vehicle(VehicleType.TwoWheeler, 123);
        System.out.println("Vehicle arrives at entry gate of type: " + VehicleType.TwoWheeler);

        // Find Two wheeler parking spot;
        System.out.println("Remaining parking spot for vehicle type " + vehicle.getVehicleType()
                + " is " + twoWheelerSpotManager.parkingSpotCount);
        ParkingSpot parkingSpot = entryGate.findParkingSpot(vehicle.getVehicleType());
        if (parkingSpot == null) {
            System.out.println("No parking space left!");
            throw new AssertionError("Terminating abruptly!");
        }

        Ticket ticket = entryGate.generateTicket(parkingSpot);
        entryGate.bookParkingSpot(parkingSpot, vehicle);

        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException exc) {
            System.out.println("Interrupted!");
        }

        CostComputation costComputation = new TwoWheelerCostComputation(new MinuteType());

        // Exit Gate
        ExitGate exitGate = new ExitGate(ticket, costComputation, twoWheelerSpotManager);

        double totalAmount = exitGate.totalPrice();
        System.out.println("You've to pay : " + totalAmount);

        exitGate.removeVehicle();
        System.out.println("Vehicle removed from parking spot.");
    }
}
