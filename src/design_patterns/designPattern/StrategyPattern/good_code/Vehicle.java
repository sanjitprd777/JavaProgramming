package StrategyPattern.good_code;

import StrategyPattern.good_code.DriveStrategy.DriveStrategy;

public class Vehicle {
    // This is strategy design principle. Here we are not defining the drive strategy for vehicle, but child of Vehicle
    // class has the power to decide which vehicle strategy they wanted to go with.
    DriveStrategy driveStrategy;
    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive() {
        driveStrategy.drive();
    }
}
