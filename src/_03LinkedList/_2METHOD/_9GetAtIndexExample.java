package _03LinkedList._2METHOD;

import java.util.LinkedList;

public class _9GetAtIndexExample
{
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        String element = list.get(1);
        System.out.println("Element at index 1: " + element);
    }
}

