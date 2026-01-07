package _10Searching;

public class _11SmallestDivisorBinarySearch
{
    public static int smallestDivisor(int[] arr, int threshold)
    {
        int lo = 1;
        int hi = getMax(arr);
        int ans = hi;

        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;

            int sum = getSum(arr, mid);

            if (sum <= threshold)
            {
                ans = mid;      // possible answer
                hi = mid - 1;   // try smaller divisor
            }
            else
            {
                lo = mid + 1;   // need bigger divisor
            }
        }

        return ans;
    }

    // Calculate sum of ceil(arr[i] / divisor)
    private static int getSum(int[] arr, int divisor)
    {
        int sum = 0;

        for (int value : arr)
        {
            if (value % divisor == 0) sum += value / divisor;
            else sum += (value / divisor) + 1;
        }

        return sum;
    }

    // Find maximum element
    private static int getMax(int[] arr)
    {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args)
    {
        int[] arr1 = {1, 2, 5, 9};
        int threshold1 = 6;
        System.out.println("Smallest divisor: " + smallestDivisor(arr1, threshold1));

        int[] arr2 = {44, 22, 33, 11, 1};
        int threshold2 = 5;
        System.out.println("Smallest divisor: " + smallestDivisor(arr2, threshold2));
    }
}

/*
====================== DRY RUN ======================

Example:
arr = {1, 2, 5, 9}
threshold = 6

Step 1: Search space
lo = 1
hi = max(arr) = 9
ans = 9

----------------------------------------------------
Iteration 1:
mid = (1 + 9) / 2 = 5

Compute sum with divisor = 5
ceil(1/5)=1
ceil(2/5)=1
ceil(5/5)=1
ceil(9/5)=2
sum = 5  (≤ 6 ✅)

Possible answer → ans = 5
Try smaller divisor → hi = 4

----------------------------------------------------
Iteration 2:
lo = 1, hi = 4
mid = (1 + 4) / 2 = 2

sum with divisor = 2
ceil(1/2)=1
ceil(2/2)=1
ceil(5/2)=3
ceil(9/2)=5
sum = 10  (> 6 ❌)

Need bigger divisor → lo = 3

----------------------------------------------------
Iteration 3:
lo = 3, hi = 4
mid = (3 + 4) / 2 = 3

sum with divisor = 3
ceil(1/3)=1
ceil(2/3)=1
ceil(5/3)=2
ceil(9/3)=3
sum = 7  (> 6 ❌)

Need bigger divisor → lo = 4

----------------------------------------------------
Iteration 4:
lo = 4, hi = 4
mid = 4

sum with divisor = 4
ceil(1/4)=1
ceil(2/4)=1
ceil(5/4)=2
ceil(9/4)=3
sum = 7  (> 6 ❌)

Need bigger divisor → lo = 5

----------------------------------------------------
Loop ends (lo > hi)

Final Answer = ans = 5

====================================================
*/
