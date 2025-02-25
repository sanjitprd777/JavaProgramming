package VendingMachine.VendingStates;

import VendingMachine.VendingMachine;

public class DispenseProduct implements State {

    VendingMachine vendingMachine;
    int productCode;

    public DispenseProduct(VendingMachine vendingMachine, int productCode) {
        this.vendingMachine = vendingMachine;
        this.productCode = productCode;
    }

    public String toString() {
        return "Currently, Vending Machine is in 'Dispensing Product' state";
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

    }

    @Override
    public void getChange(int amount) {

    }

    @Override
    public void dispenseProduct() {
        System.out.println("Dispensing the product");
        vendingMachine.getInventory().removeItemFromShelf(productCode);
        System.out.println("Product count updated!");
    }

    @Override
    public void cancelOrRefund() {

    }

    @Override
    public void updateInventory() {

    }
}
