package ATM.AtmWithdraw;

import ATM.AtmMachine;

import java.util.Map;

public class TwoThousand extends WithdrawProcessor {
    public TwoThousand(WithdrawProcessor withdrawProcessor) {
        super(withdrawProcessor);
    }

    public void withdrawCash(AtmMachine atmMachine, int amount, Map<Integer, Integer> cashWithdrawMap) {
        int noteCount = atmMachine.getAtmBalance().getFiveHundreds();
        int reqNote = amount/2000;
        if (noteCount >= reqNote) {
            cashWithdrawMap.put(2000, amount/2000);
            super.withdrawCash(atmMachine, amount%2000, cashWithdrawMap);
        }
        else {
            amount = amount - noteCount*2000;
            cashWithdrawMap.put(2000, noteCount);
            super.withdrawCash(atmMachine, amount, cashWithdrawMap);
        }
    }
}
