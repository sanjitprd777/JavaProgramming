package ATM;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("Saving", 9999.0);
        Card card = new Card("4444444444444444", 123, "12/20", bankAccount, "Debit", 1234);
        User user = new User("Sahil", card);

        ATMRoom atmRoom = new ATMRoom();

        AtmBalance atmBalance = new AtmBalance(10, 10, 10);
        AtmMachine atmMachine = new AtmMachine();
        atmMachine.setAtmBalance(atmBalance);

        atmRoom.setAtmMachine(atmMachine);
        atmRoom.setUser(user);

        System.out.println("ATM current balance: " + atmMachine.getAtmBalance().totalAmount);

        atmRoom.atmMachine.atmState.printState();
        atmRoom.atmMachine.atmState.insertCard(card);

        atmRoom.atmMachine.atmState.printState();
        atmRoom.atmMachine.atmState.authenticatePin(1234);

        atmRoom.atmMachine.atmState.printState();
        atmRoom.atmMachine.atmState.selectOperation(1);

        atmRoom.atmMachine.atmState.printState();
        atmRoom.atmMachine.atmState.cashWithdraw(9900);

        atmRoom.atmMachine.atmState.printState();
        atmRoom.atmMachine.atmState.displayBalance("YES");

        System.out.println("ATM current balance: " + atmMachine.getAtmBalance().totalAmount);
    }
}
