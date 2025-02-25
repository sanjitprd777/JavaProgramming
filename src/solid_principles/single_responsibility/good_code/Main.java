package single_responsibility.good_code;

public class Main {
    public static void main(String[] args) {
        Marker marker = new Marker("Camlin", "Red", 10);
        int quantity = 20;

        InvoiceCalculator invoiceCalculator = new InvoiceCalculator(marker, quantity);

        int totalCost = invoiceCalculator.calculateTotal();
        InvoicePrinter invoicePrinter = new InvoicePrinter(marker, quantity, totalCost);

        invoicePrinter.printInvoice();

    }
}
