package ATM.AtmState;

import ATM.AtmMachine;
import ATM.Card;

public class Idle extends ATMState {

    AtmMachine atmMachine;
    Card card;

    public Idle(AtmMachine atmMachine) {
        this.atmMachine = atmMachine;
        this.card = null;
    }

    public void printState() {
        System.out.println("ATM is in Idle state");
        System.out.println("Insert Card");
    }

    public void insertCard(Card card) {
        if (card == null) {
            exit();
        }
        System.out.println("Card inserted");
        atmMachine.setAtmState(new HasCard(atmMachine, card));
    }
}
