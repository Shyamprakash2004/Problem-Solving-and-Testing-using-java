import java.util.*;
import java.util.function.*;

public class JavaLambdaExpressions {
    public static void main(String[] args) {
        // Example 1: Lambda with two integers
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("Addition: " + add.apply(10, 20));

        // Example 2: Sort using a lambda
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 3));
        numbers.sort((a, b) -> a - b);
        System.out.println("Sorted: " + numbers);

        // Example 3: Filter using a lambda
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.println("Even: " + n));
    }
}
