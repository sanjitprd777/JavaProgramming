package ParkingLot.ExitGate;

import ParkingLot.CostEstimation.CostComputation.CostComputation;
import ParkingLot.Parking.ParkingManager.ParkingSpotManager;
import ParkingLot.Ticket.Ticket;

public class ExitGate {

    Ticket ticket;
    CostComputation costComputation;
    ParkingSpotManager parkingSpotManager;

    public ExitGate(Ticket ticket, CostComputation costComputation, ParkingSpotManager parkingSpotManager) {
        this.ticket = ticket;
        this.costComputation = costComputation;
        this.parkingSpotManager = parkingSpotManager;
    }

    public double totalPrice() {
        return costComputation.calculatePrice(ticket);
    }

    public void removeVehicle() {
        parkingSpotManager.removeVehicle(ticket.getParkingSpot());
    }
}
