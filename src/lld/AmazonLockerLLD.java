package lld;
import java.util.*;
import java.lang.Math;

// Enum for Locker Sizes
enum LockerSize {
    SMALL, MEDIUM, LARGE, XL, XXL
}

// Represents geographical coordinates
class GeoLocation {
    private double latitude;
    private double longitude;

    public GeoLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Calculate Euclidean distance (for simplicity)
    public double distanceTo(GeoLocation other) {
        double dx = this.latitude - other.latitude;
        double dy = this.longitude - other.longitude;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Getters
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
}

// Represents an Amazon Locker
class Locker {
    private int id;
    private LockerSize size;
    private GeoLocation location;
    private boolean isAvailable;
    private String lockerCode;
    private String storeOpenTime;  // e.g., "09:00"
    private String storeCloseTime; // e.g., "21:00"

    public Locker(int id, LockerSize size, GeoLocation location, String openTime, String closeTime) {
        this.id = id;
        this.size = size;
        this.location = location;
        this.storeOpenTime = openTime;
        this.storeCloseTime = closeTime;
        this.isAvailable = true;
    }

    // Attempt to assign the locker with a code (if available)
    public boolean assignLocker(String code) {
        if (isAvailable) {
            this.lockerCode = code;
            this.isAvailable = false;
            return true;
        }
        return false;
    }

    // Release the locker (for example, after a refund or pickup)
    public void releaseLocker() {
        this.lockerCode = null;
        this.isAvailable = true;
    }

    // Getters
    public int getId() { return id; }
    public LockerSize getSize() { return size; }
    public GeoLocation getLocation() { return location; }
    public boolean isAvailable() { return isAvailable; }
    public String getLockerCode() { return lockerCode; }
    public String getStoreOpenTime() { return storeOpenTime; }
    public String getStoreCloseTime() { return storeCloseTime; }
}

// Represents an Order eligible for locker delivery/return
class Order {
    private int orderId;
    private boolean eligibleForLocker;
    private Locker assignedLocker;
    private String deliveryStatus;
    private long orderTime;  // timestamp for order creation

    public Order(int orderId, boolean eligibleForLocker) {
        this.orderId = orderId;
        this.eligibleForLocker = eligibleForLocker;
        this.deliveryStatus = "Pending";
        this.orderTime = System.currentTimeMillis();
    }

    // Assign a locker to this order
    public void assignLocker(Locker locker) {
        this.assignedLocker = locker;
    }

    // Getter for the assigned locker
    public Locker getAssignedLocker() {
        return this.assignedLocker;
    }

    public int getOrderId() { return orderId; }
    public boolean isEligibleForLocker() { return eligibleForLocker; }
    public String getDeliveryStatus() { return deliveryStatus; }
    public void setDeliveryStatus(String status) { this.deliveryStatus = status; }
    public long getOrderTime() { return orderTime; }
}

// Utility to generate a 6-digit code for locker access
class LockerCodeGenerator {
    public static String generateCode() {
        int code = (int) (100000 + Math.random() * 900000);
        return String.valueOf(code);
    }
}

// Main system class managing lockers and order processing
class AmazonLockerSystem {
    private List<Locker> lockers;

    public AmazonLockerSystem() {
        lockers = new ArrayList<>();
    }

    public void addLocker(Locker locker) {
        lockers.add(locker);
    }

    // Find the closest available locker of a required size
    public Locker findNearestAvailableLocker(GeoLocation customerLocation, LockerSize requiredSize) {
        Locker nearest = null;
        double minDistance = Double.MAX_VALUE;
        for (Locker locker : lockers) {
            if (locker.getSize() == requiredSize && locker.isAvailable()) {
                double distance = locker.getLocation().distanceTo(customerLocation);
                if (distance < minDistance) {
                    minDistance = distance;
                    nearest = locker;
                }
            }
        }
        return nearest;
    }

    // Process an order by assigning the nearest locker (if the order is eligible)
    public void processOrder(Order order, GeoLocation customerLocation, LockerSize requiredSize) {
        if (!order.isEligibleForLocker()) {
            System.out.println("Order " + order.getOrderId() + " is not eligible for locker delivery.");
            return;
        }
        Locker locker = findNearestAvailableLocker(customerLocation, requiredSize);
        if (locker != null) {
            String code = LockerCodeGenerator.generateCode();
            locker.assignLocker(code);
            order.assignLocker(locker);
            order.setDeliveryStatus("Delivered to Locker");
            System.out.println("Order " + order.getOrderId() + " assigned to Locker " + locker.getId() + " with code: " + code);
        } else {
            System.out.println("No available locker found for Order " + order.getOrderId() + ".");
        }
    }

    // Simulate the refund process after 3 days if the item is not picked up
    public void processRefundIfNotPickedUp(Order order) {
        // For simplicity, we simulate that 3 days have passed.
        if (order.getAssignedLocker() != null) {
            System.out.println("3 days passed for Order " + order.getOrderId() + ". Initiating refund and releasing locker " + order.getAssignedLocker().getId() + ".");
            order.getAssignedLocker().releaseLocker();
            order.setDeliveryStatus("Refund Initiated");
        }
    }

    // Process an item return using the locker system (only for eligible items)
    public void processReturn(Order order, GeoLocation returnLocation, LockerSize requiredSize) {
        System.out.println("Processing return for Order " + order.getOrderId() + ".");
        Locker locker = findNearestAvailableLocker(returnLocation, requiredSize);
        if (locker != null) {
            String code = LockerCodeGenerator.generateCode();
            locker.assignLocker(code);
            System.out.println("Return for Order " + order.getOrderId() + " assigned to Locker " + locker.getId() + " with code: " + code);
        } else {
            System.out.println("No available locker found for return of Order " + order.getOrderId() + ".");
        }
    }
}

// Main class to demonstrate the LLD in action
public class AmazonLockerLLD {
    public static void main(String[] args) {
        AmazonLockerSystem system = new AmazonLockerSystem();

        // Initialize some lockers with different sizes and locations
        system.addLocker(new Locker(1, LockerSize.SMALL, new GeoLocation(10.0, 10.0), "09:00", "21:00"));
        system.addLocker(new Locker(2, LockerSize.MEDIUM, new GeoLocation(11.0, 10.5), "09:00", "21:00"));
        system.addLocker(new Locker(3, LockerSize.LARGE, new GeoLocation(9.5, 9.0), "09:00", "21:00"));

        // Create an order eligible for locker delivery
        Order order1 = new Order(101, true);
        // Customer's preferred geo-location for pickup
        GeoLocation customerLocation = new GeoLocation(10.2, 10.1);

        // Process the order and assign the nearest available SMALL locker
        system.processOrder(order1, customerLocation, LockerSize.SMALL);

        // (Simulate) After 3 days if the item is not picked up, initiate refund and release the locker.
        system.processRefundIfNotPickedUp(order1);

        // Optionally, process a return for an order
        Order order2 = new Order(102, true);
        system.processReturn(order2, new GeoLocation(10.5, 10.3), LockerSize.MEDIUM);
    }
}
