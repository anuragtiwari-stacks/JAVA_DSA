package _03LinkedList._2METHOD;

import java.util.LinkedList;

public class _5RemoveExample
{
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        String removed = list.remove();
        System.out.println("Removed element: " + removed);
        System.out.println("List after removal: " + list);
    }
}
