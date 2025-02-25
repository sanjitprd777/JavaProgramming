package ParkingLot.Parking.ParkingSpot;

import ParkingLot.Vehicle.Vehicle;

public class ParkingSpot {

    static int id = 0;
    boolean isEmpty = true;
    Vehicle vehicle = null;
    double price = 10;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        ParkingSpot.id = id;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
