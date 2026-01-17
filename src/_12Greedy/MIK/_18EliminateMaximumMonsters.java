// LeetCode 1921 - Eliminate Maximum Number of Monsters

package _12Greedy.MIK;

import java.util.Arrays;

public class _18EliminateMaximumMonsters
{
    public int eliminateMaximum(int[] dist, int[] speed)
    {
        int n = dist.length;
        int[] time = new int[n];
        for(int i = 0; i < n; i++)
        {
            time[i] = (int)Math.ceil((double)dist[i] / speed[i]);
        }
        Arrays.sort(time);
        int time_passed = 0;
        for(int i = 0; i < n; i++)
        {
            if(time[i] - time_passed <= 0)
            {
                return i;
            }
            time_passed++;
        }
        return n;
    }

    public static void main(String[] args)
    {
        _18EliminateMaximumMonsters obj = new _18EliminateMaximumMonsters();
        int[] dist = {3,5,7,4,5};
        int[] speed = {2,3,6,3,2};
        int result = obj.eliminateMaximum(dist, speed);
        System.out.println(result);
    }
}

/*
==================== DRY RUN ====================

Input:
dist  = [3,5,7,4,5]
speed = [2,3,6,3,2]

Compute time = ceil(dist/speed):
3/2 = 1.5 → 2
5/3 = 1.6 → 2
7/6 = 1.1 → 2
4/3 = 1.3 → 2
5/2 = 2.5 → 3

time = [2,2,2,2,3]

Sort time:
time = [2,2,2,2,3]

Initialize:
time_passed = 0

Loop:

i = 0:
time[i] = 2
time[i] - time_passed = 2 - 0 = 2 > 0  → kill monster
time_passed = 1

i = 1:
time[i] = 2
time[i] - time_passed = 2 - 1 = 1 > 0  → kill monster
time_passed = 2

i = 2:
time[i] = 2
time[i] - time_passed = 2 - 2 = 0 <= 0 → condition true
return i = 2

Final Result:
2 monsters eliminated

Console Output:
2

=================================================
*/
