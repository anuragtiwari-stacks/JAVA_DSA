package _15Greedy.MIK;

// LeetCode 948 — Bag of Tokens

import java.util.Arrays;

public class _1BagOfTokens
{
    public int bagOfTokensScore(int[] tokens, int power)
    {
        Arrays.sort(tokens);

        int i = 0;
        int j = tokens.length - 1;

        int score = 0;
        int maxScore = 0;

        while(i <= j)
        {
            if(power >= tokens[i])
            {
                power = power - tokens[i];
                score = score + 1;
                i = i + 1;

                if(score > maxScore)
                {
                    maxScore = score;
                }
            }
            else if(score >= 1)
            {
                power = power + tokens[j];
                score = score - 1;
                j = j - 1;
            }
            else
            {
                break;
            }
        }

        return maxScore;
    }

    public static void main(String[] args)
    {
        _1BagOfTokens obj = new _1BagOfTokens();
        int[] tokens = {100, 200, 300, 400};
        int power = 200;

        System.out.println(obj.bagOfTokensScore(tokens, power));
    }
}

/*
---------------- DRY RUN ----------------

tokens = [100, 200, 300, 400], power = 200

After sorting: [100, 200, 300, 400]
i = 0, j = 3, score = 0, maxScore = 0

Step 1:
power >= tokens[0] => 200 >= 100 TRUE
power = 200 - 100 = 100
score = 1, i = 1
maxScore = 1

Step 2:
power >= tokens[1] => 100 >= 200 FALSE
score >= 1 => TRUE
Use j=3:
power = 100 + 400 = 500
score = 0, j = 2

Step 3:
power >= tokens[1] => 500 >= 200 TRUE
power = 500 - 200 = 300
score = 1, i = 2
maxScore = 1

Step 4:
power >= tokens[2] => 300 >= 300 TRUE
power = 300 - 300 = 0
score = 2, i = 3
maxScore = 2

Loop exit (i > j)

FINAL ANSWER = maxScore = 2
*/
