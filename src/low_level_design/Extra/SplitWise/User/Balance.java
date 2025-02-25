package SplitWise.User;

public class Balance {

    double amount;
    BalanceType balanceType;

    public Balance(double amount, BalanceType balanceType) {
        this.amount = amount;
        this.balanceType = balanceType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public BalanceType getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(BalanceType balanceType) {
        this.balanceType = balanceType;
    }
}
