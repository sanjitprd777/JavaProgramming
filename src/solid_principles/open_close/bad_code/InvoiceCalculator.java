package open_close.bad_code;

public class InvoiceCalculator {
    private final Marker marker;
    private final int quantity;

    private final double GST = 0.18;

    public InvoiceCalculator(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal() {
        return ((marker.price) * this.quantity);
    }

    // Modifying existing class which is tested and in production.
    // This should be avoided.
    // We should extend the 'InvoiceCalculator' class to introduce new methods.
    public double calculateTotalWithGST() {
        double totalCost = calculateTotal();
        return totalCost + totalCost*GST;
    }
}
