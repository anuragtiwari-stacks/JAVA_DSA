package OA.Infosys;

import java.util.*;

/*
==================================================
QUESTION: MAGICAL TOY STORE - MAXIMUM JOY
==================================================

There are N toys arranged from 1 to N.

The price of each toy is stored in array A.

There are Q offers.

Each offer is:

L R

If offer [L, R] is selected, all toys from
position L to R are selected.

JOY of an offer:

JOY = MEX of prices in range [L, R]

Multiple offers can be selected.

CONDITION:

SELECTED OFFERS MUST NOT OVERLAP.

Find the MAXIMUM TOTAL JOY.


==================================================
MEX
==================================================

MEX = Smallest non-negative integer
which is not present.

Example:

[0, 1, 2]

0 -> present
1 -> present
2 -> present
3 -> missing

MEX = 3


Example:

[1, 2, 3]

0 -> missing

MEX = 0


==================================================
MAIN IDEA
==================================================

1. Take array input.

2. Take all offers.

3. For every offer [L, R],
   calculate its MEX.

   MEX = JOY

4. Store:

   data[i][0] = Left
   data[i][1] = Right
   data[i][2] = Joy

5. Sort data according to RIGHT.

6. Apply PICK / SKIP DP.

SKIP:

dp[i] = dp[i - 1]


PICK:

pick = currentJoy

If previous non-overlapping offer exists:

pick = currentJoy + dp[previous + 1]


Finally:

dp[i] = Math.max(dp[i], pick);
*/


class MainDP
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);


        // ==============================
        // INPUT N
        // ==============================

        int N = sc.nextInt();


        // ==============================
        // INPUT ARRAY
        // ==============================

        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
        {
            arr[i] = sc.nextInt();
        }


        // ==============================
        // INPUT NUMBER OF OFFERS
        // ==============================

        int Q = sc.nextInt();


        // ==============================
        // INPUT ALL OFFERS
        // ==============================

        int[][] offers = new int[Q][2];

        for(int i = 0; i < Q; i++)
        {
            offers[i][0] = sc.nextInt();

            offers[i][1] = sc.nextInt();
        }


        // ==============================
        // FUNCTION CALL
        // ==============================

        long answer = maximumJoy(arr, offers);


        // ==============================
        // OUTPUT
        // ==============================

        System.out.println(answer);

        sc.close();
    }


    static long maximumJoy(int[] arr, int[][] offers)
    {
        int Q = offers.length;


        /*
        ==========================================
        DATA ARRAY
        ==========================================

        Every row stores:

        data[i][0] = LEFT
        data[i][1] = RIGHT
        data[i][2] = JOY
        */

        int[][] data = new int[Q][3];


        // ==========================================
        // CALCULATE JOY / MEX FOR EVERY OFFER
        // ==========================================

        for(int i = 0; i < Q; i++)
        {
            int left = offers[i][0];

            int right = offers[i][1];


            // Calculate MEX

            int joy = findMex(arr, left, right);


            // Store left, right and joy

            data[i][0] = left;

            data[i][1] = right;

            data[i][2] = joy;
        }


        /*
        ==========================================
        SORT ACCORDING TO RIGHT / END POSITION
        ==========================================

        Example:

        Before:

        L   R   Joy

        1   8    5
        2   5    6
        4   6    4


        After:

        L   R   Joy

        2   5    6
        4   6    4
        1   8    5
        */

        Arrays.sort(data,
                (a, b) -> Integer.compare(a[1], b[1]));


        /*
        ==========================================
        DP
        ==========================================

        dp[i]

        = Maximum total JOY using
          first i offers


        dp[0] = 0

        because:

        0 offers -> 0 joy
        */

        long[] dp = new long[Q + 1];


        // ==========================================
        // FILL DP
        // ==========================================

        for(int i = 1; i <= Q; i++)
        {
            /*
            Current offer is:

            data[i - 1]

            because data is 0-based
            and dp is shifted by 1.
            */

            int currentLeft = data[i - 1][0];

            int currentJoy = data[i - 1][2];


            /*
            ======================================
            FIND PREVIOUS NON-OVERLAPPING OFFER
            ======================================

            Condition:

            previousRight < currentLeft


            Example:

            Previous:
            [1------3]

            Current:
                     [4------6]

            3 < 4

            So they do NOT overlap.
            */

            int previous = -1;


            for(int j = i - 2; j >= 0; j--)
            {
                if(data[j][1] < currentLeft)
                {
                    previous = j;

                    break;
                }
            }


            /*
            ======================================
            SKIP CURRENT OFFER
            ======================================

            Exactly like Knapsack:

            Current offer MAT LO.

            So previous best answer
            remains the answer.

            SKIP:

            dp[i] = dp[i - 1]
            */

            dp[i] = dp[i - 1];


            /*
            ======================================
            PICK CURRENT OFFER
            ======================================

            Current offer LO.

            Initially:

            pick = currentJoy
            */

            long pick = currentJoy;


            /*
            If previous non-overlapping
            offer exists:

            PICK =

            currentJoy
                 +
            maximum joy available up to
            previous non-overlapping offer
            */

            if(previous != -1)
            {
                pick = pick + dp[previous + 1];
            }


            /*
            ======================================
            PICK vs SKIP
            ======================================

            dp[i] currently contains SKIP.

            So compare:

            SKIP = dp[i]

            PICK = pick

            Store maximum.
            */

            dp[i] = Math.max(dp[i], pick);
        }


        // Maximum Joy using all Q offers

        return dp[Q];
    }


    static int findMex(int[] arr, int left, int right)
    {
        HashSet<Integer> set = new HashSet<>();


        /*
        Offer positions are 1-based.

        Convert them to 0-based indexes.

        [left, right]

        becomes:

        [left - 1, right - 1]
        */

        for(int i = left - 1; i <= right - 1; i++)
        {
            set.add(arr[i]);
        }


        int mex = 0;


        // Find smallest missing non-negative integer

        while(set.contains(mex))
        {
            mex++;
        }


        return mex;
    }
}


/*

==================================================
SAMPLE INPUT 1
==================================================

2
0
1
1
1 2


==================================================
SAMPLE OUTPUT 1
==================================================

2


==================================================
SAMPLE INPUT 2
==================================================

4
1
0
2
3
2
1 3
1 4


==================================================
SAMPLE OUTPUT 2
==================================================

4


==================================================
DP PATTERN TO REMEMBER
==================================================


0/1 KNAPSACK:

// SKIP

dp[i][w] = dp[i - 1][w];


// PICK

if(wt[i - 1] <= w)
{
    dp[i][w] = Math.max(
        dp[i][w],
        val[i - 1]
        +
        dp[i - 1][w - wt[i - 1]]
    );
}


==================================================

MAXIMUM JOY:

// SKIP

dp[i] = dp[i - 1];


// PICK

long pick = currentJoy;

if(previous != -1)
{
    pick = pick + dp[previous + 1];
}


// PICK vs SKIP

dp[i] = Math.max(dp[i], pick);


==================================================

MAIN DIFFERENCE:

KNAPSACK PICK:

current value
+
answer from remaining capacity


MAXIMUM JOY PICK:

current joy
+
answer up to previous
non-overlapping offer


==================================================

IMPORTANT:

dp[i] = dp[i - 1];

means:

SKIP CURRENT OFFER


pick = currentJoy + dp[previous + 1];

means:

PICK CURRENT OFFER
+
take the already calculated best answer
up to the previous non-overlapping offer


Then:

dp[i] = Math.max(dp[i], pick);

means:

PICK aur SKIP me jo maximum hai,
use store karo.

==================================================

*/