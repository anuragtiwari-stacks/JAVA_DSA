package _12Greedy.MIK;

// LeetCode 621: Task Scheduler

import java.util.*;

public class _25TaskScheduler
{
    public int leastInterval(char[] tasks, int n)
    {
        int[] freq = new int[26];

        for (char c : tasks)
        {
            freq[c - 'A']++; // IMPORTANT: use 'A' for uppercase input
        }

        Arrays.sort(freq); // sort by frequency ascending

        int maxFreq = freq[25] - 1; // max frequency minus 1
        int idleSlots = maxFreq * n; // total idle slots we need to fill

        // fill idle slots using other task frequencies
        for (int i = 24; i >= 0; i--)
        {
            idleSlots -= Math.min(freq[i], maxFreq);
        }

        // Without ternary operator
        if (idleSlots > 0)
        {
            return tasks.length + idleSlots;
        }
        else
        {
            return tasks.length;
        }
    }

    public static void main(String[] args)
    {
        _25TaskScheduler obj = new _25TaskScheduler();

        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;

        System.out.println("Output: " + obj.leastInterval(tasks, n));
    }
}


/*
===================== DRY RUN =====================

Input:
tasks = ['A','A','A','B','B','B'], n = 2

Step-1: Count freq:
freq['A'] = 3
freq['B'] = 3

After sorting:
[0,0,0,...,3,3]

Step-2:
maxFreq = freq[25] - 1 = 3 - 1 = 2

Step-3:
idleSlots = maxFreq * n = 2 * 2 = 4

Step-4:
Fill idle slots using other tasks:

i = 24 -> freq[i] = 3 (B)
idleSlots = 4 - min(3,2) = 4 - 2 = 2

Since remaining slots = 2 and no more reducing tasks,

Step-5:
idleSlots > 0 → true

Final Result = tasks.length + idleSlots
              = 6 + 2
              = 8

Possible CPU schedule:
A B _ A B _ A B
= 8 intervals

===================================================
*/
