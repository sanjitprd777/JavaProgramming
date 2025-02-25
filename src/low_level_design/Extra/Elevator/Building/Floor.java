package Elevator.Building;

import Elevator.ElevatorCar.Direction;

public class Floor {
    static int id = 0;
    ExternalButton externalButton;

    public Floor(ExternalButtonDispatcher externalButtonDispatcher) {
        Floor.id++;
        this.externalButton = new ExternalButton(externalButtonDispatcher);
    }

    public void pressButton(Direction direction) {
        System.out.println("User request lift at floor: " + Floor.id + " and want to go in direction " + direction);
        externalButton.pressButton(id, direction);
    }
}
