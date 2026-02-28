package _03LinkedList._2METHOD;

import java.util.LinkedList;

public class _19PollExample
{
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // poll(): Retrieves and removes the first element of the list (same as pollFirst())
        System.out.println("poll(): " + list.poll());

        // pollFirst(): Explicitly retrieves and removes the first element of the list
        System.out.println("pollFirst(): " + list.pollFirst());

        // pollLast(): Retrieves and removes the last element of the list
        System.out.println("pollLast(): " + list.pollLast());

        // Final state of the list after all poll operations
        System.out.println("List after polls: " + list);
    }
}
