package COMPARATOR;
import java.util.*;

public class _1AscendingDescending
{
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 7);

        // Ascending
        Collections.sort(numbers, new Comparator<Integer>()
        {
            public int compare(Integer a, Integer b)
            {
                return a - b;
            }
        });
        System.out.println("Ascending: " + numbers);

        // Descending
        Collections.sort(numbers, new Comparator<Integer>()
        {
            public int compare(Integer a, Integer b)
            {
                return b - a;
            }
        });
        System.out.println("Descending: " + numbers);
    }
}
