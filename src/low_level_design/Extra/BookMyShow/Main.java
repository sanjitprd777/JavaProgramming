package BookMyShow;

import BookMyShow.Enum.City;

public class Main {
    public static void main(String[] args) {

        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();

        // Create booking for a user.
        bookMyShow.createBooking(City.BANGALORE);
    }
}
