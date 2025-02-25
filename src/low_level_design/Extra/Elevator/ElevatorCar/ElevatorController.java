package Elevator.ElevatorCar;

import Elevator.Building.Floor;

import java.util.*;

public class ElevatorController {

    ElevatorCar elevatorCar;
    PriorityQueue<Integer> upRequest = new PriorityQueue<>();
    PriorityQueue<Integer> downRequest = new PriorityQueue<>(new downComparator());
    Queue<Integer> pendingRequest = new LinkedList<>();

    public ElevatorController() {
        this.elevatorCar = new ElevatorCar();
        this.upRequest = new PriorityQueue<>();
        this.downRequest = new PriorityQueue<>(new downComparator());
        this.pendingRequest = new LinkedList<>();
    }

    public void start() {
        // Check if we got any request
        if (upRequest.size() > 0) {
            int floor = upRequest.poll();
            System.out.println("Elevator is moving at floor: " + floor + " in direction: " + Direction.UP);
            // Check if we have more up request
            if (upRequest.size() == 0) {
                while (pendingRequest.size() > 0) {
                    upRequest.add(pendingRequest.poll());
                }
            }
            elevatorCar.move(floor, Direction.UP);
        }
        else if (downRequest.size() > 0) {
            int floor = downRequest.poll();
            System.out.println("Elevator is moving at floor: " + floor + " in direction: " + Direction.DOWN);
            // Check if we have more up request
            if (downRequest.size() == 0) {
                while (pendingRequest.size() > 0) {
                    downRequest.add(pendingRequest.poll());
                }
            }
            elevatorCar.move(floor, Direction.DOWN);
        }
    }

    public void submitRequest(int floor, Direction direction) {
        // Moving algorithm logic
        // Assuming if elevator is in idle state, it is at the ground floor.
        if (elevatorCar.status == Status.IDLE) {
            elevatorCar.direction = Direction.UP;
        }
        controlElevator(floor, direction);
    }

    void controlElevator(int floor, Direction direction) {
        // Elevator is currently moving upwards, and request came for up.
        // Case 1: Elevator at 3 going up, floor at 5 want to go up.
        if (elevatorCar.direction == Direction.UP && Direction.UP == direction
                && elevatorCar.currentFloor <= floor) {
            upRequest.add(floor);
            return;
        }
        // Case 2: Elevator at 3 going up, floor at 1 want to go up.
        if (elevatorCar.direction == Direction.UP && Direction.UP == direction
                && elevatorCar.currentFloor > floor) {
            pendingRequest.add(floor);
            return;
        }
        // Case 3: Elevator at 3 going up, floor at 5 want to down up.
        if (elevatorCar.direction == Direction.UP && Direction.DOWN == direction
                && elevatorCar.currentFloor <= floor) {
            downRequest.add(floor);
            return;
        }
        // Case 4: Elevator at 3 going up, floor at 1 want to go down.
        if (elevatorCar.direction == Direction.UP && Direction.DOWN == direction) {
            downRequest.add(floor);
            return;
        }
        // Case 5: Elevator at 3 going down, floor at 5 want to go up.
        if (elevatorCar.direction == Direction.DOWN && Direction.UP == direction
                && elevatorCar.currentFloor <= floor) {
            upRequest.add(floor);
            return;
        }
        // Case 2: Elevator at 3 going down, floor at 1 want to go up.
        if (elevatorCar.direction == Direction.DOWN && Direction.UP == direction) {
            upRequest.add(floor);
            return;
        }
        // Case 3: Elevator at 3 going down, floor at 5 want to down up.
        if (elevatorCar.direction == Direction.DOWN && Direction.DOWN == direction
                && elevatorCar.currentFloor <= floor) {
            pendingRequest.add(floor);
            return;
        }
        // Case 4: Elevator at 3 going down, floor at 1 want to go down.
        if (elevatorCar.direction == Direction.DOWN && Direction.DOWN == direction) {
            downRequest.add(floor);
            return;
        }
    }
}

class downComparator implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        return (a.compareTo(b));
    }
}