package ATM;

import ATM.AtmState.ATMState;
import ATM.AtmState.Idle;

public class AtmMachine {

    ATMState atmState;
    AtmBalance atmBalance;

    public AtmMachine() {
        this.atmState = new Idle(this);
    }

    public ATMState getAtmState() {
        return atmState;
    }

    public void setAtmState(ATMState atmState) {
        this.atmState = atmState;
    }

    public AtmBalance getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(AtmBalance atmBalance) {
        this.atmBalance = atmBalance;
    }
}
