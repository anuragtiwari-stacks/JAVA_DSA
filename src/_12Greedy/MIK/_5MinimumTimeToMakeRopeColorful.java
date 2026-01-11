package _12Greedy.MIK;

// LeetCode 1578 — Minimum Time to Make Rope Colorful (prev-curr logic)

public class _5MinimumTimeToMakeRopeColorful
{
    public int minCost(String colors, int[] neededTime)
    {
        int time = 0;
        int prev = neededTime[0];

        for(int i = 1; i < colors.length(); i = i + 1)
        {
            int curr = neededTime[i];

            if(colors.charAt(i) == colors.charAt(i - 1))
            {
                time = time + Math.min(prev, curr);
                prev = Math.max(prev, curr);
            }
            else
            {
                prev = curr;
            }
        }

        return time;
    }

    public static void main(String[] args)
    {
        _5MinimumTimeToMakeRopeColorful obj = new _5MinimumTimeToMakeRopeColorful();

        String colors = "aabaa";
        int[] time = {1, 2, 3, 4, 1};

        System.out.println(obj.minCost(colors, time)); // Output: 2 + 1 = 3
    }
}

/*
------------------- DRY RUN -------------------

colors = "aabaa"
time[] = [1, 2, 3, 4, 1]

i = 0:
prev = 1
total = 0

i = 1:
colors[1] = 'a', colors[0] = 'a' (same)
curr = 2
total += min(prev, curr) = min(1, 2) = 1
total = 1
prev = max(1, 2) = 2

i = 2:
colors[2] = 'b', colors[1] = 'a' (different)
prev = 3
total = 1

i = 3:
colors[3] = 'a', colors[2] = 'b' (different)
prev = 4
total = 1

i = 4:
colors[4] = 'a', colors[3] = 'a' (same)
curr = 1
total += min(prev, curr) = min(4, 1) = 1
total = 2
prev = max(4, 1) = 4

FINAL total = 2

------------------------------------------------
*/
