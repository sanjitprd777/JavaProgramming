package open_close.good_code;

public class InvoiceWithGST implements Invoice {
    @Override
    public double invoiceCalculate(Marker marker, int quantity) {
        double price = ((marker.price) * quantity);
        double GST = 0.18;
        return (price + price*GST);
    }
}
