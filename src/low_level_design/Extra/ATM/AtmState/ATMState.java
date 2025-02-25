package ATM.AtmState;

import ATM.Card;

public abstract class ATMState {

    public void insertCard(Card card) {
        System.out.println("OOPS! try again.");
    }

    public void authenticatePin(int input) {
        System.out.println("OOPS! try again.");
    }

    public void selectOperation(int input) {
        System.out.println("OOPS! try again.");
    }

    public void cashWithdraw(int input) {
        System.out.println("OOPS! try again.");
    }

    public void displayBalance(String input) {
        System.out.println("OOPS! try again.");
    }

    void exit() {
        System.out.println("Invoked exit ATM state!");
        returnCard();
    }

    void returnCard() {
        System.out.println("Please collect your card");
    }

    public void printState() {
        System.out.println("OOPS! try again.");
    }
}
