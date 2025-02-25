package VendingMachine.VendingStates;

import VendingMachine.VendingMachine;

public class SelectionState implements State {

    VendingMachine vendingMachine;
    int totalAmount;
    int productCode;

    public SelectionState(VendingMachine vendingMachine, int totalAmount) {
        this.vendingMachine = vendingMachine;
        this.totalAmount = totalAmount;
    }

    public String toString() {
        return "Currently, Vending Machine is in 'Product Selection' state";
    }

    @Override
    public void pressInsertCoinButton() {

    }

    @Override
    public void insertCoin() {

    }

    @Override
    public void pressProductSelectionButton() {
    }

    @Override
    public void productSelection() {
        System.out.println("Select your product");
        int productCode = 202;
        this.productCode = productCode;
        System.out.println("You selected product: " + productCode);

        Integer productPrice = 0;
        while (true) {
            // Get item code price if product exists;
            productPrice = vendingMachine.getInventory().getItemPrice().get(productCode);
            if (productPrice == null) {
                System.out.println("Product does not exist, try again!");
                continue;
            }
            break;
        }

        if (totalAmount < productPrice) {
            System.out.println("Insufficient money provided, try again!");
            cancelOrRefund();
        }
        else {
            getChange(totalAmount-productPrice);
        }
        vendingMachine.setState(new DispenseProduct(vendingMachine, productCode));

    }

    @Override
    public void getChange(int amount) {
        System.out.println("Returning the change amount: " + amount);
    }

    @Override
    public void dispenseProduct() {

    }

    @Override
    public void cancelOrRefund() {
        System.out.println("Money returned!");
        vendingMachine.setState(new Idle(vendingMachine));
    }

    @Override
    public void updateInventory() {

    }
}
