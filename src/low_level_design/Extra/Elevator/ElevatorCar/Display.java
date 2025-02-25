package Elevator.ElevatorCar;

public class Display {
    int floor;
    Direction direction;

    public Display() {
        this.floor = 0;
        this.direction = Direction.NULL;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
