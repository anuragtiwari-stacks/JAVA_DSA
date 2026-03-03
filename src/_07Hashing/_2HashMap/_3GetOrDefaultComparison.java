package _07Hashing._2HashMap;

import java.util.HashMap;

public class _3GetOrDefaultComparison
{

    public static void main(String[] args)
    {

        // -------------------------------
        // Example 1: Using getOrDefault()
        // -------------------------------

        System.out.println("=== Using getOrDefault() ===");

        HashMap<Integer, String> map1 = new HashMap<>();

        map1.put(1, "Anurag");
        map1.put(2, "Rahul");

        String value1 = map1.getOrDefault(1, "Not Found");
        String value2 = map1.getOrDefault(5, "Not Found");

        System.out.println("Key 1: " + value1);
        // Output: Key 1: Anurag

        System.out.println("Key 5: " + value2);
        // Output: Key 5: Not Found


        // ---------------------------------------
        // Example 2: Without getOrDefault()
        // ---------------------------------------

        System.out.println("\n=== Without getOrDefault() ===");

        HashMap<Integer, String> map2 = new HashMap<>();

        map2.put(1, "Anurag");
        map2.put(2, "Rahul");

        String value3;
        String value4;

        if (map2.containsKey(1))
        {
            value3 = map2.get(1);
        }
        else
        {
            value3 = "Not Found";
        }

        if (map2.containsKey(5))
        {
            value4 = map2.get(5);
        }
        else
        {
            value4 = "Not Found";
        }

        System.out.println("Key 1: " + value3);
        // Output: Key 1: Anurag

        System.out.println("Key 5: " + value4);
        // Output: Key 5: Not Found

    }

}