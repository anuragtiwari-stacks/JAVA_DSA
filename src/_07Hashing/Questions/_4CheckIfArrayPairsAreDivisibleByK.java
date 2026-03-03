/*
1497. Check If Array Pairs Are Divisible by k

Given an array arr of even length and an integer k,
check if array can be divided into pairs such that
sum of each pair is divisible by k.
*/

package _07Hashing.Questions;

import java.util.HashMap;

public class _4CheckIfArrayPairsAreDivisibleByK
{
    public static boolean canArrange(int[] arr, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count remainder frequencies
        for (int num : arr)
        {
            int rem = num % k;

            if (map.containsKey(rem))
            {
                map.put(rem, map.get(rem) + 1);
            }
            else
            {
                map.put(rem, 1);
            }
        }

        // Step 2: Check pairing conditions
        for (int rem : map.keySet())
        {
            // Case 1: remainder 0
            if (rem == 0)
            {
                if (map.get(rem) % 2 != 0)
                {
                    return false;
                }
            }
            // Case 2: remainder k/2 (only when k is even)
            else if (k % 2 == 0 && rem == k / 2)
            {
                if (map.get(rem) % 2 != 0)
                {
                    return false;
                }
            }
            // Case 3: general case
            else
            {
                int need = k - rem;

                if (!map.containsKey(need) || map.get(rem) != map.get(need))
                {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        int k = 5;

        System.out.println(canArrange(arr, k));
    }
}

/*
==================== SIMPLE DRY RUN ====================

Input:
arr = [1,2,3,4,5,10,6,7,8,9]
k = 5

----------------------------------------------------
Step 1: Remainders (num % k)

1 % 5 = 1
2 % 5 = 2
3 % 5 = 3
4 % 5 = 4
5 % 5 = 0
10 % 5 = 0
6 % 5 = 1
7 % 5 = 2
8 % 5 = 3
9 % 5 = 4

map = {
0=2,
1=2,
2=2,
3=2,
4=2
}

----------------------------------------------------
Step 2: Check pairing

rem = 0 → count = 2 (even) ✅

rem = 1 → need = 4
count(1) = 2, count(4) = 2 ✅

rem = 2 → need = 3
count(2) = 2, count(3) = 2 ✅

All conditions satisfied.

----------------------------------------------------
Final Answer:
true
====================================================
*/
