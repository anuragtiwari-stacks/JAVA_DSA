package _13Searching;

public class _12CapacityToShipWithinDays
{
    // Check if shipping is possible with given capacity
    public static boolean isPossible(int cap, int[] arr, int d)
    {
        int days = 1;
        int load = 0;

        for (int weight : arr)
        {
            if (load + weight <= cap)
            {
                load += weight;
            }
            else
            {
                days++;
                load = weight;
            }
        }

        return days <= d;
    }

    // Binary search to find minimum capacity
    public static int shipWithinDays(int[] arr, int d)
    {
        int lo = 0, hi = 0;

        // Search space
        for (int w : arr)
        {
            lo = Math.max(lo, w); // max element
            hi += w;              // sum of array
        }

        int ans = hi;

        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;

            if (isPossible(mid, arr, d))
            {
                ans = mid;
                hi = mid - 1;
            }
            else
            {
                lo = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        System.out.println("Minimum Capacity: " + shipWithinDays(arr, days));
    }
}

/*
====================== FULL DRY RUN ======================

Problem:
arr = {1,2,3,4,5,6,7,8,9,10}
days = 5

--------------------------------------------------------
STEP 1: Search Space
lo = max(arr) = 10
hi = sum(arr) = 55
ans = 55

--------------------------------------------------------
Iteration 1:
mid = (10 + 55) / 2 = 32

Check isPossible(32):
Day 1: 1+2+3+4+5+6+7 = 28
Day 2: 8+9+10 = 27
Total days = 2 ≤ 5 ✅

→ Possible
ans = 32
hi = 31

--------------------------------------------------------
Iteration 2:
lo = 10, hi = 31
mid = (10 + 31) / 2 = 20

Check isPossible(20):
Day 1: 1+2+3+4+5 = 15
Day 2: 6+7 = 13
Day 3: 8+9 = 17
Day 4: 10
Total days = 4 ≤ 5 ✅

→ Possible
ans = 20
hi = 19

--------------------------------------------------------
Iteration 3:
lo = 10, hi = 19
mid = (10 + 19) / 2 = 14

Check isPossible(14):
Day 1: 1+2+3+4 = 10
Day 2: 5+6 = 11
Day 3: 7
Day 4: 8
Day 5: 9
Day 6: 10
Total days = 6 > 5 ❌

→ Not Possible
lo = 15

--------------------------------------------------------
Iteration 4:
lo = 15, hi = 19
mid = (15 + 19) / 2 = 17

Check isPossible(17):
Day 1: 1+2+3+4+5 = 15
Day 2: 6+7 = 13
Day 3: 8+9 = 17
Day 4: 10
Total days = 4 ≤ 5 ✅

→ Possible
ans = 17
hi = 16

--------------------------------------------------------
Iteration 5:
lo = 15, hi = 16
mid = (15 + 16) / 2 = 15

Check isPossible(15):
Day 1: 1+2+3+4+5 = 15
Day 2: 6+7 = 13
Day 3: 8
Day 4: 9
Day 5: 10
Total days = 5 ≤ 5 ✅

→ Possible
ans = 15
hi = 14

--------------------------------------------------------
Loop Ends (lo > hi)

FINAL ANSWER:
Minimum Capacity = 15

========================================================
*/
