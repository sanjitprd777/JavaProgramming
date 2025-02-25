package StrategyPattern.good_code;


import StrategyPattern.good_code.DriveStrategy.Normal;

public class SuperCar extends Vehicle {

    public SuperCar() {
        super(new Normal());
    }
}
