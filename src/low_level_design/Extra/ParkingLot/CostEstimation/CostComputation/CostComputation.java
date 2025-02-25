package ParkingLot.CostEstimation.CostComputation;

import ParkingLot.CostEstimation.PricingStrategy.PricingType;
import ParkingLot.Ticket.Ticket;

public class CostComputation {
    PricingType pricingType;

    CostComputation(PricingType pricingType) {
        this.pricingType = pricingType;
    }

    public double calculatePrice(Ticket ticket) {
        return this.pricingType.price(ticket);
    }
}
