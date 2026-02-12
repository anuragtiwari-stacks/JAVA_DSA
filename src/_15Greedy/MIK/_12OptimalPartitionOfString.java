package _15Greedy.MIK;

import java.util.*;

// LeetCode 2405 - Optimal Partition of String
public class _12OptimalPartitionOfString
{
    public int partitionString(String s)
    {
        // Track characters of current substring
        boolean[] seen = new boolean[26];

        int count = 1; // at least one substring

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            int idx = c - 'a';

            // If this char already seen => new substring needed
            if(seen[idx])
            {
                count++;
                Arrays.fill(seen, false); // reset for new substring
            }

            seen[idx] = true; // mark char as seen in current substring
        }

        return count;
    }

    public static void main(String[] args)
    {
        _12OptimalPartitionOfString obj = new _12OptimalPartitionOfString();

        String s = "abac";  // Expect 2 -> "ab" + "ac"

        System.out.println(obj.partitionString(s));
    }
}

/*
------------------ DRY RUN ------------------

Input:
s = "abac"

Initialization:
seen[] all false
count = 1

i=0, c='a'
 seen[a]? false
 mark seen[a]=true
 count = 1

i=1, c='b'
 seen[b]? false
 mark seen[b]=true
 count = 1

i=2, c='a'
 seen[a]? true -> substring break
 count = 2
 reset seen[]
 mark seen[a]=true

i=3, c='c'
 seen[c]? false
 mark seen[c]=true
 count = 2

END → return 2

Output: 2

Explanation:
"ab" + "ac"

------------------------------------------------
*/
