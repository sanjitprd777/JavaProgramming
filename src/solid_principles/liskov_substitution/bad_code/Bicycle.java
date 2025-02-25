package liskov_substitution.bad_code;

public class Bicycle implements Bike {
    int speed;
    @Override
    public void turnOnEngine() {
        // Below code is narrowing down the capability of Bike interface. It should not be done.
        throw new AssertionError("No engine!");

    }

    @Override
    public void accelerate() {
        speed = speed + 1;
    }
}
