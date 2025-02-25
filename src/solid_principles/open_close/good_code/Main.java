package open_close.good_code;

public class Main {
    public static void main(String[] args) {
        Marker marker = new Marker("Camlin", "Red", 10);
        int quantity = 10;

        InvoiceWithoutGST invoiceWithoutGST = new InvoiceWithoutGST();
        double totalCost = invoiceWithoutGST.invoiceCalculate(marker, quantity);
        InvoicePrinter invoicePrinter = new InvoicePrinter(marker, quantity, totalCost);
        invoicePrinter.printInvoice();

        InvoiceWithGST invoiceWithGST = new InvoiceWithGST();
        double totalGSTCost = invoiceWithGST.invoiceCalculate(marker, quantity);
        InvoicePrinter invoicePrinterGST = new InvoicePrinter(marker, quantity, totalGSTCost);
        invoicePrinterGST.printInvoice();
    }
}
