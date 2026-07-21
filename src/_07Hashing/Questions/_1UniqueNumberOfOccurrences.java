package _07Hashing.Questions;

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

        // Step 1: Count frequency of each number (WITHOUT getOrDefault)
        for (int num : arr)
        {
            if (map.containsKey(num))
            {
                map.put(num, map.get(num) + 1);
            }
            else
            {
                map.put(num, 1);
            }

        }

        // Step 2: Check if frequencies are unique
        HashSet<Integer> set = new HashSet<>();

        for (int freq : map.keySet())
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
not present → put(1,1)
map = {1=1}

Read 2:
not present → put(2,1)
map = {1=1, 2=1}

Read 2:
present → increment
map = {1=1, 2=2}

Read 1:
present → increment
map = {1=2, 2=2}

Read 1:
present → increment
map = {1=3, 2=2}

Read 3:
not present → put(3,1)
map = {1=3, 2=2, 3=1}

----------------------------------------------------
Step 2: Check uniqueness using HashSet

map.values() = [3, 2, 1]

Start:
set = {}

freq = 3
not present → add
set = {3}

freq = 2
not present → add
set = {3, 2}

freq = 1
not present → add
set = {3, 2, 1}

No duplicate frequency found.

----------------------------------------------------
Final Output:
true
====================================================
*/