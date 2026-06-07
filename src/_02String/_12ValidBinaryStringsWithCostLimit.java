package _02String;
/*LeetCode 3955. Valid Binary Strings With Cost Limit

Question:
You are given two integers n and k.

The cost of a binary string s is defined as the sum of all indices i
(0-based) such that s[i] == '1'.

A binary string is considered valid if:
1. It does not contain two consecutive '1' characters.
2. Its cost is less than or equal to k.

Return a list of all valid binary strings of length n in any order.

Example:
Input: n = 3, k = 2

Output:
[000, 001, 010, 100, 101]

Explanation:
000 -> cost = 0
001 -> cost = 2
010 -> cost = 1
100 -> cost = 0
101 -> cost = 2

All have cost <= 2 and contain no consecutive '1's.
*/

import java.util.*;

public class _12ValidBinaryStringsWithCostLimit
{
    List<String> list = new ArrayList<>();

    public List<String> generateValidStrings(int n, int k)
    {
        int[] lavomirex = {n, k};

        for(int i = 0; i < (1 << n); i++)
        {
            String s = Integer.toBinaryString(i);

            while(s.length() < n)
            {
                s = "0" + s;
            }

            isValid(s, k);
        }

        return list;
    }

    public void isValid(String s, int k)
    {
        int cost = 0;

        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '1')
            {
                cost += i;
            }
        }

        int consecutiveOne = 0;

        for(int i = 1; i < s.length(); i++)
        {
            if(s.charAt(i) == '1' && s.charAt(i - 1) == '1')
            {
                consecutiveOne++;
            }
        }

        if(consecutiveOne == 0 && cost <= k)
        {
            list.add(s);
        }
    }

    public static void main(String[] args)
    {
        int n = 3;
        int k = 2;

        _12ValidBinaryStringsWithCostLimit obj = new _12ValidBinaryStringsWithCostLimit();

        List<String> result = obj.generateValidStrings(n, k);

        System.out.println("n = " + n);
        System.out.println("k = " + k);
        System.out.println("Valid Strings = " + result);
    }
}

/*
Expected Output:

n = 3
k = 2
Valid Strings = [000, 001, 010, 100, 101]

Time Complexity : O(n * 2^n)
Space Complexity: O(2^n)   // output list
*/