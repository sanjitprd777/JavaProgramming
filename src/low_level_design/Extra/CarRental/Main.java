package CarRental;

import CarRental.Product.Vehicle;
import CarRental.Product.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        // Create users
        List<User> users = new ArrayList<>();
        for (int i=0; i<10; ++i){
            User user = new User();
            user.userId = ThreadLocalRandom.current().nextInt();
            users.add(user);
        }

        // Add stores and vehicles
        List<Store> stores = new ArrayList<>();
        for (int i=0; i<5; ++i) {
            Store store = new Store();
            store.storeId = ThreadLocalRandom.current().nextInt();
            List<Vehicle> vehicles = new ArrayList<>();
            for (int j=0; j<10; ++j) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleType(VehicleType.CAR);
                vehicle.setVehicleId(ThreadLocalRandom.current().nextInt());
                vehicles.add(vehicle);
            }
            store.setVehicles(vehicles);
            stores.add(store);
        }

        VehicleRentalSystem vehicleRentalSystem = new VehicleRentalSystem(stores, users);

        // 0. User comes.
        User user = users.get(0);
        System.out.println("User: " + user);

        // 1. user create filter based on location.
        Location location = new Location();

        // 2. user gets store based on location.
        Store store = vehicleRentalSystem.getStore(location);

        // 3. user search vehicle list based on vehicle filter.
        List<Vehicle> vehicles = store.getVehicles(VehicleType.CAR);

        // 4. Reserving particular vehicle
        Reservation reservation = store.createReservation(vehicles.get(0), user);
        reservation.reservationId = ThreadLocalRandom.current().nextInt();
        System.out.println("Reservation: " + reservation);

        // 5. Generate bill
        Bill bill = new Bill(reservation);
        System.out.println("Bill: " + bill);

        // 6. Make payment.
        Payment payment = new Payment(bill);
        System.out.println("Payment: " + payment);

        // 7. Mark reservation complete.
        store.completeReservation(reservation.reservationId);
        System.out.println("Reservation: " + reservation);
    }
}
