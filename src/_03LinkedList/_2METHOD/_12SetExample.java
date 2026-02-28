package _03LinkedList._2METHOD;

import java.util.LinkedList;

public class _12SetExample
{
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");

        list.set(1, "Mango");
        System.out.println("List after set: " + list);
    }
}

