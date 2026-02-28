package _02String;// LeetCode 1461
// Check If a String Contains All Binary Codes of Size K

import java.util.*;

public class _4BinaryCodesOfSizeK
{

    public boolean hasAllCodes(String s, int k)
    {

        int n = s.length();

        if (n < k)
        {
            return false;
        }

        // Step 1: Generate all binary strings of length k
        List<String> allCodes = new ArrayList<>();

        generateBinary("", k, allCodes);

        // Step 2: Sliding window check
        for (String code : allCodes)
        {

            boolean found = false;

            int i = 0;
            int j = k - 1;

            while (j < n)
            {

                String window = s.substring(i, j + 1);

                if (window.equals(code))
                {
                    found = true;
                    break;
                }

                i++;
                j++;
            }

            if (!found)
            {
                return false;
            }
        }

        return true;
    }

    public void generateBinary(String curr, int k, List<String> list)
    {

        if (curr.length() == k)
        {
            list.add(curr);
            return;
        }

        generateBinary(curr + "0", k, list);
        generateBinary(curr + "1", k, list);
    }


    public static void main(String[] args)
    {
        _4BinaryCodesOfSizeK obj = new _4BinaryCodesOfSizeK();

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

Generated Codes:
00
01
10
11

Sliding Windows:
00 ✔
01 ✔
11 ✔
10 ✔

All found → return true

Output:
true
--------------------------------------------------
Time Complexity: O(n * 2^k)
Space Complexity: O(2^k)
--------------------------------------------------
*/