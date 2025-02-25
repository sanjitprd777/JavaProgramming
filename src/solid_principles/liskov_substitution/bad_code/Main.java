package liskov_substitution.bad_code;

public class Main {
    public static void main(String[] args) {
        Bike bike = new MotorCycle();
        bike.turnOnEngine();

        Bike bike1 = new Bicycle();
        bike1.turnOnEngine(); // This will fail, also Bicycle class is narrowing down the capability Bike interface.
    }
}
