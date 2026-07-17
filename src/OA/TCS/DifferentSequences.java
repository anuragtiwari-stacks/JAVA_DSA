package OA.TCS;

/*
 * Pure Brute Force Solution
 *
 * Generate every possible sequence of X operations.
 * Store every final sequence in HashSet.
 *
 * Time Complexity : O(N^X × N)
 * Space Complexity: O(Number of Unique Sequences)
 */

import java.util.Arrays;
import java.util.HashSet;

public class DifferentSequences
{
    static HashSet<String> set = new HashSet<>();

    public static void generate(int[] arr, int x)
    {
        // Base Case
        if(x == 0)
        {
            set.add(Arrays.toString(arr));
            return;
        }

        // Try flipping every index
        for(int i = 0; i < arr.length; i++)
        {
            // Flip
            arr[i] *= -1;

            generate(arr, x - 1);

            // Backtrack
            arr[i] *= -1;
        }
    }

    public static void main(String[] args)
    {
        // Predefined Input

        int[] arr = {1, 2, 3};

        int X = 2;

        generate(arr, X);

        System.out.println("Different Sequences = " + set.size());

        System.out.println();

        System.out.println("Sequences:");

        for(String s : set)
        {
            System.out.println(s);
        }
    }
}