package _03LinkedList._2METHOD;

import java.util.LinkedList;
import java.util.ListIterator;

public class _22ListIteratorBothDirections
{
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Create a ListIterator
        ListIterator<String> listIt = list.listIterator();

        // Forward traversal
        System.out.print("Forward traversal: ");
        while (listIt.hasNext())
        {
            System.out.print(listIt.next() + " ");
        }
        System.out.println();

        // Backward traversal
        System.out.print("Backward traversal: ");
        while (listIt.hasPrevious())
        {
            System.out.print(listIt.previous() + " ");
        }
        System.out.println();
    }
}

/*
| Iterator Type  | Forward Traversal | Backward Traversal |
| -------------- | ----------------- | ------------------ |
| `Iterator`     | Yes               | No                 |
| `ListIterator` | Yes               | Yes                |
*/
