package _9SlidingWindow;

public class _7GrumpyBookstoreOwner
{
    public int maxSatisfied(int[] arr, int[] grumpy, int k)
    {
        int n = arr.length;
        int i = 0, j = 0;
        int unsatisfied = 0;
        int maxUnsatisfied = 0;
        int a = 0, b = 0;

        // Initial window of size k
        while (j < k)
        {
            if (grumpy[j] == 1)
            {
                unsatisfied += arr[j];
            }
            j++;
        }

        maxUnsatisfied = unsatisfied;
        a = i;
        b = j - 1;

        // Sliding window
        while (j < n)
        {
            if (grumpy[i] == 1)
            {
                unsatisfied -= arr[i];
            }

            if (grumpy[j] == 1)
            {
                unsatisfied += arr[j];
            }

            i++;
            j++;

            if (unsatisfied > maxUnsatisfied)
            {
                maxUnsatisfied = unsatisfied;
                a = i;
                b = j - 1;
            }
        }

        // Apply secret technique (make grumpy = 0 in best window)
        for (int x = a; x <= b; x++)
        {
            grumpy[x] = 0;
        }

        // Calculate total satisfied customers
        int satisfied = 0;
        for (int x = 0; x < n; x++)
        {
            if (grumpy[x] == 0)
            {
                satisfied += arr[x];
            }
        }

        return satisfied;
    }

    public static void main(String[] args)
    {
        _7GrumpyBookstoreOwner sol = new _7GrumpyBookstoreOwner();

        int[] customers1 = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy1    = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes1 = 3;

        System.out.println(sol.maxSatisfied(customers1, grumpy1, minutes1)); // Expected: 16
    }
}

/*
======================== DRY RUN ========================

Input:
customers = [1,0,1,2,1,1,7,5]
grumpy    = [0,1,0,1,0,1,0,1]
k = 3

--------------------------------------------------------
STEP 1: Initial window (0 to 2)
--------------------------------------------------------
j = 0 -> grumpy[0]=0 → unsatisfied = 0
j = 1 -> grumpy[1]=1 → unsatisfied = 0
j = 2 -> grumpy[2]=0 → unsatisfied = 0

maxUnsatisfied = 0
window = [0..2]

--------------------------------------------------------
STEP 2: Slide window
--------------------------------------------------------

Window [1..3]
remove i=0 (grumpy=0) → unsatisfied = 0
add j=3 (grumpy=1) → unsatisfied = 2
maxUnsatisfied = 2
best window = [1..3]

Window [2..4]
remove i=1 (grumpy=1) → unsatisfied = 2
add j=4 (grumpy=0) → unsatisfied = 2

Window [3..5]
remove i=2 (grumpy=0) → unsatisfied = 2
add j=5 (grumpy=1) → unsatisfied = 3
maxUnsatisfied = 3
best window = [3..5]

Window [4..6]
remove i=3 (grumpy=1) → unsatisfied = 1
add j=6 (grumpy=0) → unsatisfied = 1

Window [5..7]
remove i=4 (grumpy=0) → unsatisfied = 1
add j=7 (grumpy=1) → unsatisfied = 6
maxUnsatisfied = 6
best window = [5..7]

--------------------------------------------------------
STEP 3: Make grumpy = 0 in window [5..7]
--------------------------------------------------------
grumpy becomes:
[0,1,0,1,0,0,0,0]

--------------------------------------------------------
STEP 4: Count satisfied customers
--------------------------------------------------------
Index-wise sum where grumpy == 0:
1 + 1 + 1 + 1 + 7 + 5 = 16

--------------------------------------------------------
Final Answer = 16 ✅
========================================================
*/
