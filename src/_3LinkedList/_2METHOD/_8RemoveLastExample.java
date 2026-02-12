package _3LinkedList._2METHOD;

import java.util.LinkedList;

public class _8RemoveLastExample
{
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");

        String last = list.removeLast();
        System.out.println("Removed last element: " + last);
        System.out.println("List after removeLast: " + list);
    }
}
