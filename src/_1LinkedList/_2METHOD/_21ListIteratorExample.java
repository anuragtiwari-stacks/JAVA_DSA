package _1LinkedList._2METHOD;

import java.util.LinkedList;
import java.util.ListIterator;

public class _21ListIteratorExample
{
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Create a ListIterator for the list (allows forward and backward traversal)
        ListIterator<String> listIt = list.listIterator();

        System.out.print("Elements using listIterator: ");

        // Traverse the list in forward direction using hasNext() and next()
        while (listIt.hasNext())
        {
            // next(): returns the next element in the iteration
            System.out.print(listIt.next() + " ");
        }
        System.out.println();
    }
}
