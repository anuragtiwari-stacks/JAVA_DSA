package _3LinkedList._2METHOD;

import java.util.LinkedList;

public class _11GetLastExample
{
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");

        String last = list.getLast();
        System.out.println("Last element: " + last);
    }
}
