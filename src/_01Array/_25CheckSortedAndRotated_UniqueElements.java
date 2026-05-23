package _01Array;

import java.util.Arrays;

// LeetCode 1752 - Check if Array Is Sorted and Rotated
// Works correctly for UNIQUE elements only

public class _25CheckSortedAndRotated_UniqueElements
{
    public static boolean check(int[] nums)
    {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int n = nums.length;

        // find starting index
        int index = -1;

        for (int j = 0; j < n; j++)
        {
            if (nums[0] == sorted[j])
            {
                index = j;
                break;
            }
        }

        // compare circularly
        for (int i = 0; i < n; i++)
        {
            if (nums[i] != sorted[index])
            {
                return false;
            }

            index++;

            // circular move
            if (index == n)
            {
                index = 0;
            }
        }

        return true;
    }

    public static void main(String[] args)
    {
        int[] nums = {3, 4, 5, 1, 2};

        System.out.println(check(nums));
    }
}