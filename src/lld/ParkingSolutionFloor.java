package lld;

/*
Design parking solution to handle below usecase.

There are n number of slots
Cars: color (w,b,r) and model (2s, 4s)
Design a solution to get,
1. available slots (number, which slots)
2. number of cars parked (total, w,b,r,2s,4s)
3. get info of slot (slot is empty, slot has 4s car)


We need to write helper function below to support these functionalities. Additionally you can create functions if required.
Create a class that will handle these functionalities -> parkingSpot(), addCar(), removeCar()

Define which data structures you need to use (with explanation and why).

After explaining everything code solution in java.


Follow-up 1:
Suppose I remember my car number but don't know slot number.
Suppose the car has attribute as 4 digit string which denotes car number.
How will we maintain which car is parked at which slot.
I want to find my car slot using car number. How do we handle it.

Follow-up 2:
Suppose we now extend parkingLot to 2 or multiple floor (or levels).
What changes we need to make to support this changes. What function we need to write
 */

import java.util.*;

// Main class to test the multi-floor parking lot solution.
public class ParkingSolutionFloor {

    // Car class with updated attributes.
    static class Car {
        String carNumber; // Unique 4-digit identifier
        String color;     // Should be uppercase: "W", "B", "R"
        String model;     // "2S" for 2-seater, "4S" for 4-seater

        public Car(String carNumber, String color, String model) {
            this.carNumber = carNumber;
            // Ensure color is stored in uppercase
            this.color = color.toUpperCase();
            this.model = model;
        }

        @Override
        public String toString() {
            return "Car[Number=" + carNumber + ", Color=" + color + ", Model=" + model + "]";
        }
    }

    // ParkingSpot class for a specific floor and slot.
    static class ParkingSpot {
        int floorNumber;
        int spotNumber;
        Car parkedCar;

        public ParkingSpot(int floorNumber, int spotNumber) {
            this.floorNumber = floorNumber;
            this.spotNumber = spotNumber;
            this.parkedCar = null;
        }

        public boolean isEmpty() {
            return parkedCar == null;
        }

        @Override
        public String toString() {
            if (isEmpty()) {
                return "Floor " + floorNumber + ", Slot " + spotNumber + " is empty.";
            } else {
                return "Floor " + floorNumber + ", Slot " + spotNumber + " has " + parkedCar.toString();
            }
        }
    }

    // Floor class that groups parking spots and maintains available spot numbers.
    static class Floor {
        int floorNumber;
        ParkingSpot[] spots;
        TreeSet<Integer> availableSlots; // Stores available spot numbers on this floor

        public Floor(int floorNumber, int numberOfSpots) {
            this.floorNumber = floorNumber;
            spots = new ParkingSpot[numberOfSpots];
            availableSlots = new TreeSet<>();
            for (int i = 0; i < numberOfSpots; i++) {
                spots[i] = new ParkingSpot(floorNumber, i + 1);
                availableSlots.add(i + 1);
            }
        }
    }

    // ParkingLot class that supports multiple floors and retrieval using car number.
    static class ParkingLot {
        private Floor[] floors;
        private int totalCars;
        private Map<String, Integer> colorCount;
        private Map<String, Integer> modelCount;
        // Mapping from car number to slot identifier "floor-spot"
        private Map<String, String> carNumberToSlotMap;

        public ParkingLot(int numberOfFloors, int spotsPerFloor) {
            floors = new Floor[numberOfFloors];
            for (int i = 0; i < numberOfFloors; i++) {
                floors[i] = new Floor(i + 1, spotsPerFloor);
            }
            totalCars = 0;
            colorCount = new HashMap<>();
            colorCount.put("W", 0);
            colorCount.put("B", 0);
            colorCount.put("R", 0);
            modelCount = new HashMap<>();
            modelCount.put("2S", 0);
            modelCount.put("4S", 0);
            carNumberToSlotMap = new HashMap<>();
        }

