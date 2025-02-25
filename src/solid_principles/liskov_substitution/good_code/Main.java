package liskov_substitution.good_code;

public class Main {
    public static void main(String[] args) {
        Bike bike = new MotorCycle();
        bike.turnOnEngine();

        Bike bike1 = new Bicycle();
        bike1.turnOnEngine(); // This is not extending the Bike interface capability, but also not narrowing it.
        ((Bicycle) bike1).paddle(); // This is extending the Bike interface capability, this is correct.
    }
}
