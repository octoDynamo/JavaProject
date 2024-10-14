package library;

public class Product {
    // Attributes
    String name;
    double price;
    int quantity;

    // Constructor
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Methods
    public void displayInfo() {
        System.out.println("Product Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
    }

    public void updateQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

    public void updateQuantity(int addedQuantity, boolean addToExisting) {
        if (addToExisting) {
            this.quantity += addedQuantity;
        } else {
            this.quantity = addedQuantity;
        }
    }

    public double getPrice() {
        return price;
    }

    public static void welcomeMessage() {
        System.out.println("Welcome to the Warehouse Inventory System!");
    }
}
