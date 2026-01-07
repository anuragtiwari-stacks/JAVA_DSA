package _11Sorting._2QUESTIONS;

import java.util.*;

public class _6FirstMissingPositive_HashSet
{

    public static int firstMissingPositive(int[] nums)
    {
        Set<Integer> set = new HashSet<>();

        for (int num : nums)
        {
            if (num > 0)
            {
                set.add(num);
            }
        }

        for (int i = 1; i <= nums.length + 1; i++)
        {
            if (!set.contains(i))
            {
                return i;
            }
        }

        return -1; // fallback
    }

    public static void main(String[] args)
    {
        int[] arr = {3, 4, -1, 1};
        int result = firstMissingPositive(arr);
        System.out.println("First missing positive:" + result);
    }
}
