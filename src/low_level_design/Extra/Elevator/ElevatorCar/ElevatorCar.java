package Elevator.ElevatorCar;

public class ElevatorCar {
    static int id = 0;
    Display display;
    int currentFloor;
    Direction direction;
    Status status;
    Door door;
    InternalButton internalButton;

    public ElevatorCar() {
        id++;
        this.display = new Display();
        this.currentFloor = 0;
        this.direction = Direction.NULL;
        this.status = Status.IDLE;
        this.door = Door.CLOSE;
        this.internalButton = new InternalButton();
    }

    public void move(int destinationFloor, Direction direction) {
        // Moving logic.
        System.out.println("Moving in direction: " + direction);

        // Change elevator state.
        this.direction = direction;
        this.status = Status.MOVING;
        this.door = Door.CLOSE;
        this.display.direction = direction;

        if (Direction.UP == direction) {
            this.currentFloor = this.currentFloor + 1;
        }
        else {
            this.currentFloor = this.currentFloor - 1;
        }
        this.display.floor = this.currentFloor;

        if (this.currentFloor == destinationFloor) {
            this.door = Door.OPEN;
            System.out.println("Reached destination floor: " + destinationFloor);
            if (this.currentFloor == 0)
                this.status = Status.IDLE;
        }
    }

    void pressButton(int floor) {
        internalButton = new InternalButton();
        internalButton.pressButton(id, floor, direction);
    }
}
