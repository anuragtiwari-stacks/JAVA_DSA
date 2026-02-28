package _03LinkedList._2METHOD;

import java.util.LinkedList;

public class _15ClearExample
{
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");

        list.clear();

        System.out.println("List after clear: " + list);
    }
}
