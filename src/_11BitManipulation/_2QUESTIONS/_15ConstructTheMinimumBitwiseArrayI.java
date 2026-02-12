package _11BitManipulation._2QUESTIONS;

// LeetCode 3314 : Construct the Minimum Bitwise Array I

import java.util.*;

public class _15ConstructTheMinimumBitwiseArrayI
{

    public int[] minBitwiseArray(List<Integer> nums)
    {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++)
        {
            int val = nums.get(i);
            ans[i] = -1;

            for (int x = 0; x < val; x++)
            {
                if ((x | (x + 1)) == val)
                {
                    ans[i] = x;
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args)
    {
        _15ConstructTheMinimumBitwiseArrayI obj = new _15ConstructTheMinimumBitwiseArrayI();
        List<Integer> nums = Arrays.asList(2, 3, 5, 7);
        int[] res = obj.minBitwiseArray(nums);

        System.out.println(Arrays.toString(res));
    }
}

/*
Dry Run :

Input : nums = [2, 3, 5, 7]

i = 0 → val = 2
ans[0] = -1 initially
x = 0 → (0 | 1) = 1 != 2
x = 1 → (1 | 2) = 3 != 2
No match found → ans[0] = -1

i = 1 → val = 3
ans[1] = -1 initially
x = 0 → (0 | 1) = 1 != 3
x = 1 → (1 | 2) = 3 == 3 → ans[1] = 1

i = 2 → val = 5
ans[2] = -1 initially
x = 0 → (0 | 1) = 1 != 5
x = 1 → (1 | 2) = 3 != 5
x = 2 → (2 | 3) = 3 != 5
x = 3 → (3 | 4) = 7 != 5
x = 4 → (4 | 5) = 5 == 5 → ans[2] = 4

i = 3 → val = 7
ans[3] = -1 initially
x = 0 → (0 | 1) = 1 != 7
x = 1 → (1 | 2) = 3 != 7
x = 2 → (2 | 3) = 3 != 7
x = 3 → (3 | 4) = 7 == 7 → ans[3] = 3

Output → [-1, 1, 4, 3]
*/
