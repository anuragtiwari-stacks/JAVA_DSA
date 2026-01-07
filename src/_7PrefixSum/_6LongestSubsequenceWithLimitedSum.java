package _7PrefixSum;

import java.util.Arrays;

public class _6LongestSubsequenceWithLimitedSum
{
    // Method to find answer for each query
    public static int[] answerQueries(int[] nums, int[] queries)
    {
        int n = nums.length;
        int m = queries.length;

        int[] answer = new int[m];

        // Step 1: Sort the nums array
        Arrays.sort(nums);

        // Step 2: Build prefix sum array
        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++)
        {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        // Step 3: For each query, find longest subsequence
        for (int i = 0; i < m; i++)
        {
            int sumLimit = queries[i];
            int count = 0;

            for (int j = 0; j < n; j++)
            {
                if (prefix[j] <= sumLimit)
                {
                    count++;
                }
                else
                {
                    break;
                }
            }

            answer[i] = count;
        }

        return answer;
    }

    public static void main(String[] args)
    {
        int[] nums = { 4, 5, 2, 1 };
        int[] queries = { 3, 10, 21 };

        int[] result = answerQueries(nums, queries);

        for (int i = 0; i < result.length; i++)
        {
            System.out.print(result[i] + " ");
        }
    }
}

/*
=====================
DRY RUN
=====================

nums = { 4, 5, 2, 1 }
queries = { 3, 10, 21 }

Step 1: Sort nums
nums = { 1, 2, 4, 5 }

Step 2: Prefix sum
prefix[0] = 1
prefix[1] = 1 + 2 = 3
prefix[2] = 3 + 4 = 7
prefix[3] = 7 + 5 = 12

prefix = { 1, 3, 7, 12 }

Query 0: sumLimit = 3
prefix[0] = 1 <= 3 → count = 1
prefix[1] = 3 <= 3 → count = 2
prefix[2] = 7 > 3 → stop
answer[0] = 2

Query 1: sumLimit = 10
prefix[0] = 1 <= 10 → count = 1
prefix[1] = 3 <= 10 → count = 2
prefix[2] = 7 <= 10 → count = 3
prefix[3] = 12 > 10 → stop
answer[1] = 3

Query 2: sumLimit = 21
All prefix sums ≤ 21
answer[2] = 4

Final Output:
{ 2, 3, 4 }
*/
