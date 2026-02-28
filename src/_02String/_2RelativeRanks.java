package _02String;

import java.util.Arrays;
import java.util.HashMap;

// LeetCode 506
public class _2RelativeRanks
{

    public static void main(String[] args)
    {
        _2RelativeRanks obj = new _2RelativeRanks();

        int[] score = {5, 4, 3, 2, 1};

        String[] result = obj.findRelativeRanks(score);

        for (int i = 0; i < result.length; i++)
        {
            System.out.println(result[i]);
        }
    }

    public String[] findRelativeRanks(int[] score)
    {
        int n = score.length;

        int[] copy = new int[n];

        for (int i = 0; i < n; i++)
        {
            copy[i] = score[i];
        }

        Arrays.sort(copy);

        for (int i = 0; i < n / 2; i++)
        {
            int temp = copy[i];
            copy[i] = copy[n - 1 - i];
            copy[n - 1 - i] = temp;
        }

        HashMap<Integer, String> map = new HashMap<>();

        for (int i = 0; i < n; i++)
        {
            if (i == 0)
            {
                map.put(copy[i], "Gold Medal");
            }
            else if (i == 1)
            {
                map.put(copy[i], "Silver Medal");
            }
            else if (i == 2)
            {
                map.put(copy[i], "Bronze Medal");
            }
            else
            {
                map.put(copy[i], String.valueOf(i + 1));
            }
        }

        String[] result = new String[n];

        for (int i = 0; i < n; i++)
        {
            result[i] = map.get(score[i]);
        }

        return result;
    }
}

/*
Dry Run:

Input:
score = {5, 4, 3, 2, 1}

Copy array:
{5, 4, 3, 2, 1}

After sorting:
{1, 2, 3, 4, 5}

After reversing:
{5, 4, 3, 2, 1}

Ranking map:
5 -> Gold Medal
4 -> Silver Medal
3 -> Bronze Medal
2 -> 4
1 -> 5

Result:
["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
*/
