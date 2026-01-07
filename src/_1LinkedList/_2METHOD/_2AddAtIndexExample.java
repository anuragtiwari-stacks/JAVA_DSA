package _1LinkedList._2METHOD;

import java.util.LinkedList;

public class _2AddAtIndexExample
{
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<>();

        list.add("Apple");
        list.add("Cherry");

        list.add(1, "Banana");  // Insert "Banana" at index 1

        System.out.println("List after insertion at index 1: " + list);
    }
}

