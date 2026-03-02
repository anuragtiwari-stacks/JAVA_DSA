package _10PrefixSum;

public class _11LargestAltitude
{

    // Method to find highest altitude
    public static int largestAltitude(int[] gain)
    {
        int n = gain.length;

        int[] preSum = new int[n + 1];

        preSum[0] = 0;

        // Build Prefix Sum Array
        for(int i = 1; i <= n; i++)
        {
            preSum[i] = preSum[i - 1] + gain[i - 1];
        }

        int max = Integer.MIN_VALUE;

        // Find Maximum Altitude
        for(int i = 0; i <= n; i++)
        {
            if(preSum[i] > max)
            {
                max = preSum[i];
            }
        }

        return max;
    }

    public static void main(String[] args)
    {
        int[] gain = { -5, 1, 5, 0, -7 };

        int result = largestAltitude(gain);

        System.out.println("Highest Altitude = " + result);
    }
}

/*
=====================
DRY RUN
=====================

gain = { -5, 1, 5, 0, -7 }

Initial altitude = 0

Prefix Array:
preSum[0] = 0
preSum[1] = 0 + (-5) = -5
preSum[2] = -5 + 1 = -4
preSum[3] = -4 + 5 = 1
preSum[4] = 1 + 0 = 1
preSum[5] = 1 + (-7) = -6

preSum = {0, -5, -4, 1, 1, -6}

Maximum altitude = 1
*/