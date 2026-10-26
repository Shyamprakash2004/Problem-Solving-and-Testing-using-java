import java.util.*;

public class JavaHashSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Java");
        set.add("Python");
        set.add("Java"); // duplicate ignored
        set.add("C++");

        System.out.println("Set: " + set);
        System.out.println("Contains Java? " + set.contains("Java"));
        System.out.println("Size: " + set.size());

        set.remove("Python");
        System.out.println("After removal: " + set);
    }
}
