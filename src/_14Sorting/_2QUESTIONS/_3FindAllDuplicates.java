package _14Sorting._2QUESTIONS;

import java.util.*;

public class _3FindAllDuplicates
{
    public static List<Integer> findDuplicates(int[] nums)
    {
        int i = 0;

        while (i < nums.length)
        {
            int correct = nums[i] - 1;

            if (nums[i] != nums[correct])
            {
                // swap nums[i] with nums[correct]
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
            else
            {
                i++;
            }
        }

        List<Integer> duplicates = new ArrayList<>();

        for (int index = 0; index < nums.length; index++)
        {
            if (nums[index] != index + 1)
            {
                duplicates.add(nums[index]);
            }
        }

        return duplicates;
    }

    public static void main(String[] args)
    {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = findDuplicates(arr);
        System.out.println("Duplicate numbers: " + result);
    }

    /*
        🔍 Dry Run: arr = {4, 3, 2, 7, 8, 2, 3, 1}

        After cyclic sort:
        Index:   0  1  2  3  4  5  6  7
        Array:  [1, 2, 3, 4, 3, 2, 7, 8]

        Now check:
        index 4 → value = 3 ❌ (duplicate)
        index 5 → value = 2 ❌ (duplicate)

        ✅ Output: [3, 2]
    */
}
