package CarRental;

import CarRental.Product.Vehicle;
import CarRental.Product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class VehicleInventoryManagement {

    List<Vehicle> vehicles;

    VehicleInventoryManagement(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles(VehicleType vehicleType) {
        List<Vehicle> vehicleList = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleType() == vehicleType) {
                vehicleList.add(vehicle);
            }
        }
        return vehicleList;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

}
