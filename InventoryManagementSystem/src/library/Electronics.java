package library;

public class Electronics extends Product {
    // Additional Attributes
    String brand;
    int warranty;

    // Constructor
    public Electronics(String name, double price, int quantity, String brand, int warranty) {
        super(name, price, quantity);
        this.brand = brand;
        this.warranty = warranty;
    }

    // Overriding displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo();  // Call the displayInfo() from Product class
        System.out.println("Brand: " + brand);
        System.out.println("Warranty: " + warranty + " years");
    }
}

