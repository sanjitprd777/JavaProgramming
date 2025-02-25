package ATM.AtmWithdraw;

import ATM.AtmMachine;

import java.util.Map;

public class Hundred extends WithdrawProcessor {

    public Hundred(WithdrawProcessor withdrawProcessor) {
        super(withdrawProcessor);
    }

    public void withdrawCash(AtmMachine atmMachine, int amount, Map<Integer, Integer> cashWithdrawMap) {
        cashWithdrawMap.put(100, amount/100);
        super.withdrawCash(atmMachine, 0, cashWithdrawMap);
    }

}
