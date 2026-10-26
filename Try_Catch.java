import java.util.Scanner;
import java.util.InputMismatchException;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(x / y);
        } catch (InputMismatchException e) {
            // HackerRank expects this exact string for InputMismatch
            System.out.println("java.util.InputMismatchException");
        } catch (ArithmeticException e) {
            // HackerRank expects this exact string for / by zero
            System.out.println("java.lang.ArithmeticException: / by zero");
        }
        sc.close();
    }
}
