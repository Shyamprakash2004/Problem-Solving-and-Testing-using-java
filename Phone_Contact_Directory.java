import java.util.HashMap;
import java.util.Scanner;

public class PhoneContactDirectory {
    public static void main(String[] args) {
        HashMap<String, String> contacts = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        
        // Sample Contacts
        contacts.put("Alice", "123-456-7890");
        contacts.put("Bob", "987-654-3210");
        
        System.out.println("1. Search Contact | 2. Update/Add Contact");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline
        
        if (choice == 1) {
            System.out.print("Enter name to search: ");
            String name = sc.nextLine();
            System.out.println("Phone: " + contacts.getOrDefault(name, "Contact not found."));
        } else if (choice == 2) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter new phone number: ");
            String phone = sc.nextLine();
            contacts.put(name, phone);
            System.out.println("Contact updated successfully.");
            System.out.println("Current Directory: " + contacts);
        }
        sc.close();
    }
}
