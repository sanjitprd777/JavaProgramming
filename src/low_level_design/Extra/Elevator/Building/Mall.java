package Elevator.Building;

import java.util.List;

public class Mall {

    List<Floor> floors;

    public Mall(List<Floor> floors) {
        this.floors = floors;
    }

    public Floor getFloor(int idx) {
        return floors.get(idx);
    }
}
