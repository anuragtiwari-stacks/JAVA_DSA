package _7PrefixSum;

public class _9MinimumPenaltyForShop
{

    // Method to find best closing time
    public static int bestClosingTime(String customers)
    {
        int n = customers.length();

        int[] prefixN = new int[n + 1];
        int[] suffixY = new int[n + 1];

        // Step 1: Prefix count of 'N'
        for (int i = 1; i <= n; i++)
        {
            prefixN[i] = prefixN[i - 1];

            if (customers.charAt(i - 1) == 'N')
            {
                prefixN[i]++;
            }
        }

        // Step 2: Suffix count of 'Y'
        for (int i = n - 1; i >= 0; i--)
        {
            suffixY[i] = suffixY[i + 1];

            if (customers.charAt(i) == 'Y')
            {
                suffixY[i]++;
            }
        }

        // Step 3: Find minimum penalty
        int minPenalty = Integer.MAX_VALUE;
        int bestHour = 0;

        for (int i = 0; i <= n; i++)
        {
            int penalty = prefixN[i] + suffixY[i];

            if (penalty < minPenalty)
            {
                minPenalty = penalty;
                bestHour = i;
            }
        }

        return bestHour;
    }

    public static void main(String[] args)
    {
        String customers = "YYNY";

        int result = bestClosingTime(customers);

        System.out.println("Best Closing Hour = " + result);
    }
}

/*
=====================
DRY RUN
=====================

customers = "Y Y N Y"
index        0 1 2 3

prefixN:
i=0 -> 0
i=1 -> 0
i=2 -> 0
i=3 -> 1
i=4 -> 1

prefixN = {0,0,0,1,1}

suffixY:
i=4 -> 0
i=3 -> 1
i=2 -> 1
i=1 -> 2
i=0 -> 3

suffixY = {3,2,1,1,0}

Penalty at each hour:
hour 0 -> 0 + 3 = 3
hour 1 -> 0 + 2 = 2
hour 2 -> 0 + 1 = 1
hour 3 -> 1 + 1 = 2
hour 4 -> 1 + 0 = 1

Minimum penalty = 1
Best hour = 2
*/
