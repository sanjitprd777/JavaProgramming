package ATM.AtmWithdraw;

import ATM.AtmMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract  class WithdrawProcessor {

    WithdrawProcessor withdrawProcessor;

    public WithdrawProcessor(WithdrawProcessor withdrawProcessor) {
        this.withdrawProcessor = withdrawProcessor;
    }

    public void withdrawCash(AtmMachine atmMachine, int amount, Map<Integer, Integer> cashWithdrawMap) {
        if (withdrawProcessor != null && amount > 0) {
            withdrawProcessor.withdrawCash(atmMachine, amount, cashWithdrawMap);
        }
        else {
            System.out.println("Please collect the cash");
        }
    }
}