        // Adds a car to the first available slot across floors. Returns slot ID "floor-spot" or "-1" if full.
        public String addCar(Car car) {
            for (Floor floor : floors) {
                if (!floor.availableSlots.isEmpty()) {
                    int spotNumber = floor.availableSlots.first();
                    floor.availableSlots.remove(spotNumber);
                    floor.spots[spotNumber - 1].parkedCar = car;

                    totalCars++;
                    // Update counters
                    colorCount.put(car.color, colorCount.get(car.color) + 1);
                    modelCount.put(car.model, modelCount.get(car.model) + 1);

                    // Record mapping
                    String slotIdentifier = floor.floorNumber + "-" + spotNumber;
                    carNumberToSlotMap.put(car.carNumber, slotIdentifier);
                    return slotIdentifier;
                }
            }
            System.out.println("Parking Full on all floors!");
            return "-1";
        }

        // Removes a car from a given floor and spot.
        public boolean removeCar(int floorNumber, int spotNumber) {
            if (floorNumber < 1 || floorNumber > floors.length) {
                System.out.println("Invalid floor number.");
                return false;
            }
            Floor floor = floors[floorNumber - 1];
            if (spotNumber < 1 || spotNumber > floor.spots.length) {
                System.out.println("Invalid spot number.");
                return false;
            }
            ParkingSpot spot = floor.spots[spotNumber - 1];
            if (spot.isEmpty()) {
                System.out.println("Floor " + floorNumber + ", Slot " + spotNumber + " is already empty.");
                return false;
            }
            Car car = spot.parkedCar;
            totalCars--;
            colorCount.put(car.color, colorCount.get(car.color) - 1);
            modelCount.put(car.model, modelCount.get(car.model) - 1);

            // Remove car mapping
            carNumberToSlotMap.remove(car.carNumber);

            spot.parkedCar = null;
            floor.availableSlots.add(spotNumber);
            return true;
        }

        // Returns a string representing the slot ("floor-spot") for the given car number; "-1" if not found.
        public String findCarSlot(String carNumber) {
            return carNumberToSlotMap.getOrDefault(carNumber, "-1");
        }

        // Prints available slots on each floor.
        public void getAvailableSlots() {
            for (Floor floor : floors) {
                System.out.println("Floor " + floor.floorNumber + " available slots: " + floor.availableSlots);
            }
        }

        // Prints parking statistics for cars
        public void getParkedCarsCount() {
            System.out.println("Total cars parked: " + totalCars);
            System.out.println("W cars parked: " + colorCount.get("W"));
            System.out.println("B cars parked: " + colorCount.get("B"));
            System.out.println("R cars parked: " + colorCount.get("R"));
            System.out.println("2S cars parked: " + modelCount.get("2S"));
            System.out.println("4S cars parked: " + modelCount.get("4S"));
        }

        // Prints info for a given slot specified by floor number and spot number.
        public void getSlotInfo(int floorNumber, int spotNumber) {
            if (floorNumber < 1 || floorNumber > floors.length) {
                System.out.println("Invalid floor number.");
                return;
            }
            Floor floor = floors[floorNumber - 1];
            if (spotNumber < 1 || spotNumber > floor.spots.length) {
                System.out.println("Invalid slot number.");
                return;
            }
            System.out.println(floor.spots[spotNumber - 1].toString());
        }
    }

    public static void main(String[] args) {
        // Create a parking lot with 2 floors and 5 spots per floor
        ParkingLot parkingLot = new ParkingLot(2, 5);

        // Add cars
        String slot1 = parkingLot.addCar(new Car("1234", "W", "4S"));
        String slot2 = parkingLot.addCar(new Car("5678", "B", "2S"));
        String slot3 = parkingLot.addCar(new Car("9101", "R", "4S"));

        System.out.println("Car with number 1234 is parked at: " + slot1);
        System.out.println("Car with number 5678 is parked at: " + slot2);
        System.out.println("Car with number 9101 is parked at: " + slot3);

        // Check available slots on each floor
        parkingLot.getAvailableSlots();

        // Get parked cars count
        parkingLot.getParkedCarsCount();

        // Find a car's slot using car number
        System.out.println("Slot for car 5678: " + parkingLot.findCarSlot("5678"));

        // Get info for a specific slot
        parkingLot.getSlotInfo(1, 1);
        parkingLot.getSlotInfo(2, 3); // Should be empty

        // Remove a car and display updated info
        parkingLot.removeCar(1, 1);
        System.out.println("After removal:");
        parkingLot.getAvailableSlots();
        parkingLot.getParkedCarsCount();
        System.out.println("Slot for car 1234: " + parkingLot.findCarSlot("1234"));
    }
}
