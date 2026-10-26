import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class StudentMarksManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> marks = new ArrayList<>();
        
        System.out.println("Enter marks (type -1 to stop):");
        while (true) {
            double mark = sc.nextDouble();
            if (mark == -1) break;
            marks.add(mark); // Automatically increases size
        }
        
        if (marks.isEmpty()) {
            System.out.println("No marks entered.");
            return;
        }

        System.out.println("\nMarks: " + marks);
        
        double max = Collections.max(marks);
        System.out.println("Highest Mark: " + max);
        
        double sum = 0;
        for (double m : marks) {
            sum += m;
        }
        System.out.println("Average Mark: " + (sum / marks.size()));
        
        sc.close();
    }
}
