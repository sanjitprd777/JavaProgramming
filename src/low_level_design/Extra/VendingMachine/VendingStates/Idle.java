package VendingMachine.VendingStates;

import VendingMachine.VendingMachine;

public class Idle implements State {

    VendingMachine vendingMachine;
    public Idle(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public String toString() {
        return "Currently, Vending Machine is in 'Idle' state";
    }

    @Override
    public void pressInsertCoinButton() {
        System.out.println("Press insert coin button!");
        this.vendingMachine.setState(new HasMoney(vendingMachine));
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

    }

    @Override
    public void cancelOrRefund() {

    }

    @Override
    public void updateInventory() {

    }
}
