package interface_segmented.bad_code;

public class Waiter implements ResturantEmployee {
    @Override
    public void washDish() {
        // not my job, unnecessary implementing function which are not related here.
        throw new AssertionError("Not my job!");
    }

    @Override
    public void serveCustomers() {
        System.out.println("Food served!");
    }

    @Override
    public void cookFood() {
        // not my job, unnecessary implementing function which are not related here.
        throw new AssertionError("Not my job!");
    }
}
