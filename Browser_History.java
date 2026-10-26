import java.util.Stack;

public class BrowserHistory {
    public static void main(String[] args) {
        Stack<String> history = new Stack<>();
        
        // Visiting pages
        history.push("google.com");
        history.push("github.com");
        history.push("stackoverflow.com");
        
        System.out.println("Current History: " + history);
        
        // Pressing Back Button
        if (!history.isEmpty()) {
            System.out.println("Pressing Back Button...");
            String removedPage = history.pop();
            System.out.println("Removed Page: " + removedPage);
        }
        
        System.out.println("Current Page: " + history.peek());
    }
}
