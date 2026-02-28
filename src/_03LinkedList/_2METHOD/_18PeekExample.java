package _03LinkedList._2METHOD;

import java.util.LinkedList;

public class _18PeekExample
{
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // peek(): Retrieves but does NOT remove the first element of the list
        System.out.println("peek(): " + list.peek());

        // peekFirst(): Same as peek(); retrieves but does NOT remove the first element
        System.out.println("peekFirst(): " + list.peekFirst());

        // peekLast(): Retrieves but does NOT remove the last element of the list
        System.out.println("peekLast(): " + list.peekLast());
    }
}
