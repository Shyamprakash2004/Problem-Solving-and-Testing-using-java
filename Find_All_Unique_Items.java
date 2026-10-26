import java.util.LinkedHashSet;

public class UniqueItemsPurchased {
    public static void main(String[] args) {
        String[] purchases = {"Apple", "Milk", "Bread", "Apple", "Juice", "Milk"};
        
        LinkedHashSet<String> uniqueItems = new LinkedHashSet<>();
        for (String item : purchases) {
            uniqueItems.add(item);
        }
        
        System.out.println("Unique items in order of purchase: ");
        System.out.println(uniqueItems);
    }
}
