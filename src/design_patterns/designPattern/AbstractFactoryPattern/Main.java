package AbstractFactoryPattern;

import AbstractFactoryPattern.Vehicle.Vehicle;
import AbstractFactoryPattern.VehicleFactory.VehicleFactory;
import AbstractFactoryPattern.VehicleFactory.VehicleFactoryMain;

public class Main {

    public static void main(String[] args) {
        VehicleFactoryMain vehicleFactoryMain = new VehicleFactoryMain();
        VehicleFactory luxuryVehicleFactory = vehicleFactoryMain.getVehicleFactory("LuxuryVehicleFactory");

        Vehicle vehicle = luxuryVehicleFactory.getVehicle("Luxury1");
        vehicle.type();

        VehicleFactory ordinaryVehicleFactory = vehicleFactoryMain.getVehicleFactory("OrdinaryVehicleFactory");
        vehicle = ordinaryVehicleFactory.getVehicle("Ordinary1");
        vehicle.type();
    }
}
