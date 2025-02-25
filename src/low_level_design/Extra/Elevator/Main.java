package Elevator;

import Elevator.Building.ExternalButton;
import Elevator.Building.ExternalButtonDispatcher;
import Elevator.Building.Floor;
import Elevator.Building.Mall;
import Elevator.ElevatorCar.Direction;
import Elevator.ElevatorCar.ElevatorCar;
import Elevator.ElevatorCar.ElevatorController;
import Elevator.ElevatorCar.InternalButtonDispatcher;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ElevatorController> elevatorControllerList = new ArrayList<>();
        // Add 10 elevators
        int eCount = 10;
        for(int i=0; i<eCount; ++i) {
            elevatorControllerList.add(new ElevatorController());
        }

        // Initialize internalButtons
        InternalButtonDispatcher internalButtonDispatcher = new InternalButtonDispatcher();
        internalButtonDispatcher.initialize(elevatorControllerList);

        // Initialize externalButtons
        ExternalButtonDispatcher externalButtonDispatcher = new ExternalButtonDispatcher();
        externalButtonDispatcher.initialize(elevatorControllerList);

        // Initialize building floor
        List<Floor> floors = new ArrayList<>();
        for(int i=0; i<eCount; ++i) {
            floors.add(new Floor(externalButtonDispatcher));
        }

        // Initialize building
        Mall mall = new Mall(floors);

        // Create eCount (10) threads to run each elevator.
        for (int i = 0; i < eCount; i++) {
            int finalI = i;
            Thread aliveThread = new Thread(() -> {
                while (true) {
                    ElevatorController elevatorController = elevatorControllerList.get(finalI);
                    elevatorController.start();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        // Ignore interruptions
                    }
                }
            });
            // Set the thread as a daemon thread, so it won't keep the program running if the main thread exits
            aliveThread.setDaemon(true);
            aliveThread.start(); // Start the thread
        }

        // say user is at floor 4 and want to go at floor 9.
        Floor floor = mall.getFloor(4);
        floor.pressButton(Direction.UP);
    }
}
