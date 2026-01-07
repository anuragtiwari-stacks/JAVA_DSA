package _1LinkedList._4LinkedHashSet;


import java.util.LinkedHashSet;
import java.util.Iterator;

public class _1LinkedHashSetDemo
{
    public static void main(String[] args)
    {
        LinkedHashSet<String> linkedSet = new LinkedHashSet<>();

        // Add elements (duplicates ignored)
        linkedSet.add("Apple");
        linkedSet.add("Banana");
        linkedSet.add("Cherry");
        linkedSet.add("Banana"); // Duplicate ignored
        linkedSet.add(null);     // One null allowed

        System.out.println("LinkedHashSet Elements:");
        printSet(linkedSet);

        // Size of the set
        System.out.println("Size: " + linkedSet.size());

        // Check if element exists
        System.out.println("Contains 'Apple'? " + linkedSet.contains("Apple"));
        System.out.println("Contains 'Mango'? " + linkedSet.contains("Mango"));

        // Remove an element
        linkedSet.remove("Banana");
        System.out.println("After removing 'Banana':");
        printSet(linkedSet);

        // Check if empty
        System.out.println("Is empty? " + linkedSet.isEmpty());

        // Clear the set
        linkedSet.clear();
        System.out.println("After clearing, is empty? " + linkedSet.isEmpty());
    }

    // Method to print set elements using Iterator
    public static <T> void printSet(LinkedHashSet<T> set)
    {
        Iterator<T> iterator = set.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
}
