//open close principle
// it means open for extension but close for modification, so if we
// add data in file also we make a interface invoiceSave, and we implement it whenever
// we need to extend our functionality such that existing class functionality
// remains same and does not get any error at runtime

class Marker {
    private String name;
    private String color;
    private int year;
    private int price;

    public Marker(String name, String color, int year, int price) {
        this.name = name;
        this.color = color;
        this.year = year;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }
}

class Invoice {
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal() {
        return marker.getPrice() * quantity;
    }

    public Marker getMarker() {
        return marker;
    }

    public int getQuantity() {
        return quantity;
    }
}

class InvoicePrinter {
    public void printInvoice(Invoice invoice) {
        Marker marker = invoice.getMarker();
        System.out.println("Marker: " + marker.getName() + ", Color: " + marker.getColor() +
                ", Year: " + marker.getYear() + ", Quantity: " + invoice.getQuantity() +
                ", Total Price: " + invoice.calculateTotal());
    }
}

// Step 1: Create an interface for saving the invoice
interface invoiceSaver{
    public void save(Invoice invoice);
}

// Step 2: Implement saving to database
class InvoiceDatabaseSaver implements invoiceSaver{
    public void save(Invoice invoice)
    {
        System.out.println("saving to DataBase...");
    }
}

// Step 3: Implement saving to a file

class InvoiceFileSaver implements invoiceSaver {
    @Override
    public void save(Invoice invoice) {
        System.out.println("Saving invoice to a file...");

    }
}
public class Main {
    public static void main(String[] args) {
        Marker marker = new Marker("Sharpie", "Blue", 2023, 10);
        Invoice invoice = new Invoice(marker, 5);

        InvoicePrinter printer = new InvoicePrinter();
        printer.printInvoice(invoice);

        // Using database saver
         invoiceSaver dbSave=new InvoiceDatabaseSaver();
         dbSave.save(invoice);

        // Using file saver
        invoiceSaver fileSave=new InvoiceFileSaver();
        fileSave.save(invoice);
    }
}
