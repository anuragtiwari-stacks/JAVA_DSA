package _01Array;

import java.util.*;

/*
GCD Pair Sum

Given an integer array nums of size n.

Steps:
1. Create an array mx where mx[i] stores the maximum value from index 0 to i.
2. Create another array prefixGcd where:
      prefixGcd[i] = gcd(nums[i], mx[i])
3. Sort the prefixGcd array.
4. Pair the smallest and largest values and compute their gcd.
5. Return the sum of these gcd values.

Example 1:
Input: nums = [2,6,4]

Process:
mx = [2,6,6]

prefixGcd:
gcd(2,2) = 2
gcd(6,6) = 6
gcd(4,6) = 2

prefixGcd = [2,6,2]

After sorting:
[2,2,6]

Pairs:
gcd(2,6) = 2

Output: 2

Constraints:
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
*/

public class _22GcdSum
{
    public static long gcdSum(int[] nums)
    {
        int n = nums.length;

        int[] mx = new int[n];
        mx[0] = nums[0];

        // build prefix maximum array
        for(int i = 1; i < n; i++)
        {
            mx[i] = Math.max(mx[i - 1], nums[i]);
        }

        int[] prefixGcd = new int[n];

        // compute gcd with prefix maximum
        for(int i = 0; i < n; i++)
        {
            prefixGcd[i] = gcd(nums[i], mx[i]);
        }

        // sort the gcd array
        Arrays.sort(prefixGcd);

        long sum = 0;

        // pair smallest with largest
        for(int i = 0; i < n / 2; i++)
        {
            sum = sum + gcd(prefixGcd[i], prefixGcd[n - 1 - i]);
        }

        return sum;
    }

    // Euclidean algorithm for GCD
    public static int gcd(int a, int b)
    {
        while(b != 0)
        {
            int t = b;
            b = a % b;
            a = t;
        }

        return a;
    }

    public static void main(String[] args)
    {
        int[] nums = {2,6,4}; // sample input

        long ans = gcdSum(nums);

        System.out.println("GCD Pair Sum: " + ans);
    }
}

/*
DRY RUN

Input:
nums = [2,6,4]

Step 1: Build prefix max array

mx[0] = 2
mx[1] = max(2,6) = 6
mx[2] = max(6,4) = 6

mx = [2,6,6]

Step 2: Compute prefixGcd

gcd(2,2) = 2
gcd(6,6) = 6
gcd(4,6) = 2

prefixGcd = [2,6,2]

Step 3: Sort prefixGcd

[2,2,6]

Step 4: Pair smallest and largest

Pair:
gcd(2,6) = 2

Step 5: Sum

sum = 2

Output:
GCD Pair Sum: 2
*/