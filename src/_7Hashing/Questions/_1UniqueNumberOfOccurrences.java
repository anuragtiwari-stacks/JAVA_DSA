package _7Hashing.Questions;

/*
1207. Unique Number of Occurrences

Given an array of integers arr,
return true if the number of occurrences of each value is unique.
*/


import java.util.HashMap;
import java.util.HashSet;

public class _1UniqueNumberOfOccurrences
{
    public static boolean uniqueOccurrences(int[] arr)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequency of each number
        for (int num : arr)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Check if frequencies are unique
        HashSet<Integer> set = new HashSet<>();

        for (int freq : map.values())
        {
            if (set.contains(freq))
            {
                return false;
            }

            set.add(freq);
        }

        return true;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 2, 1, 1, 3};

        System.out.println(uniqueOccurrences(arr));
    }
}

/*
==================== FULL DRY RUN ====================

Input:
arr = [1, 2, 2, 1, 1, 3]

----------------------------------------------------
Step 1: Count Occurrences using HashMap

Start:
map = {}

Read 1:
map = {1=1}

Read 2:
map = {1=1, 2=1}

Read 2:
map = {1=1, 2=2}

Read 1:
map = {1=2, 2=2}

Read 1:
map = {1=3, 2=2}

Read 3:
map = {1=3, 2=2, 3=1}

----------------------------------------------------
Step 2: Check uniqueness of frequencies using HashSet

map.values() = [3, 2, 1]

Start:
set = {}

freq = 3
3 not in set → add
set = {3}

freq = 2
2 not in set → add
set = {3, 2}

freq = 1
1 not in set → add
set = {3, 2, 1}

No duplicate frequency found.

----------------------------------------------------
Final Answer:
true
====================================================
*/
