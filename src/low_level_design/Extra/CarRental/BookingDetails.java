package CarRental;

import java.util.Date;

public class BookingDetails {
    Date bookedFromDate;
    Date bookedToDate;
    Long bookedFromTime;
    Long bookedToTime;
    Location pickUpLocation;
    Location dropLocation;

    public Date getBookedFromDate() {
        return bookedFromDate;
    }

    public void setBookedFromDate(Date bookedFromDate) {
        this.bookedFromDate = bookedFromDate;
    }

    public Date getBookedToDate() {
        return bookedToDate;
    }

    public void setBookedToDate(Date bookedToDate) {
        this.bookedToDate = bookedToDate;
    }

    public Long getBookedFromTime() {
        return bookedFromTime;
    }

    public void setBookedFromTime(Long bookedFromTime) {
        this.bookedFromTime = bookedFromTime;
    }

    public Long getBookedToTime() {
        return bookedToTime;
    }

    public void setBookedToTime(Long bookedToTime) {
        this.bookedToTime = bookedToTime;
    }

    public Location getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(Location pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public Location getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(Location dropLocation) {
        this.dropLocation = dropLocation;
    }
}
