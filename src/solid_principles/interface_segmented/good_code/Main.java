package interface_segmented.good_code;

public class Main {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        Chef chef = new Chef();

        chef.decideMenu();
        waiter.takeOrder();
        chef.cookFood();
        waiter.serverOrder();
    }
}
