package _03LinkedList._2METHOD;

import java.util.LinkedList;

public class _6RemoveObjectExample
{
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Banana");

        list.remove("Banana");  // Removes first "Banana"
        System.out.println("List after removing 'Banana': " + list);
    }
}
