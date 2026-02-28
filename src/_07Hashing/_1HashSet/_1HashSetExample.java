package _07Hashing._1HashSet;

import java.util.HashSet;

public class _1HashSetExample
{
    public static void main(String[] args)
    {
        HashSet<String> fruits = new HashSet<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Apple"); // Duplicate, will not be added

        System.out.println("Fruits Set:");
        for (String fruit : fruits)
        {
            System.out.println(fruit);
        }

        System.out.println("Contains Mango? " + fruits.contains("Mango"));
        System.out.println("Size: " + fruits.size());
    }
}

