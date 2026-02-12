package _13Searching;

/*
QUESTION:
LeetCode 2064 – Minimized Maximum of Products Distributed to Any Store

You are given:
- n = number of stores
- quantities[] = number of products of each type

Rules:
1. Each store can receive at most ONE product type.
2. A product type can be distributed across multiple stores.
3. Let x be the maximum number of products given to any store.
4. Minimize x.

Return the minimum possible value of x.

Example:
n = 6
quantities = [11, 6]
Output = 3
*/

public class _15MinimizedMaximumProducts
{
    // Check if distribution is possible with max x products per store
    public static boolean isPossible(int maxPerStore, int n, int[] quantities)
    {
        int storesNeeded = 0;

        for (int q : quantities)
        {
            // ceil(q / maxPerStore)
            storesNeeded += (q + maxPerStore - 1) / maxPerStore;
        }

        return storesNeeded <= n;
    }

    // Binary Search on answer
    public static int minimizedMaximum(int n, int[] quantities)
    {
        int lo = 1;
        int hi = 0;

        // Upper bound = max element in quantities
        for (int q : quantities)
        {
            hi = Math.max(hi, q);
        }

        int ans = hi;

        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;

            if (isPossible(mid, n, quantities))
            {
                ans = mid;      // possible answer
                hi = mid - 1;   // try smaller x
            }
            else
            {
                lo = mid + 1;   // need bigger x
            }
        }

        return ans;
    }

    // -------- MAIN METHOD (FOR IDE RUN) --------
    public static void main(String[] args)
    {
        int n = 6;
        int[] quantities = {11, 6};

        System.out.println(
                "Minimum possible maximum products per store: "
                        + minimizedMaximum(n, quantities)
        );
    }
}

/*
====================== FULL DRY RUN ======================

Input:
n = 6
quantities = {11, 6}

--------------------------------------------------------
Step 1: Binary Search Space
lo = 1
hi = max(quantities) = 11
ans = 11

--------------------------------------------------------
Iteration 1:
mid = (1 + 11) / 2 = 6

Check isPossible(6):
11 → ceil(11/6) = 2 stores
6  → ceil(6/6)  = 1 store
Total stores = 3 ≤ 6  ✅

Possible
ans = 6
hi = 5

--------------------------------------------------------
Iteration 2:
lo = 1, hi = 5
mid = (1 + 5) / 2 = 3

Check isPossible(3):
11 → ceil(11/3) = 4 stores
6  → ceil(6/3)  = 2 stores
Total stores = 6 ≤ 6  ✅

Possible
ans = 3
hi = 2

--------------------------------------------------------
Iteration 3:
lo = 1, hi = 2
mid = (1 + 2) / 2 = 1

Check isPossible(1):
11 → 11 stores
6  → 6 stores
Total = 17 > 6  ❌

Not Possible
lo = 2

--------------------------------------------------------
Iteration 4:
lo = 2, hi = 2
mid = 2

Check isPossible(2):
11 → ceil(11/2) = 6
6  → ceil(6/2)  = 3
Total = 9 > 6  ❌

Not Possible
lo = 3

--------------------------------------------------------
Loop Ends (lo > hi)

FINAL ANSWER:
ans = 3

========================================================
*/

/*
TIME COMPLEXITY:
O(m log max(quantities))

SPACE COMPLEXITY:
O(1)
*/
