package COMPARATOR;

import java.util.*;

public class _1AscendingDescendingLambda
{
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 7);

        // Ascending
        numbers.sort((a, b) -> a - b);
        System.out.println("Ascending: " + numbers);

        // Descending
        numbers.sort((a, b) -> b - a);
        System.out.println("Descending: " + numbers);
    }
}
