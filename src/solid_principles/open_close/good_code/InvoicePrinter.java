package open_close.good_code;

public class InvoicePrinter {
    private final Marker marker;
    private final int quantity;

    private final double totalAmount;

    public InvoicePrinter(Marker marker, int quantity, double totalAmount) {
        this.marker = marker;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    public void printInvoice() {
        // code to print invoice
        String message = "You purchased marker " + marker.name + " of color " + marker.color + " and quantity " +
                quantity + " which costs total amount " + totalAmount;
        System.out.println(message);
        System.out.println("Invoice printed!");
    }
}
