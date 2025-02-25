package single_responsibility.bad_code;


public class Main {
    public static void main(String[] args) {
        Marker marker = new Marker("Camlin", "Red", 10);
        int quantity = 20;

        Invoice invoice = new Invoice(marker, quantity);
        int totalCost = invoice.calculateTotal();

        invoice.printInvoice(totalCost);
    }
}
