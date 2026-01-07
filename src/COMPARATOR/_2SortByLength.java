package COMPARATOR;

import java.util.*;

public class _2SortByLength
{
    public static void main(String[] args)
    {
        List<String> words = Arrays.asList("apple", "kiwi", "banana", "cherry");

        // Ascending length
        Collections.sort(words, new Comparator<String>()
        {
            public int compare(String a, String b)
            {
                return a.length() - b.length();
            }
        });
        System.out.println("By Length (Ascending): " + words);

        // Descending length
        Collections.sort(words, new Comparator<String>()
        {
            public int compare(String a, String b)
            {
                return b.length() - a.length();
            }
        });
        System.out.println("By Length (Descending): " + words);
    }
}
