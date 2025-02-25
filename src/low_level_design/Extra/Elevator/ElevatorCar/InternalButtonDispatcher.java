package Elevator.ElevatorCar;

import java.util.List;

public class InternalButtonDispatcher {

    List<ElevatorController> elevatorControllerList;

    public void initialize(List<ElevatorController> elevatorControllerList) {
        this.elevatorControllerList = elevatorControllerList;
    }

    void submitRequest(int elevatorId, int floor, Direction direction) {
        // Iterate on all ElevatorCar
        for (ElevatorController elevatorController : elevatorControllerList) {
            ElevatorCar elevatorCar = elevatorController.elevatorCar;
            if (ElevatorCar.id == elevatorId) {
                elevatorController.submitRequest(floor, direction);
                break;
            }
        }
    }
}
