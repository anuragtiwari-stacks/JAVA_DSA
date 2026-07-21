package OA.Infosys;

import java.util.*;

class Main7
{
    public static void main(String[] args)
    {
        /*
         QUESTION:
         You are given an array of N items.

         You have to choose exactly one item every day.

         After choosing an item:
         1. The chosen item cannot be selected again.
         2. The value of every remaining item decreases by 1.
         3. The value of an item cannot decrease below 0.

         Choose the items optimally such that the total value of
         all chosen items is maximum.

         Return the maximum total value modulo 10^9 + 7.


         INPUT:
         4
         5 1 3 5

         OUTPUT:
         10


         EXPLANATION:

         Sort:
         [1, 3, 5, 5]

         Pick from largest to smallest:

         Day 0:
         5 - 0 = 5
         Total = 5

         Day 1:
         5 - 1 = 4
         Total = 5 + 4 = 9

         Day 2:
         3 - 2 = 1
         Total = 9 + 1 = 10

         Day 3:
         1 - 3 = -2
         Value <= 0, so stop.

         Answer = 10
        */

        Scanner sc = new Scanner(System.in);

        // Take size of array
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Take array input
        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        // Sort array in ascending order
        Arrays.sort(arr);

        long ans = 0;

        long mod = 1000000007L;

        int day = 0;

        // Start from largest element
        for(int i = n - 1; i >= 0; i--)
        {
            /*
             Instead of physically decreasing all remaining
             elements by 1 every day, subtract the number
             of days already passed.

             Original Value - Days Passed
            */
            long currentValue = arr[i] - day;

            // No benefit in choosing 0 or negative value
            if(currentValue <= 0)
            {
                break;
            }

            // Add current value to answer
            ans = (ans + currentValue) % mod;

            // One day has passed
            day++;
        }

        System.out.println(ans);

        sc.close();
    }
}

/*
TIME COMPLEXITY:

Arrays.sort() = O(N log N)
Traversal     = O(N)

Total = O(N log N)


WHY GREEDY?

We always choose the largest value first because every unchosen
item loses 1 value after each day.

Therefore, delaying a larger value can cause a greater useful
value to be lost.

Example:

5 1 3 5

Sorted:
1 3 5 5

Largest to smallest:

5 - 0 = 5
5 - 1 = 4
3 - 2 = 1

Total = 5 + 4 + 1 = 10
*/