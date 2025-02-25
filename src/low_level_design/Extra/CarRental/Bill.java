package CarRental;

public class Bill {
    Reservation reservation;
    boolean isPaid;
    double amount;

    Bill(Reservation reservation) {
        this.reservation = reservation;
        this.amount = computeBillAmount();
        isPaid = false;
    }

    double computeBillAmount() {
        // Based on reservation details we can compute logic.
        return 100.0;
    }
}
