package single_responsibility.bad_code;

public class Invoice {
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal() {
        return ((marker.price) * this.quantity);
    }

    public void printInvoice(int totalAmount) {
        // code to print invoice
        String message = "You purchased marker " + marker.name + " of color " + marker.color + " and quantity " +
                quantity + " which costs total amount " + totalAmount;
        System.out.println(message);
        System.out.println("Invoice printed!");
    }

    // some other methods.

    /*
Problems:
1. Say we want to change price calculation logic and introduce GST, then we have 1 reason to change.
2. Say we want to change invoice printing logic, then we have 2 reason to changes.

But, SRP says we should have only 1 reason to change.
     */
}
