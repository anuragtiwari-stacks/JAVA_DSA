package _01Array;
// LeetCode 1200

import java.util.*;

public class _9MinimumAbsoluteDifference
{
    public static List<List<Integer>> minimumAbsDifference(int[] arr)
    {
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        int n = arr.length;

        for(int i = 1; i < n; i++)
        {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 1; i < n; i++)
        {
            if(arr[i] - arr[i - 1] == minDiff)
            {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] arr = {4, 2, 1, 3};
        List<List<Integer>> ans = minimumAbsDifference(arr);
        System.out.println(ans);
    }
}

/*
Dry Run:

Input:
arr = [4, 2, 1, 3]

After sorting:
arr = [1, 2, 3, 4]

First loop:
i = 1 -> diff = 2 - 1 = 1 -> minDiff = 1
i = 2 -> diff = 3 - 2 = 1 -> minDiff = 1
i = 3 -> diff = 4 - 3 = 1 -> minDiff = 1

Second loop:
i = 1 -> diff = 1 -> add [1, 2]
i = 2 -> diff = 1 -> add [2, 3]
i = 3 -> diff = 1 -> add [3, 4]

Output:
[[1, 2], [2, 3], [3, 4]]
*/
