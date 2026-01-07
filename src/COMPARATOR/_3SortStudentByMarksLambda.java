package COMPARATOR;

import java.util.*;

class StudentLambda
{
    String name;
    int marks;

    StudentLambda(String name, int marks)
    {
        this.name = name;
        this.marks = marks;
    }

    public String toString()
    {
        return name + " (" + marks + ")";
    }
}

public class _3SortStudentByMarksLambda
{
    public static void main(String[] args)
    {
        List<StudentLambda> students = Arrays.asList
                (
                        new StudentLambda("Alice", 85),
                        new StudentLambda("Bob", 92),
                        new StudentLambda("Charlie", 78)
                );

        // Ascending marks
        students.sort((s1, s2) -> s1.marks - s2.marks);
        System.out.println("By Marks (Ascending): " + students);

        // Descending marks
        students.sort((s1, s2) -> s2.marks - s1.marks);
        System.out.println("By Marks (Descending): " + students);
    }
}
