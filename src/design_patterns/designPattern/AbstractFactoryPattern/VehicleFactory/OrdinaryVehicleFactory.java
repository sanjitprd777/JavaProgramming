package AbstractFactoryPattern.VehicleFactory;

import AbstractFactoryPattern.Vehicle.Ordinary1;
import AbstractFactoryPattern.Vehicle.Ordinary2;
import AbstractFactoryPattern.Vehicle.Vehicle;

public class OrdinaryVehicleFactory implements VehicleFactory {

    public Vehicle getVehicle(String input) {
        switch (input) {
            case "Ordinary1":
                return new Ordinary1();
            case "Ordinary2":
                return new Ordinary2();
            default:
                return null;
        }
    }
}
