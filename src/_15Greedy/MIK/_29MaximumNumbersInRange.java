package _15Greedy.MIK;

// LeetCode 2554: Maximum Number of Integers to Choose From a Range I

public class _29MaximumNumbersInRange
{
    public int maxCount(int[] banned, int n, int maxSum)
    {
        boolean[] isBanned = new boolean[n + 1];

        for (int x : banned)
        {
            if (x <= n)
            {
                isBanned[x] = true;
            }
        }

        int sum = 0;
        int count = 0;

        for (int i = 1; i <= n; i++)
        {
            if (!isBanned[i])
            {
                if (sum + i <= maxSum)
                {
                    sum = sum + i;
                    count++;
                }
                else
                {
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        _29MaximumNumbersInRange obj = new _29MaximumNumbersInRange();

        int[] banned = {1, 6, 5};
        int n = 5;
        int maxSum = 6;

        System.out.println("Output: " + obj.maxCount(banned, n, maxSum));
    }
}


/*
===================== DRY RUN =====================

Input:
banned = [1, 6, 5]
n = 5
maxSum = 6

Step-1: Mark banned
isBanned[1] = true
isBanned[5] = true (but 5 > n, ignored)
isBanned[6] ignored ( > n )

Step-2: Iterate i = 1 to 5

i = 1 -> banned -> skip

i = 2 -> not banned
sum + 2 = 2 <= 6 -> take
sum = 2, count = 1

i = 3 -> not banned
sum + 3 = 5 <= 6 -> take
sum = 5, count = 2

i = 4 -> not banned
sum + 4 = 9 > 6 -> break

Stop

Final count = 2

===================================================
*/
