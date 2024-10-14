import library.*;

public class Test {
    public static void main(String[] args) {
        // Display welcome message
        Product.welcomeMessage();

        // Create product instances
        Electronics laptop = new Electronics("Laptop", 1200, 10, "Dell", 2);
        Food apple = new Food("Apple", 1.2, 50, "2024-12-31");

        // Display product information
        System.out.println("\n--- Electronics ---");
        laptop.displayInfo();

        System.out.println("\n--- Food ---");
        apple.displayInfo();

        // Update product quantity
        System.out.println("\nUpdating quantities...");
        laptop.updateQuantity(15);
        apple.updateQuantity(30, true);  // Add to existing quantity

        // Display updated information
        System.out.println("\n--- Updated Electronics ---");
        laptop.displayInfo();

        System.out.println("\n--- Updated Food ---");
        apple.displayInfo();
    }
}
