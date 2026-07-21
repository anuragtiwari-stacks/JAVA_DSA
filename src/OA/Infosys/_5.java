package OA.Infosys;

import java.util.*;

/*
==================================================
QUESTION: MINIMUM ADJACENT SWAPS TO MAKE PAIRS
==================================================

You are given an array A of size N.

It is guaranteed that:

1. N is even.

2. Each distinct value appears in the array
   exactly twice.


In one operation:

You can choose any two ADJACENT elements
and swap them.


Find the MINIMUM number of operations required
such that every pair of equal numbers becomes adjacent.


==================================================
INPUT FORMAT
==================================================

First line:

N = Number of elements


Next N lines:

Array elements


==================================================
SAMPLE INPUT 1
==================================================

4
1
1
2
2


==================================================
SAMPLE OUTPUT 1
==================================================

0


==================================================
EXPLANATION
==================================================

Array:

[1, 1, 2, 2]

1, 1 are already adjacent.

2, 2 are already adjacent.

Therefore:

Swaps = 0


==================================================
SAMPLE INPUT 2
==================================================

4
1
2
1
2


==================================================
SAMPLE OUTPUT 2
==================================================

1


==================================================
EXPLANATION
==================================================

Array:

[1, 2, 1, 2]

Start from:

i = 0


Compare:

arr[0] = 1
arr[1] = 2

They are not equal.


Find another 1.

Another 1 is at index 2.


Now swap adjacent elements:

arr[1] and arr[2]


Before:

[1, 2, 1, 2]


After:

[1, 1, 2, 2]


count = 1


Now all equal elements are adjacent.

Answer = 1


==================================================
OUR APPROACH
==================================================

1. Take N and store the complete array.

2. After input, call minimumSwaps() function.

3. Start traversal from i = 0.

4. Compare:

   arr[i] and arr[i + 1]


5. If:

   arr[i] == arr[i + 1]

   Pair is already formed.

   Move to next pair using:

   i = i + 2


6. If:

   arr[i] != arr[i + 1]

   Find the matching element of arr[i]
   in the remaining array.


7. Suppose matching element is at index j.

   Bring arr[j] towards arr[i + 1]
   using adjacent swaps.


8. For every adjacent swap:

   count++


9. After matching element reaches i + 1:

   arr[i] == arr[i + 1]


10. Move to the next pair.


11. Return count.
*/


class Main5
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


        // Function call after input

        int answer = minimumSwaps(arr);


        System.out.println(answer);
    }


    static int minimumSwaps(int[] arr)
    {
        int count = 0;


        // Check elements pair by pair

        for(int i = 0; i < arr.length; i = i + 2)
        {

            // If arr[i] and arr[i+1]
            // are already equal

            if(arr[i] == arr[i + 1])
            {
                continue;
            }


            // If they are not equal,
            // find matching element of arr[i]

            int j = i + 2;


            while(j < arr.length)
            {
                if(arr[j] == arr[i])
                {
                    break;
                }

                j++;
            }


            // Bring matching element
            // towards i + 1 using adjacent swaps

            while(j > i + 1)
            {
                int temp = arr[j];

                arr[j] = arr[j - 1];

                arr[j - 1] = temp;


                // One adjacent swap performed

                count++;


                // Matching element moved
                // one position towards left

                j--;
            }
        }


        return count;
    }
}


/*

==================================================
SAMPLE INPUT
==================================================

6
1
2
3
1
2
3


==================================================
DRY RUN
==================================================

Initial Array:

[1, 2, 3, 1, 2, 3]


------------------------------------------
STEP 1
------------------------------------------

i = 0


Compare:

arr[0] = 1

arr[1] = 2


1 != 2


So find another 1.


Another 1 is at:

j = 3


Array:

[1, 2, 3, 1, 2, 3]
 ↑        ↑
 i        j


Now bring 1 towards i + 1.


------------------------------------------

Swap arr[3] and arr[2]


Before:

[1, 2, 3, 1, 2, 3]


After:

[1, 2, 1, 3, 2, 3]


count = 1


------------------------------------------

Now j = 2


Swap arr[2] and arr[1]


Before:

[1, 2, 1, 3, 2, 3]


After:

[1, 1, 2, 3, 2, 3]


count = 2


Now:

arr[0] == arr[1]

1 == 1


First pair complete.


------------------------------------------
STEP 2
------------------------------------------

i = 2


Current Array:

[1, 1, 2, 3, 2, 3]


Compare:

arr[2] = 2

arr[3] = 3


2 != 3


Find another 2.


Another 2 is at:

j = 4


Swap:

arr[4] and arr[3]


Before:

[1, 1, 2, 3, 2, 3]


After:

[1, 1, 2, 2, 3, 3]


count = 3


Now:

arr[2] == arr[3]

2 == 2


Second pair complete.


------------------------------------------
STEP 3
------------------------------------------

i = 4


arr[4] = 3

arr[5] = 3


Already equal.

No swap required.


==================================================
FINAL ARRAY
==================================================

[1, 1, 2, 2, 3, 3]


==================================================
OUTPUT
==================================================

3


==================================================
MAIN LOGIC TO REMEMBER
==================================================

if(arr[i] == arr[i + 1])
{
    continue;
}


If not equal:

Find another arr[i]:

while(arr[j] != arr[i])
{
    j++;
}


Then adjacent swaps:

while(j > i + 1)
{
    swap arr[j] with arr[j - 1];

    count++;

    j--;
}


==================================================
TIME COMPLEXITY
==================================================

Worst Case:

O(N^2)


==================================================
SPACE COMPLEXITY
==================================================

O(1)

*/