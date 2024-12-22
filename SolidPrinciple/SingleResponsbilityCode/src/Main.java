//This Code Follow Single Responsibility Principle
class Marker{
    private String name;
    private String Color;
    private int year;
    private int Price;

    Marker(String name,String Color,int year, int Price){
        this.name=name;
        this.Color=Color;
        this.year=year;
        this.Price=Price;
    }
    public String getName()
    {
        return name;
    }

    public String getColor()
    {
        return Color;
    }

    public int getYear(){
        return year;
    }

    public int getPrice()
    {
        return Price;
    }
}

class Invoice{
    private Marker marker;
    private int quantity;
    Invoice(Marker marker,int quantity){
      this.marker=marker;
      this.quantity=quantity;
    }

    public int calaculateTotal(){
        return quantity*marker.getPrice();
    }

    public Marker getMarker()
    {
        return marker;
    }

    public int getQuantity()
    {
        return quantity;
    }
}
class InvoicePrinter {
    public void printInvoice(Invoice invoice) {
        Marker marker = invoice.getMarker();
        System.out.println("Marker: " + marker.getName() + ", Color: " + marker.getColor() +
                ", Year: " + marker.getYear() + ", Quantity: " + invoice.getQuantity() +
                ", Total Price: " + invoice.calaculateTotal());
    }
}

class InvoiceRepository {
    public void saveToDB(Invoice invoice) {
        System.out.println("Saving invoice to the database...");
        // Here, you would add actual database code to save the invoice
    }
}

public class Main {
    public static void main(String[] args) {
        Marker marker=new Marker("Cello","red",2020,50);
        Invoice invoice=new Invoice(marker,5);

        InvoicePrinter invoicePrinter=new InvoicePrinter() ;
        invoicePrinter.printInvoice(invoice);

        InvoiceRepository invoiceRepository=new InvoiceRepository();
        invoiceRepository.saveToDB(invoice);



    }
}