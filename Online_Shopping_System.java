import java.util.*;

class Product {
    int id;
    String name;
    public Product(int id, String name) { this.id = id; this.name = name; }
    public String toString() { return name + " (ID: " + id + ")"; }
}

class Order implements Comparable<Order> {
    int orderId;
    int priority; // Lower number = higher priority
    
    public Order(int orderId, int priority) {
        this.orderId = orderId;
        this.priority = priority;
    }
    
    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.priority, other.priority);
    }
    public String toString() { return "Order ID: " + orderId + " [Priority: " + priority + "]"; }
}

public class OnlineShoppingSystem {
    public static void main(String[] args) {
        // Non-linear: HashMap for quick product search by ID
        Map<Integer, Product> catalog = new HashMap<>();
        catalog.put(101, new Product(101, "Laptop"));
        catalog.put(102, new Product(102, "Smartphone"));
        
        System.out.println("Search Product 101: " + catalog.get(101));

        // Linear (Priority-based): PriorityQueue for orders
        PriorityQueue<Order> orderQueue = new PriorityQueue<>();
        orderQueue.add(new Order(5002, 2)); // Standard shipping
        orderQueue.add(new Order(5001, 1)); // Express shipping
        
        System.out.println("\nProcessing Orders:");
        while (!orderQueue.isEmpty()) {
            System.out.println("Processing " + orderQueue.poll());
        }
    }
}
