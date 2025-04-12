package AbstractFactoryPattern.VehicleFactory;

import AbstractFactoryPattern.Vehicle.Vehicle;

public class VehicleFactoryMain {
    public VehicleFactory getVehicleFactory(String input) {
        switch (input) {
            case "LuxuryVehicleFactory":
                return new LuxuryVehicleFactory();
            case "OrdinaryVehicleFactory":
                return new OrdinaryVehicleFactory();
            default:
                return null;
        }
    }
}
