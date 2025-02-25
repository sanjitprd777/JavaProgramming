package CarRental.Product;

import javax.xml.crypto.Data;

public class Vehicle {
    // Common vehicle types
    int vehicleId;
    String vehicleNumber;
    VehicleType vehicleType;
    String companyName;
    String modelName;
    int kmDriven;
    Data manufactureDate;
    double dailyRentalCost;
    double hourlyRentalCost;
    int seat;
    Status status;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getKmDriven() {
        return kmDriven;
    }

    public void setKmDriven(int kmDriven) {
        this.kmDriven = kmDriven;
    }

    public Data getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Data manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public double getDailyRentalCost() {
        return dailyRentalCost;
    }

    public void setDailyRentalCost(double dailyRentalCost) {
        this.dailyRentalCost = dailyRentalCost;
    }

    public double getHourlyRentalCost() {
        return hourlyRentalCost;
    }

    public void setHourlyRentalCost(double hourlyRentalCost) {
        this.hourlyRentalCost = hourlyRentalCost;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
