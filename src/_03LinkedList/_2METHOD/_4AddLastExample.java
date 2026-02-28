package _03LinkedList._2METHOD;

import java.util.LinkedList;

public class _4AddLastExample
{
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<>();

        list.addLast("Apple");
        list.addLast("Banana");
        list.addLast("Cherry");

        System.out.println("List after adding last: " + list);
    }
}
