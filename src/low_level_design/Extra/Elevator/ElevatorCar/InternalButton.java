package Elevator.ElevatorCar;

import java.util.List;

public class InternalButton {
    InternalButtonDispatcher internalButtonDispatcher;

    public void initialize() {
        internalButtonDispatcher = new InternalButtonDispatcher();
    }
    void pressButton(int elevatorId, int floor, Direction direction) {
        internalButtonDispatcher.submitRequest(elevatorId, floor, direction);
    }
}
