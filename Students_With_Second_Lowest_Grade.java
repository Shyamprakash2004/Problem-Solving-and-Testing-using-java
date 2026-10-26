import java.util.*;

class Student {
    String name;
    double grade;
    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class SecondLowestGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();
        Set<Double> uniqueGrades = new TreeSet<>(); // TreeSet automatically sorts in ascending order
        
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            double grade = sc.nextDouble();
            students.add(new Student(name, grade));
            uniqueGrades.add(grade);
        }
        sc.close();
        
        // Convert Set to List to easily access the second lowest grade
        List<Double> sortedGrades = new ArrayList<>(uniqueGrades);
        if (sortedGrades.size() < 2) return;
        
        double secondLowest = sortedGrades.get(1);
        List<String> resultNames = new ArrayList<>();
        
        for (Student s : students) {
            if (s.grade == secondLowest) {
                resultNames.add(s.name);
            }
        }
        
        Collections.sort(resultNames);
        for (String name : resultNames) {
            System.out.println(name);
        }
    }
}
