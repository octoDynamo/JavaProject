import java.util.*;

class Product {
    int id;
    String name;
    int quantity;

    public Product(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product ID: " + id + ", Name: " + name + ", Quantity: " + quantity;
    }
}

class WarehouseInventory {
    private HashMap<Integer, Product> productMap = new HashMap<>();
    private ArrayList<Product> productList = new ArrayList<>();
    private ArrayList<Integer> dailyShipments = new ArrayList<>();

    // Add a new product to the inventory
    public void addProduct(int id, String name, int quantity) {
        if (!productMap.containsKey(id)) {
            Product newProduct = new Product(id, name, quantity);
            productMap.put(id, newProduct);
            productList.add(newProduct);
            System.out.println("Product added: " + newProduct);
        } else {
            System.out.println("Product ID " + id + " already exists.");
        }
    }

    // Look up a product by ID
    public void lookupProduct(int id) {
        Product product = productMap.get(id);
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Product with ID " + id + " not found.");
        }
    }

    // Sort products by name and print them
    public void sortAndPrintProductsByName() {
        productList.sort(Comparator.comparing(p -> p.name));
        System.out.println("Products sorted by name:");
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    // Record daily shipment of product IDs
    public void recordDailyShipment(List<Integer> shipmentProductIds) {
        dailyShipments.clear();
        dailyShipments.addAll(shipmentProductIds);
        System.out.println("Shipment recorded: " + dailyShipments);
    }

    // Print all product IDs from daily shipments in order
    public void printDailyShipments() {
        System.out.println("Daily shipments in order of arrival:");
        for (int productId : dailyShipments) {
            System.out.println("Product ID: " + productId);
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        WarehouseInventory inventory = new WarehouseInventory();

        // Adding products to inventory
        inventory.addProduct(1, "Apple", 50);
        inventory.addProduct(2, "Banana", 30);
        inventory.addProduct(3, "Cherry", 20);

        // Looking up a product by ID
        inventory.lookupProduct(2);

        // Sorting products by name and printing them
        inventory.sortAndPrintProductsByName();

        // Recording a daily shipment
        inventory.recordDailyShipment(Arrays.asList(1, 3, 2));

        // Printing daily shipment in order of arrival
        inventory.printDailyShipments();
    }
}
