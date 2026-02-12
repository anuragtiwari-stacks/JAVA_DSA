package _15Greedy.MIK;

// LeetCode 1833 — Maximum Ice Cream Bars

import java.util.Arrays;

public class _10MaximumIceCreamBars
{
    public int maxIceCream(int[] costs, int coins)
    {
        Arrays.sort(costs);

        int count = 0;

        for(int i = 0; i < costs.length; i++)
        {
            if(coins >= costs[i])
            {
                coins -= costs[i];
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
        _10MaximumIceCreamBars obj = new _10MaximumIceCreamBars();

        int[] costs = {1,3,2,4,1};
        int coins = 7;

        System.out.println(obj.maxIceCream(costs, coins)); // Output: 4
    }
}

/*
---------------- DRY RUN ----------------

costs = [1,3,2,4,1], coins = 7

Step 1: sort costs
costs = [1,1,2,3,4]

count = 0

i=0 → cost=1, coins(7) >=1 → coins=6, count=1
i=1 → cost=1, coins(6) >=1 → coins=5, count=2
i=2 → cost=2, coins(5) >=2 → coins=3, count=3
i=3 → cost=3, coins(3) >=3 → coins=0, count=4
i=4 → cost=4, coins(0) <4 → break

FINAL ANSWER = 4

------------------------------------------
*/
