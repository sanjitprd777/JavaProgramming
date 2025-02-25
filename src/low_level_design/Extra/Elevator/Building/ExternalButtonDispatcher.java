package Elevator.Building;

import Elevator.ElevatorCar.Direction;
import Elevator.ElevatorCar.ElevatorController;

import java.util.List;
import java.util.Random;

public class ExternalButtonDispatcher {
    List<ElevatorController> elevatorControllerList;

    public void initialize(List<ElevatorController> elevatorControllerList) {
        this.elevatorControllerList = elevatorControllerList;
    }

    void submitRequest(int floor, Direction direction) {
        // Select random elevator. Can be odd/even or fixed floor logic.
        Random random = new Random();
        int idx = random.nextInt(elevatorControllerList.size());
        ElevatorController elevatorController = elevatorControllerList.get(idx);
        elevatorController.submitRequest(floor, direction);
    }
}
