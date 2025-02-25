package StrategyPattern.bad_code;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.drive();

        vehicle = new SportCar();
        vehicle.drive();

        vehicle = new SuperCar();
        vehicle.drive();

        vehicle = new NormalCar();
        vehicle.drive();
    }
}
