package _1LinkedList._2METHOD;

import java.util.LinkedList;

public class _17LastIndexOfExample
{
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Banana");

        int index = list.lastIndexOf("Banana");
        System.out.println("Last index of 'Banana': " + index);
    }
}
