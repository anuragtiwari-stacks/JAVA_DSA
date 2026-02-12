/*
2442. Count Number of Distinct Integers After Reverse Operations

You are given an array nums consisting of positive integers.

You have to take each integer in the array, reverse its digits,
and add it to the end of the array.
You should apply this operation only to the original integers in nums.

Return the number of distinct integers in the final array.
*/

package _7Hashing._1HashSet;

import java.util.HashSet;

public class _4CountNumberOfDistinctIntegersAfterReverseOperations
{
    public static int countDistinctIntegers(int[] nums)
    {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums)
        {
            set.add(num);

            int reversed = reverseNumber(num);
            set.add(reversed);
        }

        return set.size();
    }

    private static int reverseNumber(int num)
    {
        int rev = 0;

        while (num > 0)
        {
            int digit = num % 10;
            rev = rev * 10 + digit;
            num = num / 10;
        }

        return rev;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 13, 10, 12, 31};

        int result = countDistinctIntegers(nums);

        System.out.println("Number of distinct integers: " + result);
    }
}

/*
Dry Run:

Input: nums = [1, 13, 10, 12, 31]

HashSet = {}

1 -> add 1, reverse(1)=1
Set = {1}

13 -> add 13, reverse(13)=31
Set = {1, 13, 31}

10 -> add 10, reverse(10)=1
Set = {1, 13, 31, 10}

12 -> add 12, reverse(12)=21
Set = {1, 13, 31, 10, 12, 21}

31 -> add 31, reverse(31)=13
Set = {1, 10, 12, 13, 21, 31}

Distinct Count = 6
*/
