package _11Sorting._2QUESTIONS;

import java.util.*;

/*
    🔎 What is Set Mismatch?
    ---------------------------------
    You're given an array nums of length n where numbers are from 1 to n.
    - One number is duplicated.
    - One number is missing.

    Goal:
    Find and return both numbers as an array: [duplicate, missing].
*/

public class _5SetMismatch
{

    public static int[] findErrorNums(int[] nums)
    {
        int i = 0;

        while (i < nums.length)
        {
            int correct = nums[i] - 1;

            if (nums[i] != nums[correct])
            {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
            else
            {
                i++;
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int index = 0; index < nums.length; index++)
        {
            if (nums[index] != index + 1)
            {
                result.add(nums[index]);     // duplicate
                result.add(index + 1);       // missing
                break;
            }
        }

        return new int[] {result.get(0), result.get(1)};
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 2, 4};
        int[] result = findErrorNums(arr);
        System.out.println("Duplicate and missing: " + Arrays.toString(result));
    }

    /*
        🔍 Dry Run: arr = {1, 2, 2, 4}

        Cyclic sort complete: [1, 2, 2, 4]

        Loop through:
        index 0 → nums[0] == 1 ✅
        index 1 → nums[1] == 2 ✅
        index 2 → nums[2] != 3 ❌ → duplicate = 2, missing = 3

        ✅ Output: [2, 3]
    */
}


    /*
        🔍 Dry Run: arr = {1, 2, 2, 4}

        After cyclic sort:
        Array becomes: [1, 2, 2, 4]

        Now scan:
        index 2 → nums[2] = 2 ❌ → duplicate = 2, missing = 3

        ✅ Output: [2, 3]
    */

