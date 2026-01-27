package Array_String;

// LeetCode 3819

import java.util.*;

public class _11RotateNonNegativeElements
{
    public static int[] rotateNonNegativeElements(int[] nums, int k)
    {
        List<Integer> nonNeg = new ArrayList<>();

        for(int num : nums)
        {
            if(num >= 0)
            {
                nonNeg.add(num);
            }
        }

        int size = nonNeg.size();

        if(size == 0)
        {
            return nums;
        }

        k = k % size;

        Collections.rotate(nonNeg, k);

        int idx = 0;

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] >= 0)
            {
                nums[i] = nonNeg.get(idx);
                idx++;
            }
        }

        return nums;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, -1, 3, -2, 5};
        int k = 2;

        int[] ans = rotateNonNegativeElements(nums, k);

        System.out.println(Arrays.toString(ans));
    }
}

/*
Dry Run:

Input:
nums = [1, -1, 3, -2, 5]
k = 2

Step 1: Extract non-negative elements
nonNeg = [1, 3, 5]

Step 2: Rotate right by k = 2
After rotation:
nonNeg = [3, 5, 1]

Step 3: Put back into original array
Index 0 -> 3
Index 1 -> -1 (unchanged)
Index 2 -> 5
Index 3 -> -2 (unchanged)
Index 4 -> 1

Final Output:
[3, -1, 5, -2, 1]
*/
