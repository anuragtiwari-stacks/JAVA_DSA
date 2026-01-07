package COMPARATOR;

import java.util.*;

class Student
{
    String name;
    int marks;

    Student(String name, int marks)
    {
        this.name = name;
        this.marks = marks;
    }

    public String toString()
    {
        return name + " (" + marks + ")";
    }
}

public class _3SortStudentByMarks
{
    public static void main(String[] args)
    {
        List<Student> students = Arrays.asList
                (
                        new Student("Alice", 85),
                        new Student("Bob", 92),
                        new Student("Charlie", 78)
                );

        // Ascending by marks
        students.sort(new Comparator<Student>()
        {
            public int compare(Student s1, Student s2)
            {
                return s1.marks - s2.marks;
            }
        });
        System.out.println("By Marks (Ascending): " + students);

        // Descending by marks
        students.sort(new Comparator<Student>()
        {
            public int compare(Student s1, Student s2)
            {
                return s2.marks - s1.marks;
            }
        });
        System.out.println("By Marks (Descending): " + students);
    }
}
