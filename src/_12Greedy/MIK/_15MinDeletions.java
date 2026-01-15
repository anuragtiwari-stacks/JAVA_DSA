package _12Greedy.MIK;

import java.util.*;

// LeetCode 1647 - Minimum Deletions to Make Character Frequencies Unique
public class _15MinDeletions
{
    public int minDeletions(String s)
    {
        int[] freq = new int[26];

        // count frequency
        for(char c : s.toCharArray())
        {
            freq[c - 'a']++;
        }

        Set<Integer> used = new HashSet<>();
        int deletions = 0;

        for(int f : freq)
        {
            // keep decreasing until unique or zero
            while(f > 0 && used.contains(f))
            {
                f--;
                deletions++;
            }

            if(f > 0)
            {
                used.add(f);
            }
        }

        return deletions;
    }

    public static void main(String[] args)
    {
        _15MinDeletions obj = new _15MinDeletions();

        System.out.println(obj.minDeletions("aaabbbcc"));   // expected 2
        System.out.println(obj.minDeletions("ceabaacb"));   // expected 2
        System.out.println(obj.minDeletions("abcabc"));     // expected 3
    }
}

/*
---------------- DRY RUN for "aaabbbcc" ----------------

freq = [3,3,2]

used = {}
deletions = 0

f=3 → not in used → add(3) → used={3}
f=3 → in used → dec→2 → 2 not in used → add → used={3,2}, deletions=1
f=2 → in used → dec→1 → 1 not in used → add → used={3,2,1}, deletions=2

result = 2

-------------------------------------------------------
*/
