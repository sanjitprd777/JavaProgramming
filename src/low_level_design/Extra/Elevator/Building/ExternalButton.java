package Elevator.Building;

import Elevator.ElevatorCar.Direction;

public class ExternalButton {
    ExternalButtonDispatcher externalButtonDispatcher;

    public ExternalButton(ExternalButtonDispatcher externalButtonDispatcher) {
        this.externalButtonDispatcher = externalButtonDispatcher;
    }

    public void pressButton(int floor, Direction direction) {
        externalButtonDispatcher.submitRequest(floor, direction);
    }
}
