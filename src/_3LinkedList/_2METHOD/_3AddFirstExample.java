package _3LinkedList._2METHOD;

import java.util.LinkedList;

public class _3AddFirstExample
{
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<>();

        list.add("Banana");
        list.add("Cherry");

        list.addFirst("Apple");

        System.out.println("List after adding first: " + list);
    }
}

