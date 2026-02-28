package _01Array;

import java.util.HashSet;

// LeetCode 3719: Longest Balanced Subarray
public class _16LongestBalanced
{

    public int longestBalanced(int[] arr)
    {
        return solve(arr, 0, arr.length - 1);
    }

    private int solve(int[] arr, int i, int j)
    {
        if (i > j)
        {
            return 0;
        }

        if (isBalanced(arr, i, j))
        {
            return j - i + 1;
        }

        int left = solve(arr, i + 1, j);
        int right = solve(arr, i, j - 1);

        return Math.max(left, right);
    }

    private boolean isBalanced(int[] arr, int i, int j)
    {
        HashSet<Integer> set = new HashSet<>();

        int evenCount = 0;
        int oddCount = 0;

        for (int k = i; k <= j; k++)
        {
            if (!set.contains(arr[k]))
            {
                set.add(arr[k]);

                if (arr[k] % 2 == 0)
                {
                    evenCount++;
                }
                else
                {
                    oddCount++;
                }
            }
        }

        if (evenCount == oddCount)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5, 6};

        _16LongestBalanced obj = new _16LongestBalanced();
        System.out.println(obj.longestBalanced(arr));
    }
}


/*
---------------- DRY RUN (Example) ----------------

Input:
arr = {1, 2, 3, 4, 5, 6}

Initial Call:
solve(arr, 0, 5)

Check whole array:
Unique elements = {1,2,3,4,5,6}
Even count = 3 (2,4,6)
Odd count = 3 (1,3,5)

evenCount == oddCount -> true

Return length = 5 - 0 + 1 = 6

Output: 6

---------------------------------------------------
*/
