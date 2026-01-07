package _1LinkedList._2METHOD;

import java.util.LinkedList;

public class _13ContainsExample
{
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");

        boolean exists = list.contains("Banana");
        System.out.println("List contains 'Banana'? " + exists);
    }
}

