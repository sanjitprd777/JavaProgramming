package liskov_substitution.bad_code;

public class MotorCycle implements Bike {
    boolean isEngineOn;
    int speed;
    @Override
    public void turnOnEngine() {
        isEngineOn = true;
        System.out.println("Engine Started!");
    }

    @Override
    public void accelerate() {
        speed = speed + 1;
        System.out.println("Speed increased");
    }
}
