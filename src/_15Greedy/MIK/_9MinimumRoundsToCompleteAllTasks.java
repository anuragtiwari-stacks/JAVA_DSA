package _15Greedy.MIK;

// LeetCode 2244 — Minimum Rounds to Complete All Tasks

import java.util.HashMap;

public class _9MinimumRoundsToCompleteAllTasks
{
    public int minimumRounds(int[] tasks)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int t : tasks)
        {
            if(map.containsKey(t))
            {
                map.put(t, map.get(t) + 1);
            }
            else
            {
                map.put(t, 1);
            }
        }

        int rounds = 0;

        for(int key : map.keySet())
        {
            int count = map.get(key);

            // if a task appears only once, we cannot form a group of 2 or 3
            // so completing all tasks is impossible
            if(count == 1)
            {
                return -1;
            }

            // make maximum groups of 3
            rounds += count / 3;

            // if leftover is 1 or 2, we need one extra round (group of 2)
            if(count % 3 == 1 || count % 3 == 2)
            {
                rounds++;
            }
        }

        return rounds;
    }

    public static void main(String[] args)
    {
        _9MinimumRoundsToCompleteAllTasks obj = new _9MinimumRoundsToCompleteAllTasks();
        int[] tasks = {2,2,3,3,2,4,4,4,4,4};
        System.out.println(obj.minimumRounds(tasks)); // Output: 4
    }
}

/*
---------------- DRY RUN ----------------

tasks = [2,2,3,3,2,4,4,4,4,4]

Frequency:
2 -> 3
3 -> 2
4 -> 5

rounds = 0

For 2: count=3
3/3 = 1, remainder=0
rounds = 1

For 3: count=2
2/3 = 0, remainder=2 -> +1 round
rounds = 2

For 4: count=5
5/3 = 1, remainder=2 -> +1 round
rounds = 4

FINAL ANSWER = 4

-----------------------------------------
*/
