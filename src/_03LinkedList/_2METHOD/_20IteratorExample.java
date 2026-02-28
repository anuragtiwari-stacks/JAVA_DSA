package _03LinkedList._2METHOD;

import java.util.Iterator;
import java.util.LinkedList;

public class _20IteratorExample
{
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Create an iterator to traverse the LinkedList
        Iterator<String> it = list.iterator();

        System.out.print("Elements using iterator: ");

        // Iterate through the list using hasNext() and next()
        while (it.hasNext())
        {
            // next(): returns the next element in the iteration
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}
/*
🔍 Summary:
iterator() gives an Iterator to traverse the list.
hasNext() checks if there are more elements.
next() returns the next element in the list.
*/