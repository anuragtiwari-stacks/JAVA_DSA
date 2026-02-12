package _15Greedy.MIK;

// LeetCode 3075: Maximize Happiness of Selected Children

import java.util.*;

public class _26MaximizeHappiness
{
    public long maximumHappinessSum(int[] happiness, int k)
    {
        Arrays.sort(happiness);
        long sum = 0;
        int end = happiness.length - 1;

        while (k > 0 )
        {
            sum = sum + happiness[end];

            for (int i = 0; i < end; i++)
            {
                if (happiness[i] > 0)
                {
                    happiness[i]--;
                }
            }

            k--;
            end--;
        }

        return sum;
    }

    public static void main(String[] args)
    {
        _26MaximizeHappiness obj = new _26MaximizeHappiness();

        int[] arr = {1, 2, 3, 4};
        int k = 2;

        System.out.println("Output: " + obj.maximumHappinessSum(arr, k));
    }
}


/*
===================== DRY RUN =====================

Input:
arr = [1,2,3,4], k = 2

Step-1: Sort:
[1,2,3,4]

end = 3, sum = 0

Iteration-1:
take happiness[end] = 4
sum = 4

decrement previous:
[1,2,3] -> [0,1,2]

k = 1, end = 2

Iteration-2:
take happiness[end] = 2
sum = 6

decrement previous:
[0,1] -> [0,0]

k = 0, end = 1

Stop because k == 0

Final Result = 6

===================================================
*/
