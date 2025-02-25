package liskov_substitution.good_code;

public class Bicycle implements Bike {
    int speed;
    @Override
    public void turnOnEngine() {
        // Below code is narrowing down the capability of Bike interface. It should not be done.
        System.out.println("There is no Engine in Bicycle!");
    }

    @Override
    public void accelerate() {
        speed = speed + 1;
    }

    public void paddle() {
        System.out.println("Starting BiCycle!");
    }
}
