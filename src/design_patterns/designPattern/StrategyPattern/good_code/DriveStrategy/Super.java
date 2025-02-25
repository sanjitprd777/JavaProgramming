package StrategyPattern.good_code.DriveStrategy;

public class Super implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Super Drive strategy");
    }
}
