package AbstractFactoryPattern.VehicleFactory;

import AbstractFactoryPattern.Vehicle.Luxury1;
import AbstractFactoryPattern.Vehicle.Luxury2;
import AbstractFactoryPattern.Vehicle.Vehicle;

public class LuxuryVehicleFactory implements VehicleFactory {

    public Vehicle getVehicle(String input) {
        switch(input) {
            case "Luxury1":
                return new Luxury1();
            case "Luxury2":
                return new Luxury2();
            default:
                return null;
        }
    }
}
