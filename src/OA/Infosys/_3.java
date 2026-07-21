package OA.Infosys;

import java.util.*;

/*
==================================================
QUESTION: MAGICAL TOY STORE - MAXIMUM JOY
==================================================

There are N toys arranged from 1 to N.

The price of each toy is stored in array A.

There are Q offers.

Each offer is represented as:

L R

If we select an offer [L, R], we select all toys
from position L to R.

The JOY of an offer is equal to the MEX of the
prices present in that range.


==================================================
WHAT IS MEX?
==================================================

MEX = Smallest non-negative integer which is
not present.

Example:

[0, 1, 2]

0 -> present
1 -> present
2 -> present
3 -> missing

MEX = 3


Example:

[0, 2, 3]

0 -> present
1 -> missing

MEX = 1


==================================================
IMPORTANT CONDITION
==================================================

We can select multiple offers.

But selected offers must NOT overlap.

We have to find the maximum total JOY.


==================================================
INPUT FORMAT
==================================================

First line:

N

Next N lines:

Array elements / toy prices

Next line:

Q

Next Q lines:

L R


==================================================
SAMPLE INPUT
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
SAMPLE OUTPUT
==================================================

4


==================================================
YOUR APPROACH
==================================================

1. Store N.

2. Store complete array.

3. Store Q.

4. Store all Q offers.

5. After taking all input, call maximumJoy().

6. For each offer, call findMex().

7. MEX of an offer = JOY of that offer.

8. If current offer does not overlap with the
   previously selected offer:

   Add its JOY.

9. If current offer overlaps:

   Compare the JOY of both.

   Keep the offer having maximum JOY.

10. Print total JOY.


NOTE:

This code follows the simple greedy idea.

It may NOT pass all test cases because choosing the
maximum between two overlapping offers does not always
give the globally maximum total JOY.
*/


class MainYourApproach
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);


        // Input N

        int N = sc.nextInt();


        // Store complete array

        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
        {
            arr[i] = sc.nextInt();
        }


        // Input Q

        int Q = sc.nextInt();


        // Store all offers

        int[][] offers = new int[Q][2];

        for(int i = 0; i < Q; i++)
        {
            offers[i][0] = sc.nextInt();

            offers[i][1] = sc.nextInt();
        }


        // Function call after all input

        long answer = maximumJoy(arr, offers);


        System.out.println(answer);
    }


    static long maximumJoy(int[] arr, int[][] offers)
    {
        int Q = offers.length;


        // Store:
        //
        // index 0 = left
        // index 1 = right
        // index 2 = joy

        int[][] data = new int[Q][3];


        // Find MEX / JOY of every offer

        for(int i = 0; i < Q; i++)
        {
            int left = offers[i][0];

            int right = offers[i][1];


            int joy = findMex(arr, left, right);


            data[i][0] = left;

            data[i][1] = right;

            data[i][2] = joy;
        }


        // Sort offers according to starting position

        Arrays.sort(data, (a, b) ->
                Integer.compare(a[0], b[0]));


        long totalJoy = 0;


        int lastLeft = -1;

        int lastRight = -1;

        int lastJoy = 0;


        for(int i = 0; i < Q; i++)
        {
            int currentLeft = data[i][0];

            int currentRight = data[i][1];

            int currentJoy = data[i][2];


            // First offer

            if(lastLeft == -1)
            {
                totalJoy = currentJoy;


                lastLeft = currentLeft;

                lastRight = currentRight;

                lastJoy = currentJoy;
            }


            // No overlap

            else if(currentLeft > lastRight)
            {
                totalJoy = totalJoy + currentJoy;


                lastLeft = currentLeft;

                lastRight = currentRight;

                lastJoy = currentJoy;
            }


            // Overlap

            else
            {
                // Keep offer with maximum JOY

                if(currentJoy > lastJoy)
                {
                    totalJoy = totalJoy - lastJoy;


                    totalJoy = totalJoy + currentJoy;


                    lastLeft = currentLeft;

                    lastRight = currentRight;

                    lastJoy = currentJoy;
                }
            }
        }


        return totalJoy;
    }


    static int findMex(int[] arr, int left, int right)
    {
        HashSet<Integer> set = new HashSet<>();


        // Offer positions are 1-based
        // Array indexes are 0-based

        for(int i = left - 1; i <= right - 1; i++)
        {
            set.add(arr[i]);
        }


        int mex = 0;


        while(set.contains(mex))
        {
            mex++;
        }


        return mex;
    }
}


/*

==================================================
SAMPLE INPUT
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
SAMPLE OUTPUT
==================================================

4


==================================================
MEX CALCULATION
==================================================

Array:

[1, 0, 2, 3]


Offer 1:

[1, 3]

Elements:

[1, 0, 2]

0 -> present
1 -> present
2 -> present
3 -> missing

MEX = 3

JOY = 3


----------------------------------------


Offer 2:

[1, 4]

Elements:

[1, 0, 2, 3]

0 -> present
1 -> present
2 -> present
3 -> present
4 -> missing

MEX = 4

JOY = 4


Both offers overlap.

Maximum JOY:

Math.max(3, 4)

= 4


OUTPUT:

4

*/