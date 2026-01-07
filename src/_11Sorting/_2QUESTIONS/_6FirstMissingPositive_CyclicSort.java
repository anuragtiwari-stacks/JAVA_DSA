package _11Sorting._2QUESTIONS;

public class _6FirstMissingPositive_CyclicSort
{
    public static int firstMissingPositive(int[] nums)
    {
        int i = 0;

        while (i < nums.length)
        {
            int correct = nums[i] - 1;

            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correct])
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

        for (int index = 0; index < nums.length; index++)
        {
            if (nums[index] != index + 1)
            {
                return index + 1;
            }
        }

        return nums.length + 1;
    }

    public static void main(String[] args)
    {
        int[] arr1 = {3, 4, -1, 1};
        int result1 = firstMissingPositive(arr1);
        System.out.println("First missing positive (arr1): " + result1); // Expected: 2

        int[] arr2 = {1, 2, 3, 4};
        int result2 = firstMissingPositive(arr2);
        System.out.println("First missing positive (arr2): " + result2); // Expected: 5

        int[] arr3 = {1, 8, 7, 4};
        int result3 = firstMissingPositive(arr3);
        System.out.println("First missing positive (arr3): " + result3); // Expected: 2
    }

    /*
        🔍 Dry Run:

        arr1 = {3, 4, -1, 1}
        → Cyclic sort: [1, -1, 3, 4]
        → Missing = 2

        arr2 = {1, 2, 3, 4}
        → Already sorted
        → Missing = 5

        arr3 = {1, 8, 7, 4}
        → After sort: [1, 8, 4, 7] → wrong at index 1 → Missing = 2
    */
}
