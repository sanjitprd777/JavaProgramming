package ATM.AtmState;

import ATM.AtmMachine;
import ATM.Card;

public class SelectOperation extends ATMState {

    AtmMachine atmMachine;
    Card card;

    public SelectOperation(AtmMachine atmMachine, Card card) {
        this.atmMachine = atmMachine;
        this.card = card;
    }

    public void printState() {
        System.out.println("ATM is in SelectOperation state");
        System.out.println("Select from these operation types");
        System.out.println("1 -> Cash Withdrawal");
        System.out.println("2 -> Balance Check");
    }

    public void selectOperation(int input) {
        switch (input) {
            case 1 -> atmMachine.setAtmState(new CashWithdraw(atmMachine, card));
            case 2 -> System.out.println("Balance amount: " + card.getBankAccount().getBalance());
            default -> {
                System.out.println("Invalid option");
                exit();
            }
        }
    }

}
