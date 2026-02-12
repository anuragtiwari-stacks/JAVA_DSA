package _15Greedy.MIK;

// LeetCode 2981: Find Longest Special Substring That Occurs Thrice I

import java.util.*;

public class _31LongestSpecialSubstring
{
    public int maximumLength(String s)
    {
        int n = s.length();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++)
        {
            StringBuilder curr = new StringBuilder();

            for (int j = i; j < n; j++)
            {
                if (curr.length() == 0 || curr.charAt(curr.length() - 1) == s.charAt(j))
                {
                    curr.append(s.charAt(j));
                    String key = curr.toString();
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
                else
                {
                    break;
                }
            }
        }

        int result = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            String str = entry.getKey();
            int count = entry.getValue();

            if (count >= 3 && str.length() > result)
            {
                result = str.length();
            }
        }

        if (result == 0)
        {
            return -1;
        }
        else
        {
            return result;
        }
    }

    public static void main(String[] args)
    {
        _31LongestSpecialSubstring obj = new _31LongestSpecialSubstring();

        String s = "aaabbbaaab";
        int ans = obj.maximumLength(s);

        System.out.println("Output: " + ans);
    }
}


/*
===================== DRY RUN =====================

Input:
s = "aaabbbaaab"

Step-1: Generate special substrings from runs

Runs found:
"aaa", "bbb", "aaa", "b"

Generated and counted:
"a"   appears 6 times
"aa"  appears 3 times
"aaa" appears 3 times
"b"   appears 1 time
"bb"  appears 1 time
"bbb" appears 1 time

Step-2: Check frequencies ≥ 3

"a"   (len=1) count=6 -> ok
"aa"  (len=2) count=3 -> ok
"aaa" (len=3) count=3 -> ok

Step-3: Longest length = 3

Output = 3

===================================================
*/
