package _5Queue._2QUESTIONS;

import java.util.*;

/*
QUESTION:
Sliding Window Maximum (Brute Force)

LOGIC:
1. Hume ek array aur window size k diya hota hai.
2. Har contiguous window of size k ka maximum element find karna hota hai.
3. Har window ke liye:
   - k elements ko traverse karo
   - maximum nikaal kar list me store karo
4. Sabhi windows ke maximum print karo.
*/

public class _4SlidingWindowMax_Bruteforce
{

    public static List<Integer> slidingWindowMax(int[] arr, int k)
    {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= arr.length - k; i++)
        {
            int max = arr[i];

            for (int j = i; j < i + k; j++)
            {
                if (arr[j] > max)
                {
                    max = arr[j];
                }
            }

            result.add(max);
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        List<Integer> res = slidingWindowMax(arr, k);

        System.out.print("Sliding Window Maximums: ");
        for (int val : res)
        {
            System.out.print(val + " ");
        }
    }
}

/*
========================
DRY RUN
========================

Array = [1, 3, -1, -3, 5, 3, 6, 7]
k = 3

Window 1: [1, 3, -1]
Maximum = 3

Window 2: [3, -1, -3]
Maximum = 3

Window 3: [-1, -3, 5]
Maximum = 5

Window 4: [-3, 5, 3]
Maximum = 5

Window 5: [5, 3, 6]
Maximum = 6

Window 6: [3, 6, 7]
Maximum = 7

FINAL OUTPUT:
3 3 5 5 6 7

========================
TIME COMPLEXITY: O(n * k)
SPACE COMPLEXITY: O(n)
========================
END
========================
*/
