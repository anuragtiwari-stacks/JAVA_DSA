package _17DynamicProgramming;

// LeetCode 354. Russian Doll Envelopes

import java.util.*;

public class _34RussianDollEnvelopes
{
    public static int maxEnvelopes(int[][] envelopes)
    {
        Arrays.sort(envelopes, (a, b) ->
        {
            if(a[0] == b[0])
            {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int n = envelopes.length;
        int[] heights = new int[n];

        for(int i = 0; i < n; i++)
        {
            heights[i] = envelopes[i][1];
        }

        int[] dp = new int[n];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j <= i - 1; j++)
            {
                if(heights[i] > heights[j])
                {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += 1;
        }

        int maxLen = dp[0];
        for(int i = 1; i < n; i++)
        {
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    public static void main(String[] args)
    {
        int[][] envelopes =
                {
                        {3,5},
                        {6,7},
                        {6,10},
                        {7,11},
                        {7,13},
                        {8,4}
                };

        int result = maxEnvelopes(envelopes);
        System.out.println("Maximum Envelopes = " + result);
    }
}

/*
======================= CORRECT DRY RUN =======================

INPUT:
(3,5), (6,7), (6,10), (7,11), (7,13), (8,4)

STEP-1: SORT by width asc, height desc:

Sorted result:
(3,5), (6,10), (6,7), (7,13), (7,11), (8,4)

STEP-2: Extract heights:
heights = [5, 10, 7, 13, 11, 4]

Initialize:
dp = [0,0,0,0,0,0]

Now fill DP:

i = 0 (height 5):
  no j loop
  dp[0] = 0 + 1 = 1

dp = [1,0,0,0,0,0]

i = 1 (height 10):
  j=0: 10>5 → dp[1] = max(dp[1], dp[0]) = max(0,1)=1
  dp[1] = 1 + 1 = 2

dp = [1,2,0,0,0,0]

i = 2 (height 7):
  j=0: 7>5 → dp[2] = max(0,1)=1
  j=1: 7>10? no
  dp[2] = 1 + 1 = 2

dp = [1,2,2,0,0,0]

i = 3 (height 13):
  j=0: 13>5 → dp[3] = max(0,1)=1
  j=1: 13>10 → dp[3] = max(1,2)=2
  j=2: 13>7 → dp[3] = max(2,2)=2
  dp[3] = 2 + 1 = 3

dp = [1,2,2,3,0,0]

i = 4 (height 11):
  j=0: 11>5 → dp[4] = max(0,1)=1
  j=1: 11>10 → dp[4] = max(1,2)=2
  j=2: 11>7 → dp[4] = max(2,2)=2
  j=3: 11>13? no
  dp[4] = 2 + 1 = 3

dp = [1,2,2,3,3,0]

i = 5 (height 4):
  j=0: 4>5? no
  j=1: 4>10? no
  j=2: 4>7? no
  j=3: 4>13? no
  j=4: 4>11? no
  dp[5] = 0 + 1 = 1

dp = [1,2,2,3,3,1]

Final dp = [1,2,2,3,3,1]

Now take max:
maxLen = 3

==================== FINAL OUTPUT ====================
Maximum Envelopes = 3
======================================================
*/
