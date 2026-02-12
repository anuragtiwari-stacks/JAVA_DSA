package _20DynamicProgramming;

// LeetCode 2915 - Length of the Longest Subsequence That Sums to Target
public class _16LongestSubsequenceSumTarget
{
    public static int lengthOfLongestSubsequence(int[] nums, int target)
    {
        int n = nums.length;

        int[][] dp = new int[n + 1][target + 1];

        // initialize dp with -1
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= target; j++)
            {
                dp[i][j] = -1;
            }
        }

        // base case: sum = 0 → length = 0
        for (int i = 0; i <= n; i++)
        {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= target; j++)
            {
                // Option 1: skip current element
                dp[i][j] = dp[i - 1][j];

                // Option 2: pick current element (if allowed)
                if (nums[i - 1] <= j && dp[i - 1][j - nums[i - 1]] != -1)
                {
                    dp[i][j] = Math.max(dp[i][j],
                                        dp[i - 1][j - nums[i - 1]] + 1
                    );
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 7;

        System.out.println(lengthOfLongestSubsequence(nums, target));
    }
}

/*
==================== DRY RUN (TABLE AFTER EACH i) ====================

nums = [1, 2, 3, 4, 5]
target = 7

Meaning:
dp[i][j] = first i elements use karke
           sum j banane ki MAXIMUM length
-1 = not possible

--------------------------------------------------
INITIAL TABLE (Base Case)

i\j | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7
----------------------------------
0   | 0 | -1| -1| -1| -1| -1| -1| -1


==================================================
After i = 1 (nums[0] = 1)

Logic:
- skip → dp[0][j]
- pick → dp[0][j-1] + 1

i\j | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7
----------------------------------
0   | 0 | -1| -1| -1| -1| -1| -1| -1
1   | 0 |  1| -1| -1| -1| -1| -1| -1

Explanation:
- j=1 → pick 1 → dp[0][0]+1 = 1


==================================================
After i = 2 (nums[1] = 2)

Logic:
- skip → dp[1][j]
- pick → dp[1][j-2] + 1

i\j | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7
----------------------------------
0   | 0 | -1| -1| -1| -1| -1| -1| -1
1   | 0 |  1| -1| -1| -1| -1| -1| -1
2   | 0 |  1|  1|  2| -1| -1| -1| -1

Explanation:
- j=2 → pick 2 → dp[1][0]+1 = 1
- j=3 → pick 2 → dp[1][1]+1 = 2 (1+2)


==================================================
After i = 3 (nums[2] = 3)

Logic:
- skip → dp[2][j]
- pick → dp[2][j-3] + 1

i\j | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7
----------------------------------
0   | 0 | -1| -1| -1| -1| -1| -1| -1
1   | 0 |  1| -1| -1| -1| -1| -1| -1
2   | 0 |  1|  1|  2| -1| -1| -1| -1
3   | 0 |  1|  1|  2|  2|  2|  3| -1

Explanation:
- j=3 → pick 3 → dp[2][0]+1 = 1
- j=4 → pick 3 → dp[2][1]+1 = 2
- j=5 → pick 3 → dp[2][2]+1 = 2
- j=6 → pick 3 → dp[2][3]+1 = 3 (1+2+3)


==================================================
After i = 4 (nums[3] = 4)

Logic:
- skip → dp[3][j]
- pick → dp[3][j-4] + 1

i\j | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7
----------------------------------
0   | 0 | -1| -1| -1| -1| -1| -1| -1
1   | 0 |  1| -1| -1| -1| -1| -1| -1
2   | 0 |  1|  1|  2| -1| -1| -1| -1
3   | 0 |  1|  1|  2|  2|  2|  3| -1
4   | 0 |  1|  1|  2|  2|  2|  3|  3

Explanation:
- j=4 → pick 4 → dp[3][0]+1 = 1
- j=5 → pick 4 → dp[3][1]+1 = 2
- j=6 → skip better (3)
- j=7 → pick 4 → dp[3][3]+1 = 3 (1+2+4)


==================================================
After i = 5 (nums[4] = 5)

Logic:
- skip → dp[4][j]
- pick → dp[4][j-5] + 1

i\j | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7
----------------------------------
0   | 0 | -1| -1| -1| -1| -1| -1| -1
1   | 0 |  1| -1| -1| -1| -1| -1| -1
2   | 0 |  1|  1|  2| -1| -1| -1| -1
3   | 0 |  1|  1|  2|  2|  2|  3| -1
4   | 0 |  1|  1|  2|  2|  2|  3|  3
5   | 0 |  1|  1|  2|  2|  2|  3|  3

Explanation:
- j=5 → pick 5 → dp[4][0]+1 = 1
- j=6 → pick 5 → dp[4][1]+1 = 2
- j=7 → skip better (length 3)

--------------------------------------------------
FINAL ANSWER:

dp[5][7] = 3

Longest subsequence length = 3
Example subsequence:
[1, 2, 4] → sum = 7

==================================================
*/
