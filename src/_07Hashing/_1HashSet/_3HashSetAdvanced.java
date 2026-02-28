package _07Hashing._1HashSet;

import java.util.HashSet;

public class _3HashSetAdvanced
{
    public static void main(String[] args)
    {
        // Create two HashSet objects
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        // Add elements to set1
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(10);

        // Add elements to set2
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(20);

        // Display the original sets
        System.out.println("Set1: " + set1);  // Output: [1, 2, 3]
        System.out.println("Set2: " + set2);  // Output: [2, 3, 4]

        // ---------- Union Operation ----------
        // Create a copy of set1 and add all elements of set2
        HashSet<Integer> s1 = new HashSet<>(set1);
        s1.addAll(set2);  // Now s1 contains all unique elements from both sets
        System.out.println("Union: " + s1);   // Output: [1, 2, 3, 4]

        // ---------- Intersection Operation ----------
        // Create a copy of set1 and retain only elements also present in set2
        HashSet<Integer> s2 = new HashSet<>(set1);
        s2.retainAll(set2);  // Now s2 contains common elements
        System.out.println("Intersection: " + s2);  // Output: [2, 3]

        // ---------- Difference Operation ----------
        // Create a copy of set1 and remove all elements present in set2
        HashSet<Integer> s3 = new HashSet<>(set1);
        s3.removeAll(set2);  // Now s3 contains elements only in set1 but not in set2
        System.out.println("Difference (set1 - set2): " + s3);  // Output: [1]

        // ---------- Difference Operation ----------
        // Create a copy of set2 and remove all elements present in set1
        HashSet<Integer> s4 = new HashSet<>(set2);
        s4.removeAll(set1);  // Now s2 contains elements only in set2 but not in set1
        System.out.println("Difference (set2 - set1): " + s4);  // Output: [4,20]
    }
}
