package ATM.AtmState;

public class ShowBalance extends ATMState {

    double balanceAmount;

    public ShowBalance(Double amount) {
        this.balanceAmount = amount;
    }

    public void printState() {
        System.out.println("ATM is in ShowBalance state");
        System.out.println("Select YES to show bank balance");
    }

    public void displayBalance(String input) {
        if ("YES".equals(input)) {
            System.out.println("You available bank balance is: " + balanceAmount);
        }
        exit();
    }
}
