import library.Product;
import library.WareHouse;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // Initialize the WarehouseInventory
        WareHouse inventory = new WareHouse();

        // Test adding products to the inventory
        testAddProduct(inventory);

        // Test looking up a product by ID
        testLookupProduct(inventory);

        // Test sorting products by name
        testSortAndPrintProductsByName(inventory);

        // Test recording a daily shipment
        testRecordDailyShipment(inventory);

        // Test printing daily shipments in order of arrival
        testPrintDailyShipments(inventory);
    }

    // Method to test adding products to the inventory
    private static void testAddProduct(WareHouse inventory) {
        System.out.println("\n--- Testing addProduct ---");
        inventory.addProduct(1, "Apple", 50);
        inventory.addProduct(2, "Banana", 30);
        inventory.addProduct(3, "Cherry", 20);
        inventory.addProduct(1, "Duplicate Apple", 10); // Testing duplicate ID
    }

    // Method to test looking up a product by ID
    private static void testLookupProduct(WareHouse inventory) {
        System.out.println("\n--- Testing lookupProduct ---");
        Product product = inventory.lookupProduct(2);
        if (product != null) {
            System.out.println("Found product: " + product);
        } else {
            System.out.println("Product with ID 2 not found.");
        }

        // Trying to look up a non-existing product ID
        Product missingProduct = inventory.lookupProduct(99);
        if (missingProduct == null) {
            System.out.println("Product with ID 99 not found.");
        }
    }

    // Method to test sorting products by name
    private static void testSortAndPrintProductsByName(WareHouse inventory) {
        System.out.println("\n--- Testing sortAndPrintProductsByName ---");
        List<Product> sortedProducts = inventory.getSortedProductsByName();
        System.out.println("Products sorted by name:");
        for (Product product : sortedProducts) {
            System.out.println(product);
        }
    }

    // Method to test recording a daily shipment
    private static void testRecordDailyShipment(WareHouse inventory) {
        System.out.println("\n--- Testing recordDailyShipment ---");
        List<Integer> shipmentProductIds = Arrays.asList(1, 3, 2);
        inventory.recordDailyShipment(shipmentProductIds);
        System.out.println("Shipment recorded with product IDs: " + shipmentProductIds);
    }

    // Method to test printing daily shipments in order of arrival
    private static void testPrintDailyShipments(WareHouse inventory) {
        System.out.println("\n--- Testing printDailyShipments ---");
        List<Integer> dailyShipments = inventory.getDailyShipments();
        System.out.println("Daily shipments in order of arrival:");
        for (int productId : dailyShipments) {
            System.out.println("Product ID: " + productId);
        }
    }
}
