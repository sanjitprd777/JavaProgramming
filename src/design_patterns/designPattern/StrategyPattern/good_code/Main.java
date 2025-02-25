package StrategyPattern.good_code;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new NormalCar();
        vehicle.drive();

        vehicle = new SportCar();
        vehicle.drive();

        vehicle = new SuperCar();
        vehicle.drive();
    }
}
