package _12Greedy.MIK;

// LeetCode 2279 — Maximum Bags With Full Capacity of Rocks

import java.util.Arrays;

public class _8MaximumBagsWithFullCapacityOfRocks
{
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks)
    {
        int n = capacity.length;
        int[] need = new int[n];

        // need = capacity - rocks
        for(int i = 0; i < n; i++)
        {
            need[i] = capacity[i] - rocks[i];
        }

        // ascending order
        Arrays.sort(need);

        int count = 0;

        for(int i = 0; i < n; i++)
        {
            if(need[i] == 0)
            {
                count++;
            }
            else if(additionalRocks >= need[i])
            {
                additionalRocks = additionalRocks - need[i];
                count++;
            }
            else
            {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        _8MaximumBagsWithFullCapacityOfRocks obj = new _8MaximumBagsWithFullCapacityOfRocks();

        int[] capacity = {2,3,4,5};
        int[] rocks = {1,2,4,4};
        int additionalRocks = 0;

        System.out.println(obj.maximumBags(capacity, rocks, additionalRocks)); // Output: 3
    }
}

/*
---------------- DRY RUN ----------------

capacity = [2,3,4,5]
rocks    = [1,2,4,4]
additionalRocks = 0

Step 1: need = capacity - rocks
need = [1,1,0,1]

Step 2: sort need
need = [0,1,1,1]

Step 3: fill
i=0 -> need=0 => full => count=1
i=1 -> need=1 but additionalRocks=0 => break

BUT original full bags = 3 (bag2 already full)

Final Answer = 3

----------------------------------------
*/
