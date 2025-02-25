package ParkingLot.CostEstimation.PricingStrategy;

import ParkingLot.Ticket.Ticket;

public interface PricingType {
    double price(Ticket ticket);
}
