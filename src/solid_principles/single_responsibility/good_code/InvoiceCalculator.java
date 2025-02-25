package single_responsibility.good_code;

public class InvoiceCalculator {
    private final Marker marker;
    private final int quantity;

    public InvoiceCalculator(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal() {
        return ((marker.price) * this.quantity);
    }

    // No other methods.

    /*  Say we want to change price calculation logic and introduce GST, then we have 1 reason to change.  */
}
