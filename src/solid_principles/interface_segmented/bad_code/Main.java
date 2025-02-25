package interface_segmented.bad_code;

public class Main {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        waiter.serveCustomers();
        waiter.cookFood(); // bad code
        waiter.washDish(); // bad code
    }
}
