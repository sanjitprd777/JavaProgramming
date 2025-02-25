package ATM.AtmState;

import ATM.AtmMachine;
import ATM.Card;

public class HasCard extends ATMState {

    AtmMachine atmMachine;
    Card card;

    public HasCard(AtmMachine atmMachine, Card card) {
        this.atmMachine = atmMachine;
        this.card = card;
    }

    public void printState() {
        System.out.println("ATM is in HasCard state");
    }

    public void authenticatePin(int pin) {
        System.out.println("Enter the ATM Card Pin");
        if (pin != card.getPinNumber()) {
            System.out.println("Incorrect Card Pin");
            exit();
        }
        atmMachine.setAtmState(new SelectOperation(atmMachine, card));

    }


}
