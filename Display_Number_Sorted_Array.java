import java.util.TreeSet;

public class SortedUniqueMarks {
    public static void main(String[] args) {
        int[] enteredMarks = {85, 92, 78, 85, 99, 78, 65, 92};
        
        TreeSet<Integer> uniqueSortedMarks = new TreeSet<>();
        for (int mark : enteredMarks) {
            uniqueSortedMarks.add(mark);
        }
        
        System.out.println("Unique marks in ascending order: ");
        System.out.println(uniqueSortedMarks);
    }
}
