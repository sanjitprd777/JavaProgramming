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

 */

import java.util.*;

public class ParkingSolution {

    static class Car {
        String color;
        String model;
        String carNumber; // Unique 4-digit car number

        public Car(String color, String model, String carNumber) {
            this.color = color;
            this.model = model;
            this.carNumber = carNumber;
        }

        @Override
        public String toString() {
            return "Car[number=" + carNumber + ", color=" + color + ", model=" + model + "]";
        }
    }

    static class ParkingSpot {
        int slotNumber;
        Car parkedCar;

        // This is our parkingSpot() helper which creates an empty parking spot.
        public ParkingSpot(int slotNumber) {
            this.slotNumber = slotNumber;
            this.parkedCar = null;
        }

        public boolean isEmpty() {
            return parkedCar == null;
        }

        @Override
        public String toString() {
            if(isEmpty()) {
                return "Slot " + slotNumber + " is empty.";
            }
            return "Slot " + slotNumber + " has " + parkedCar.toString();
        }
    }

    static class ParkingLot {
        private ParkingSpot[] spots;
        // Use TreeSet to maintain available slots in order.
        private TreeSet<Integer> availableSlots;

        private Map<String, Integer> carNumberToSlotMap;

        // Counters for parked cars
        private int totalCars;
        private Map<String, Integer> colorCount;
        private Map<String, Integer> modelCount;

        public ParkingLot(int totalSlots) {
            spots = new ParkingSpot[totalSlots];
            availableSlots = new TreeSet<>();
            for (int i = 0; i < totalSlots; i++) {
                spots[i] = new ParkingSpot(i + 1);
                availableSlots.add(i + 1);
            }
            totalCars = 0;
            colorCount = new HashMap<>();
            colorCount.put("w", 0);
            colorCount.put("b", 0);
            colorCount.put("r", 0);
            modelCount = new HashMap<>();
            modelCount.put("2s", 0);
            modelCount.put("4s", 0);

            // Initialize the car number to slot map
            carNumberToSlotMap = new HashMap<>();
        }


        // Function to add a car to the parking lot.
        // Returns the slot number where the car is parked; returns -1 if no slot available.
        public int addCar(Car car) {
            if (availableSlots.isEmpty()) {
                System.out.println("Parking Full!");
                return -1;
            }
            int slotNumber = availableSlots.first();
            availableSlots.remove(slotNumber);
            spots[slotNumber - 1].parkedCar = car;

            totalCars++;
            colorCount.put(car.color, colorCount.get(car.color) + 1);
            modelCount.put(car.model, modelCount.get(car.model) + 1);

            // Update mapping: record car number with its slot
            carNumberToSlotMap.put(car.carNumber, slotNumber);

            return slotNumber;
        }


        // Function to remove a car from a given slot.
        public boolean removeCar(int slotNumber) {
            if (slotNumber < 1 || slotNumber > spots.length) {
                System.out.println("Invalid slot number.");
                return false;
            }
            ParkingSpot spot = spots[slotNumber - 1];
            if (spot.isEmpty()) {
                System.out.println("Slot " + slotNumber + " is already empty.");
                return false;
            }
            Car car = spot.parkedCar;
            totalCars--;
            colorCount.put(car.color, colorCount.get(car.color) - 1);
            modelCount.put(car.model, modelCount.get(car.model) - 1);

            // Remove car number from mapping
            carNumberToSlotMap.remove(car.carNumber);

            spot.parkedCar = null;
            availableSlots.add(slotNumber);
            return true;
        }

        public int findCarSlot(String carNumber) {
            return carNumberToSlotMap.getOrDefault(carNumber, -1);
        }

        // Function to get available slots: returns a list with the count and slot numbers.
        public void getAvailableSlots() {
            System.out.println("Number of available slots: " + availableSlots.size());
            System.out.println("Available slot numbers: " + availableSlots);
        }

        // Function to get number of cars parked, by color and model.
        public void getParkedCarsCount() {
            System.out.println("Total cars parked: " + totalCars);
            System.out.println("White cars parked: " + colorCount.get("w"));
            System.out.println("Black cars parked: " + colorCount.get("b"));
            System.out.println("Red cars parked: " + colorCount.get("r"));
            System.out.println("2s cars parked: " + modelCount.get("2s"));
            System.out.println("4s cars parked: " + modelCount.get("4s"));
        }

        // Function to get info of a specific slot.
// Function to get info of a specific slot.
        public void getSlotInfo(int slotNumber) {
            if (slotNumber < 1 || slotNumber > spots.length) {
                System.out.println("Invalid slot number.");
                return;
            }
            ParkingSpot spot = spots[slotNumber - 1];
            if (spot.isEmpty()) {
                System.out.println("Slot " + slotNumber + " is empty.");
            } else {
                System.out.println("Slot " + slotNumber + " has Car with Color: "
                        + spot.parkedCar.color + " and Model: "
                        + spot.parkedCar.model + ".");
            }
        }
    }

    public static void main(String[] args) {
        // Let's create a parking lot with 5 slots
        ParkingLot parkingLot = new ParkingLot(5);

        // Add some cars
        int slot1 = parkingLot.addCar(new Car("w", "4s", "1234"));
        int slot2 = parkingLot.addCar(new Car("b", "2s", "5678"));
        int slot3 = parkingLot.addCar(new Car("r", "4s", "9101"));

        // Print available slots
        parkingLot.getAvailableSlots();

        // Print parked cars count by attribute
        parkingLot.getParkedCarsCount();

        // Get info for specific slots
        parkingLot.getSlotInfo(slot1);
        parkingLot.getSlotInfo(4); // This should be an empty slot

        // Remove a car from slot2
        parkingLot.removeCar(slot2);

        // Re-check available slots and counts after removal
        parkingLot.getAvailableSlots();
        parkingLot.getParkedCarsCount();
    }
}
