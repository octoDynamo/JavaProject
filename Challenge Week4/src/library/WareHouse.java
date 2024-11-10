package library;

import java.util.*;

public class WareHouse {
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
    public Product lookupProduct(int id) {
        return productMap.get(id);
    }

    // Sort products by name and return the sorted list
    public List<Product> getSortedProductsByName() {
        productList.sort(Comparator.comparing(Product::getName));
        return new ArrayList<>(productList); // Return a copy for encapsulation
    }

    // Record daily shipment of product IDs
    public void recordDailyShipment(List<Integer> shipmentProductIds) {
        dailyShipments.clear();
        dailyShipments.addAll(shipmentProductIds);
    }

    // Get all product IDs from daily shipments in order
    public List<Integer> getDailyShipments() {
        return new ArrayList<>(dailyShipments); // Return a copy for encapsulation
    }
}
