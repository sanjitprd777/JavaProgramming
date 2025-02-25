package ATM.AtmWithdraw;

import ATM.AtmMachine;

import java.util.Map;

public class FiveHundred extends WithdrawProcessor {
    public FiveHundred(WithdrawProcessor withdrawProcessor) {
        super(withdrawProcessor);
    }

    public void withdrawCash(AtmMachine atmMachine, int amount, Map<Integer, Integer> cashWithdrawMap) {
        int noteCount = atmMachine.getAtmBalance().getFiveHundreds();
        int reqNote = amount/500;
        if (noteCount >= reqNote) {
            cashWithdrawMap.put(500, amount/500);
            super.withdrawCash(atmMachine, amount%500, cashWithdrawMap);
        }
        else {
            amount = amount - noteCount*500;
            cashWithdrawMap.put(500, noteCount);
            super.withdrawCash(atmMachine, amount, cashWithdrawMap);
        }
    }
}
