package _12Greedy.MIK;

// LeetCode 1326 - Minimum Number of Taps to Open to Water a Garden
public class _14MinTaps
{
    public int minTaps(int n, int[] ranges)
    {
        int[] maxReach = new int[n + 1];

        // Build maxReach array → from each left boundary, we store the farthest right coverage
        for(int i = 0; i <= n; i++)
        {
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);
            maxReach[left] = Math.max(maxReach[left], right);
        }

        int taps = 0;
        int currEnd = 0;  // current coverage end
        int nextEnd = 0;  // best reachable coverage beyond currEnd

        for(int i = 0; i <= n; i++)
        {
            // if we are stuck before reaching this point
            if(i > nextEnd)
            {
                return -1;
            }

            // update the best we can reach from current segment
            nextEnd = Math.max(nextEnd, maxReach[i]);

            // if we reached current segment boundary, take tap
            if(i == currEnd)
            {
                taps++;
                currEnd = nextEnd;
                if(currEnd == n)
                {
                    break;
                }
            }
        }

        return taps;
    }

    public static void main(String[] args)
    {
        _14MinTaps obj = new _14MinTaps();

        int[] ranges = {3,3,1,1,2,0};
        int n = 5; // because ranges.length = 6 so garden = [0..5]

        System.out.println(obj.minTaps(n, ranges)); // Expected Output: 2
    }
}

/*
---------------- DRY RUN FOR ranges = [3,3,1,1,2,0] ----------------

n = 5

Convert to intervals:

i=0 -> [0,3]
i=1 -> [0,4]
i=2 -> [1,3]
i=3 -> [2,4]
i=4 -> [2,5]
i=5 -> [5,5]

maxReach array after building:

maxReach = [4, 3, 5, 0, 0, 5]

Variables:
currEnd = 0
nextEnd = 0
taps = 0

i = 0:
 nextEnd = max(0,4)=4
 i==currEnd? 0==0 yes → taps=1, currEnd=4

i = 1:
 nextEnd = max(4,3)=4
 i==currEnd? 1==4 no

i = 2:
 nextEnd = max(4,5)=5
 i==currEnd? 2==4 no

i = 3:
 nextEnd = max(5,0)=5
 i==currEnd? 3==4 no

i = 4:
 nextEnd = max(5,0)=5
 i==currEnd? 4==4 yes → taps=2, currEnd=5
 currEnd==n break

Answer = 2

--------------------------------------------------------------------
*/
