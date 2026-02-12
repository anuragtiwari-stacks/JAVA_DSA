package _3LinkedList._2METHOD;

import java.util.Collections;
import java.util.LinkedList;

public class _23Reverse
{
    public static void main(String[] args)
    {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("Original List: " + list);

        // Reverse the linked list using Collections.reverse()
        Collections.reverse(list);

        System.out.println("Reversed List: " + list);
    }
}
