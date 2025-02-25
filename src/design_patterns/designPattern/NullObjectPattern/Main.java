package NullObjectPattern;

import NullObjectPattern.Vehicle.Vehicle;
import NullObjectPattern.VehicleFactory.VehicleFactory;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new VehicleFactory().getVehicle("Car");
        System.out.println(car.getSeatCapacity());

        Vehicle bike = new VehicleFactory().getVehicle("Bike");
        System.out.println(bike.getSeatCapacity());
    }
}
