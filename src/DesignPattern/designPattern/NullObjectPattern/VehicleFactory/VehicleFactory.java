package NullObjectPattern.VehicleFactory;

import NullObjectPattern.Vehicle.Car;
import NullObjectPattern.Vehicle.NullObject;
import NullObjectPattern.Vehicle.Vehicle;

public class VehicleFactory {

    public Vehicle getVehicle(String input) {
        if ("Car".equals(input)) {
            return new Car();
        }
        return new NullObject();
    }
}
