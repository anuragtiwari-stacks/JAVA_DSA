package _3LinkedList._2METHOD;

import java.util.LinkedList;

public class _7RemoveFirstExample
{
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");

        String first = list.removeFirst();
        System.out.println("Removed first element: " + first);
        System.out.println("List after removeFirst: " + list);
    }
}


