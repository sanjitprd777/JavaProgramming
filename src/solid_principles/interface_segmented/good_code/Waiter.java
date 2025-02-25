package interface_segmented.good_code;

public class Waiter implements WaiterInterface {
    @Override
    public void takeOrder() {
        System.out.println("Order taken!");
    }

    @Override
    public void serverOrder() {
        System.out.println("Order Served!");
    }
}
