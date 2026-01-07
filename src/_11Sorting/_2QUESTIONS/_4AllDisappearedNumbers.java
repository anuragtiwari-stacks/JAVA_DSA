package _11Sorting._2QUESTIONS;

import java.util.*;

public class _4AllDisappearedNumbers
{
    public static List<Integer> findDisappearedNumbers(int[] nums)
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

        List<Integer> result = new ArrayList<>();

        for (int index = 0; index < nums.length; index++)
        {
            if (nums[index] != index + 1)
            {
                result.add(index + 1);
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> missing = findDisappearedNumbers(arr);
        System.out.println("Disappeared numbers: " + missing);
    }

    /*
        🔍 Dry Run: arr = {4, 3, 2, 7, 8, 2, 3, 1}

        After cyclic sort:
        Index:   0  1  2  3  4  5  6  7
        Array:  [1, 2, 3, 4, 3, 2, 7, 8]

        Now check:
        index 4 → value = 3 ❌ → missing = 5
        index 5 → value = 2 ❌ → missing = 6

        ✅ Output: [5, 6]
    */
}
