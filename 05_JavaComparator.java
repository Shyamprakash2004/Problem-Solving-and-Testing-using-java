import java.util.*;

public class JavaComparator {
    static class Student {
        String name;
        int marks;

        Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }

        @Override
        public String toString() {
            return name + " " + marks;
        }
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Rahul", 85));
        list.add(new Student("Arun", 92));
        list.add(new Student("Bala", 85));

        list.sort((a, b) -> {
            if (a.marks != b.marks)
                return Integer.compare(b.marks, a.marks);
            return a.name.compareTo(b.name);
        });

        list.forEach(System.out::println);
    }
}
