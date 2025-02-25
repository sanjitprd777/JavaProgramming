package open_close.good_code;

public class InvoiceWithoutGST implements Invoice {
    // Note: It is not necessary to put @Override before abstract method.
    // Java takes care of it. It is called syntactic-sugar.
    public double invoiceCalculate(Marker marker, int quantity) {
        return ((marker.price) * quantity);
    }
}
