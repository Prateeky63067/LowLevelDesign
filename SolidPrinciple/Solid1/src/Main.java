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

    public void printInvoice() {
        System.out.println("Marker: " + marker.getName() + ", Color: " + marker.getColor() +
                ", Year: " + marker.getYear() + ", Quantity: " + quantity +
                ", Total Price: " + calculateTotal());
    }

    public void saveToDB() {
        System.out.println("Saving invoice to the database...");
    }
}

public class Main {
    public static void main(String[] args) {
        Marker marker = new Marker("Sharpie", "Blue", 2023, 10);
        Invoice invoice = new Invoice(marker, 5);

        invoice.printInvoice();
        invoice.saveToDB();
    }
}

