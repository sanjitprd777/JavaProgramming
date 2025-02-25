package StrategyPattern.good_code;

import StrategyPattern.good_code.DriveStrategy.Normal;

public class NormalCar extends Vehicle {
    // This will use drive() functionality same as Vehicle class.
    public NormalCar() {
        // This will assign a Normal drive strategy for this NormalCar object.
        super(new Normal());
    }
}
