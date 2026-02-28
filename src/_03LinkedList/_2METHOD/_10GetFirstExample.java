package _03LinkedList._2METHOD;

import java.util.LinkedList;

public class _10GetFirstExample
{
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");

        String first = list.getFirst();
        System.out.println("First element: " + first);
    }
}

