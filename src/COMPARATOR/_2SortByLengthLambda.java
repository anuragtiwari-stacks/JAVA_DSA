package COMPARATOR;

import java.util.*;

public class _2SortByLengthLambda
{
    public static void main(String[] args)
    {
        List<String> words = Arrays.asList("apple", "kiwi", "banana", "cherry");

        // Ascending length
        words.sort((a, b) -> a.length() - b.length());
        System.out.println("By Length (Ascending): " + words);

        // Descending length
        words.sort((a, b) -> b.length() - a.length());
        System.out.println("By Length (Descending): " + words);
    }
}
