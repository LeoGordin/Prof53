package lesson14;

import java.awt.*;
import java.util.*;
import java.util.List;

public class University {
    public static void main(String[] args) {
        Student s1 = new Student("Max Kotkov", 2, "123");
        Student s2 = new Student("Nina Kopylova", 1, "12");
        Student s3 = new Student("Semen Dejnev", 5, "33");
        Student s4 = new Student("Petr Stolypin", 6, "44");

        Professor p1 = new Professor("Max Goldin", "physics",
                Arrays.asList(s1)
        );

        Professor p2 = new Professor("Alex Lomonosov", "math",
                Arrays.asList(s1, s2, s3)
        );

        Professor p3 = new Professor("Anna Pavlova", "ballet",
                Arrays.asList(s2, s4)
        );

        Comparator<Professor> professorComparator = new Comparator<Professor>() {
            @Override
            public int compare(Professor o1, Professor o2) {
                return Integer.compare(o1.getStudents().size(), o2.getStudents().size());
            }
        };

        List<Professor> professors = new ArrayList<>(Arrays.asList(p1, p2, p3));
        Collections.sort(professors, professorComparator);

        System.out.println(professors);

        Comparator<Student> oldestStudentComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getYear(), o2.getYear());
            }
        };

        Comparator<Student> yearsComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getYear(), o2.getYear());
            }
        };

        Comparator<Professor> maxStudentYears = new Comparator<Professor>() {
            @Override
            public int compare(Professor o1, Professor o2) {
                int maxYears1 = Collections.max(o1.getStudents(), yearsComparator).getYear();
                int maxYears2 = Collections.max(o2.getStudents(), yearsComparator).getYear();

                return Integer.compare(
                        maxYears1,
                        maxYears2
                );
            }
        };
        Collections.sort(professors, maxStudentYears);
        System.out.println(professors);


    }
}
