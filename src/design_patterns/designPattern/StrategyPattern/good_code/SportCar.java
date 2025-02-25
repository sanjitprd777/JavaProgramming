package StrategyPattern.good_code;

import StrategyPattern.good_code.DriveStrategy.Sport;

public class SportCar extends Vehicle {

    public SportCar() {
        super(new Sport());
    }
}
