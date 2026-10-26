import java.util.HashMap;
import java.util.Scanner;

public class StudentMarksMap {
    public static void main(String[] args) {
        HashMap<Integer, Integer> studentMarks = new HashMap<>();
        
        // Adding sample data (Roll Number, Marks)
        studentMarks.put(101, 88);
        studentMarks.put(102, 95);
        studentMarks.put(103, 76);
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student Roll Number to fetch marks: ");
        int rollNo = sc.nextInt();
        
        if (studentMarks.containsKey(rollNo)) {
            System.out.println("Marks for Roll No " + rollNo + ": " + studentMarks.get(rollNo));
        } else {
            System.out.println("Student record not found.");
        }
        sc.close();
    }
}
