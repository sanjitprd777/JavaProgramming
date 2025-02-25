package CarRental;

import CarRental.Product.Vehicle;
import CarRental.Product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Store {

    int storeId;
    Location storeLocation;
    VehicleInventoryManagement inventoryManagement;
    List<Reservation> reservations = new ArrayList<>();

    public List<Vehicle> getVehicles(VehicleType vehicleType) {
        return inventoryManagement.getVehicles(vehicleType);
    }

    public void setVehicles(List<Vehicle> vehicles) {
        inventoryManagement = new VehicleInventoryManagement(vehicles);
    }

    public Reservation createReservation(Vehicle vehicle, User user) {
        Reservation reservation = new Reservation();
        reservation.createReserve(user, vehicle);
        reservation.reservationStatus = ReservationStatus.SCHEDULED;
        reservations.add(reservation);
        return reservation;
    }

    public boolean completeReservation(int reservationId) {
        // Take out the reservation from the list and call complete the reservation method.
        for (Reservation reservation : reservations) {
            if (reservation.reservationId == reservationId) {
                reservation.reservationStatus = ReservationStatus.COMPLETED;
                return true;
            }
        }
        return false;
    }

    public boolean inProgressReservation(int reservationId) {
        // Take out the reservation from the list and call complete the reservation method.
        for (Reservation reservation : reservations) {
            if (reservation.reservationId == reservationId) {
                reservation.reservationStatus = ReservationStatus.INPROGRESS;
                return true;
            }
        }
        return false;
    }


    public boolean cancelReservation(int reservationId) {
        // Take out the reservation from the list and call complete the reservation method.
        for (Reservation reservation : reservations) {
            if (reservation.reservationId == reservationId) {
                reservation.reservationStatus = ReservationStatus.CANCELLED;
                return true;
            }
        }
        return false;
    }
}
