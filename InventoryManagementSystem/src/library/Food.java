package library;

public class Food extends Product {
    // Additional Attribute
    String expirationDate;

    // Constructor
    public Food(String name, double price, int quantity, String expirationDate) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }

    // Overriding displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo();  // Call the displayInfo() from Product class
        System.out.println("Expiration Date: " + expirationDate);
    }
}

