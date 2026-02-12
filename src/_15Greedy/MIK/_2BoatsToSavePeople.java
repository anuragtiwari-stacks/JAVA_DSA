package _15Greedy.MIK;

// LeetCode 881 — Boats to Save People

import java.util.Arrays;

public class _2BoatsToSavePeople
{
    public int numRescueBoats(int[] people, int limit)
    {
        Arrays.sort(people);

        int i = 0;
        int j = people.length - 1;

        int boats = 0;

        while(i <= j)
        {
            if(people[i] + people[j] <= limit)
            {
                i = i + 1;
                j = j - 1;

                boats = boats + 1;
            }
            else
            {
                j = j - 1;

                boats = boats + 1;
            }
        }

        return boats;
    }

    public static void main(String[] args)
    {
        _2BoatsToSavePeople obj = new _2BoatsToSavePeople();

        int[] people = {3, 5, 3, 4};
        int limit = 5;

        System.out.println(obj.numRescueBoats(people, limit)); // Output: 4
    }
}

/*
---------------- DRY RUN ----------------

people = [3, 5, 3, 4], limit = 5

After sorting: [3, 3, 4, 5]
i = 0, j = 3, boats = 0

Step 1:
people[i] + people[j] = 3 + 5 = 8 > 5 → not possible together
So assign 5 alone
j = 2
boats = 1

Step 2:
people[i] + people[j] = 3 + 4 = 7 > 5 → not possible together
So assign 4 alone
j = 1
boats = 2

Step 3:
people[i] + people[j] = 3 + 3 = 6 > 5 → not possible together
So assign 3 alone
j = 0
boats = 3

Step 4:
Now i == j == 0
Assign last 3 alone
j = -1
boats = 4

Loop ends

FINAL ANSWER = 4 boats
*/
