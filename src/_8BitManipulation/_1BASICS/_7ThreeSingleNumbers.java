/*
To extend your current XOR-based logic to handle three unique numbers
(with all other elements appearing exactly twice),
we cannot directly use XOR the way we do for one or two uniques —
because XOR is associative and cancels out pairs, but doesn’t help isolate three values.

So, we need to adapt the approach, but still keep the same format you're using.
*/
package _8BitManipulation._1BASICS;

import java.util.*;

public class _7ThreeSingleNumbers
{
    public static void main(String[] args)
    {
        int[] arr = {2, 4, 6, 2, 5, 4, 9, 5, 11};

        /*
            ✅ Concept:

            In this array, all numbers appear twice except for **three unique numbers**.

            XOR trick works only for 1 or 2 unique numbers, not 3 or more.
            So we use a frequency map to count how many times each number occurs.

            Finally, we return the numbers that occur only once.

            ✅ Time: O(n)
            ✅ Space: O(n)

            🧪 Dry Run:
            Input = {2, 4, 6, 2, 5, 4, 9, 5, 11}

            Frequencies:
            2 → 2 times
            4 → 2 times
            5 → 2 times
            6 → 1 time ✅
            9 → 1 time ✅
            11 → 1 time ✅

            ✅ Answer = [6, 9, 11]
         */

        System.out.println("Three unique numbers: " + Arrays.toString(findThreeSingles(arr)));
    }

    public static int[] findThreeSingles(int[] nums)
    {
        Map<Integer, Integer> freq = new HashMap<>();

        // Step 1: Count frequency of each number
        for (int num : nums)
        {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Collect all numbers that appeared only once
        List<Integer> result = new ArrayList<>();

        for (int key : freq.keySet())
        {
            if (freq.get(key) == 1)
            {
                result.add(key);
            }
        }

        // Step 3: Convert List to array
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
        {
            ans[i] = result.get(i);
        }

        return ans;
    }
}
