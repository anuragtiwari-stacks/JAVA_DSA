package _01Array;

import java.util.HashSet;

// LeetCode 495
public class _18TeemoAttacking
{

    public static void main(String[] args)
    {
        _18TeemoAttacking obj = new _18TeemoAttacking();

        int[] timeSeries = {1, 4};
        int duration = 2;

        int result = obj.findPoisonedDuration(timeSeries, duration);

        System.out.println(result);
    }

    public int findPoisonedDuration(int[] timeSeries, int duration)
    {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < timeSeries.length; i++)
        {
            int start = timeSeries[i];
            int end = start + duration - 1;

            for (int t = start; t <= end; t++)
            {
                set.add(t);
            }
        }

        return set.size();
    }
}

/*
Dry Run:

Input:
timeSeries = [1, 4]
duration = 2

Attack at 1 → poison from 1 to 2
Attack at 4 → poison from 4 to 5

Set contains: {1, 2, 4, 5}

Size = 4

Output: 4
*/
