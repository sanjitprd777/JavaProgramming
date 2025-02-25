package CarRental;

import java.util.List;

public class VehicleRentalSystem {
    List<User> users;
    List<Store> stores;

    VehicleRentalSystem(List<Store> stores, List<User> users) {
        this.stores = stores;
        this.users = users;
    }

    public Store getStore(Location location) {
        // Logic to find store based on location
        return stores.get(0);
    }

    void addUser(User user) {
        users.add(user);
    }

    void removeUser(User user) {
        users.remove(user);
    }

    void addStore(Store store) {
        stores.add(store);
    }

    void removeStore(Store store) {
        stores.remove(store);
    }
}
