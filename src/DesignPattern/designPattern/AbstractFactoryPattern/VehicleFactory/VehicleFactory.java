package AbstractFactoryPattern.VehicleFactory;

import AbstractFactoryPattern.Vehicle.Vehicle;

public interface VehicleFactory {
    Vehicle getVehicle(String input);
}
