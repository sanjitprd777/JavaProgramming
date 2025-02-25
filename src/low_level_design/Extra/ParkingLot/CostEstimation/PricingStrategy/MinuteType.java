package ParkingLot.CostEstimation.PricingStrategy;

import ParkingLot.Ticket.Ticket;

import java.time.Instant;

public class MinuteType implements PricingType {
    double price = 0.5;

    public double price(Ticket ticket) {
        long totalEpoch = Instant.now().getEpochSecond() - ticket.getEntryTime();
        // Convert milliseconds to Minutes.
        double minutes = (double) totalEpoch /(60);
        return (minutes*price + ticket.getParkingSpot().getPrice());
    }
}
