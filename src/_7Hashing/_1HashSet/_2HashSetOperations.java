package _7Hashing._1HashSet;

import java.util.HashSet;

public class _2HashSetOperations
{
    public static void main(String[] args)
    {
        HashSet<Integer> numbers = new HashSet<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println("Initial Set: " + numbers);

        numbers.remove(20);
        System.out.println("After removing 20: " + numbers);

        System.out.println("Is Empty? " + numbers.isEmpty());

        numbers.clear();
        System.out.println("After clear: " + numbers);
    }
}
