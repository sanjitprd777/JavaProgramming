package open_close.bad_code;

public class Main {
    public static void main(String[] args) {
        Marker marker = new Marker("Camlin", "Red", 10);
        int quantity = 10;

        InvoiceCalculator invoiceCalculator = new InvoiceCalculator(marker, quantity);

        int totalCost = invoiceCalculator.calculateTotal();
        InvoicePrinter invoicePrinter = new InvoicePrinter(marker, quantity, totalCost);
        invoicePrinter.printInvoice();

        double totalGSTCost = invoiceCalculator.calculateTotalWithGST();
        InvoicePrinter invoicePrinterGST = new InvoicePrinter(marker, quantity, totalGSTCost);
        invoicePrinterGST.printInvoice();
    }
}
