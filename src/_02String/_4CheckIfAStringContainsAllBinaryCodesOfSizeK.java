package _02String;

// LeetCode 1461
// Check If a String Contains All Binary Codes of Size K

import java.util.*;

public class _4CheckIfAStringContainsAllBinaryCodesOfSizeK
{
    public boolean hasAllCodes(String s, int k)
    {
        HashSet<String> set = new HashSet<>();

        int n = s.length();

        int k_length = (int)Math.pow(2, k);

        for (int i = 0; i <= n-k; i++)
        {
            String sub = s.substring(i, i+k);

            if (!set.contains(sub))
            {
                set.add(sub);
            }

            if (set.size() == k_length)
            {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        _4CheckIfAStringContainsAllBinaryCodesOfSizeK obj =
                new _4CheckIfAStringContainsAllBinaryCodesOfSizeK();

        String s = "00110110";
        int k = 2;

        boolean result = obj.hasAllCodes(s, k);

        System.out.println("Output: " + result);
    }
}


/*
--------------------------------------------------
Dry Run:

Input:
s = "00110110"
k = 2

codes = 1 << 2 = 4

Substrings:
i=2 → "00" → new → codes=3
i=3 → "01" → new → codes=2
i=4 → "11" → new → codes=1
i=5 → "10" → new → codes=0 → return true

Output:
true
--------------------------------------------------

Time Complexity: O(n)
Space Complexity: O(2^k)
--------------------------------------------------
*/