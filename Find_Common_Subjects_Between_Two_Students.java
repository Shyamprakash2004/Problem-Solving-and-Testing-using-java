import java.util.HashSet;
import java.util.Set;

public class CommonSubjects {
    public static void main(String[] args) {
        Set<String> student1Subjects = new HashSet<>();
        student1Subjects.add("Math");
        student1Subjects.add("Physics");
        student1Subjects.add("Chemistry");
        
        Set<String> student2Subjects = new HashSet<>();
        student2Subjects.add("Biology");
        student2Subjects.add("Chemistry");
        student2Subjects.add("Math");
        
        // Find common subjects
        student1Subjects.retainAll(student2Subjects);
        
        System.out.println("Common Subjects selected by both students: ");
        System.out.println(student1Subjects);
    }
}
