package _20DynamicProgramming;

import java.util.Arrays;

public class _32RussianDollEnvelopes
{
    public static int maxEnvelopes(int[][] envelopes)
    {
        int n = envelopes.length;

        // Sort by width ascending
        // If width same -> height descending
        Arrays.sort(envelopes, (a, b) ->
        {
            if(a[0] == b[0])
            {
                return b[1] - a[1];
            }

            return a[0] - b[0];
        });

        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        int max = 1;

        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }

            max = Math.max(max, dp[i]);

        }

        return max;
    }

    public static void main(String[] args)
    {
        int[][] envelopes =
                {
                        {5,4},
                        {6,4},
                        {6,7},
                        {2,3}
                };

        System.out.println(maxEnvelopes(envelopes));
    }
}