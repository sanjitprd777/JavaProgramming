package VendingMachine.VendingStates;

import VendingMachine.Coin;
import VendingMachine.VendingMachine;

public class HasMoney implements State {

    VendingMachine vendingMachine;
    int totalAmount;

    public HasMoney(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public String toString() {
        return "Currently, Vending Machine is in 'Has Money' state";
    }

    @Override
    public void pressInsertCoinButton() {

    }

    @Override
    public void insertCoin() {
        System.out.println("Accepting the coin");
        vendingMachine.getCoins().add(Coin.TWENTY);
        vendingMachine.getCoins().add(Coin.TEN);
        vendingMachine.getCoins().add(Coin.TWO);

        int totalAmount = 0;
        // Logic to check if provided money is sufficient and return change
        for (Coin coin : vendingMachine.getCoins()) {
            switch (coin) {
                case ONE -> totalAmount +=1;
                case TWO -> totalAmount += 2;
                case FIVE -> totalAmount += 5;
                case TEN -> totalAmount += 10;
                case TWENTY -> totalAmount += 20;
                default -> totalAmount += 0;
            }
        }
        this.totalAmount = totalAmount;
        System.out.println("Inserted money in Vending machine is: " + totalAmount);
    }

    @Override
    public void pressProductSelectionButton() {
        System.out.println("Press product selection button");
        vendingMachine.setState(new SelectionState(vendingMachine, totalAmount));
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
