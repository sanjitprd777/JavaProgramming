package CarRental;

public class Payment {
    Bill bill;

    Payment(Bill bill) {
        this.bill = bill;
    }

    public void payBill() {
        // do payment and update bill details.
        System.out.println("Payment of amount: " + bill.amount + " is completed.");
        bill.isPaid = true;
    }

    // Can go further down to cash/online payment.
}
