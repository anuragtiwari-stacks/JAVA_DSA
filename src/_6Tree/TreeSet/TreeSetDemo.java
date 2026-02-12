package _6Tree.TreeSet;

import java.util.TreeSet;

public class TreeSetDemo
{
    public static void main(String[] args)
    {
        // Create a TreeSet of integers
        TreeSet<Integer> treeSet = new TreeSet<>();

        // Add elements
        treeSet.add(50);
        treeSet.add(10);
        treeSet.add(30);
        treeSet.add(40);
        treeSet.add(20);
        treeSet.add(10);  // Duplicate ignored

        System.out.println("TreeSet Elements (sorted): " + treeSet);
        // Output: [10, 20, 30, 40, 50]

        // Check if element exists
        System.out.println("Contains 30? " + treeSet.contains(30));  // true
        System.out.println("Contains 60? " + treeSet.contains(60));  // false

        // Get first and last elements
        System.out.println("First element: " + treeSet.first()); // 10
        System.out.println("Last element: " + treeSet.last());   // 50

        // Remove an element
        treeSet.remove(20);
        System.out.println("After removing 20: " + treeSet);

        // Size and empty check
        System.out.println("Size: " + treeSet.size());
        System.out.println("Is empty? " + treeSet.isEmpty());

        // Subsets
        System.out.println("HeadSet (less than 30): " + treeSet.headSet(30));
        System.out.println("TailSet (from 30): " + treeSet.tailSet(30));
        System.out.println("SubSet (20 to 40): " + treeSet.subSet(20, 40));
    }
}
