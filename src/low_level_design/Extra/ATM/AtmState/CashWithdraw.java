package ATM.AtmState;

import ATM.AtmMachine;
import ATM.AtmWithdraw.FiveHundred;
import ATM.AtmWithdraw.Hundred;
import ATM.AtmWithdraw.TwoThousand;
import ATM.AtmWithdraw.WithdrawProcessor;
import ATM.Card;

import java.util.HashMap;
import java.util.Map;

public class CashWithdraw extends ATMState {

    AtmMachine atmMachine;
    Card card;

    public CashWithdraw(AtmMachine atmMachine, Card card) {
        this.atmMachine = atmMachine;
        this.card = card;
    }

    public void printState() {
        System.out.println("ATM is in CashWithdrawal state");
        System.out.println("Enter the amount");
    }

    public void cashWithdraw(int input) {
        // Check if ATM has sufficient money.
        if (atmMachine.getAtmBalance().getTotalAmount() < input) {
            System.out.println("Sorry! ATM has low balance");
            exit();
        }
        if (card.getBankAccount().getBalance() < input) {
            System.out.println("Insufficient amount in bank to process this request");
            exit();
        }
        card.getBankAccount().deductAmount(input);

        Map<Integer, Integer> cashWithdrawMap = new HashMap<>();

        WithdrawProcessor withdrawProcessor = new TwoThousand(new FiveHundred(new Hundred(null)));
        withdrawProcessor.withdrawCash(atmMachine, input, cashWithdrawMap);

        if (cashWithdrawMap.isEmpty()) {
            System.out.println("Something went wrong, unable to process cash");
            card.getBankAccount().addAmount(input);
            exit();
        }

        // Currency withdrawn from the ATM.
        int hundred = 0, fiveHundred = 0, twoThousand = 0;
        if (cashWithdrawMap.get(100) != null)
            hundred = cashWithdrawMap.get(100);
        if (cashWithdrawMap.get(500) != null)
            fiveHundred = cashWithdrawMap.get(500);
        if (cashWithdrawMap.get(2000) != null)
            twoThousand = cashWithdrawMap.get(2000);

        atmMachine.getAtmBalance().updateATMBalance(hundred, fiveHundred, twoThousand);

        atmMachine.setAtmState(new ShowBalance(card.getBankAccount().getBalance()));
    }
}
