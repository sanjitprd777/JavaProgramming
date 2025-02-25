package CarRental;

import CarRental.Product.Vehicle;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Reservation {

    int reservationId;
    User user;
    Vehicle vehicle;
    ReservationType reservationType;
    ReservationStatus reservationStatus;

    public int createReserve(User user, Vehicle vehicle) {
        // generate new id;
        reservationId = ThreadLocalRandom.current().nextInt();
        this.user = user;
        this.vehicle = vehicle;
        reservationType = ReservationType.DAILY;
        reservationStatus = ReservationStatus.SCHEDULED;
        return reservationId;
    }
}
