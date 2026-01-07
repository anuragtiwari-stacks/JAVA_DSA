package _1LinkedList._2METHOD;

import java.util.LinkedList;

public class _16IndexOfExample
{
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Banana");

        int index = list.indexOf("Banana");
        System.out.println("First index of 'Banana': " + index);
    }
}
