package ParkingLot.CostEstimation.PricingStrategy;

import ParkingLot.Ticket.Ticket;

import java.time.Instant;

public class HourlyType implements PricingType {
    double price = 20;

    public double price(Ticket ticket) {
        long totalEpoch = Instant.now().getEpochSecond() - ticket.getEntryTime();
        // Convert milliseconds to Hours.
        double hours = (double) totalEpoch /(3600);
        return (hours*price + ticket.getParkingSpot().getPrice());
    }
}
