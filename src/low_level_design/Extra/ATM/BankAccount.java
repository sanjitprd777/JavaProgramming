package ATM;

public class BankAccount {
    String accountType;
    Double balance;

    BankAccount(String accountType, Double balance) {
        this.accountType = accountType;
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void deductAmount(int amount) {
        this.balance = this.balance - amount;
    }

    public void addAmount(int amount) {
        this.balance = this.balance + amount;
    }
}
