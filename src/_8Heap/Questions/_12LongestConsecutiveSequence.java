package _8Heap.Questions;

import java.util.HashSet;

public class _12LongestConsecutiveSequence
{
    public int longestConsecutive(int[] nums)
    {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums)
        {
            set.add(num);
        }

        int longest = 0;

        for (int num : set)
        {
            if (!set.contains(num - 1))
            {
                int currentNum = num;
                int count = 1;

                while (set.contains(currentNum + 1))
                {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    public static void main(String[] args)
    {
        _12LongestConsecutiveSequence obj = new _12LongestConsecutiveSequence();

        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println(obj.longestConsecutive(nums));
    }
}

/*
Problem:
128. Longest Consecutive Sequence

Input:
[100, 4, 200, 1, 3, 2]

Step 1: Put all elements into HashSet
{100, 4, 200, 1, 3, 2}

Step 2: Check sequence start
100 → 99 not present → start
sequence length = 1

4 → 3 present → skip

200 → 199 not present → start
sequence length = 1

1 → 0 not present → start
1 → 2 → 3 → 4
length = 4

Step 3: Take maximum

Output:
4
*/
