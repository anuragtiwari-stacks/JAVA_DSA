package _10Searching;

public class _6PeakInMountainArray
{
    public static int findPeak(int[] arr)
    {
        int left = 0;
        int right = arr.length - 1;

        while (left < right)
        {
            int mid = (left + right) / 2;

            if (arr[mid] < arr[mid + 1])
            {
                // Increasing slope → move right
                left = mid + 1;
            }
            else
            {
                // Decreasing slope → move left
                right = mid;
            }
        }

        return left; // Peak index
    }

    public static void main(String[] args)
    {
        int[] mountainArr = {1, 3, 8, 12, 9, 5, 2};
        int peakIndex = findPeak(mountainArr);

        System.out.println("Peak Element Index: " + peakIndex);
        System.out.println("Peak Element Value: " + mountainArr[peakIndex]);
    }
}

/*
====================== DRY RUN ======================

Array: {1, 3, 8, 12, 13, 5, 2}

Index:  0  1  2   3   4   5  6
Value:  1  3  8  12  13   5  2

----------------------------------------------------
Initial:
lo = 0, hi = 6

Iteration 1:
mid = (0 + 6) / 2 = 3
arr[mid] = 12, arr[mid+1] = 13
12 < 13 → Increasing slope
lo = mid + 1 = 4

Iteration 2:
lo = 4, hi = 6
mid = (4 + 6) / 2 = 5
arr[mid] = 5, arr[mid+1] = 2
5 > 2 → Decreasing slope
hi = mid = 5

Iteration 3:
lo = 4, hi = 5
mid = (4 + 5) / 2 = 4
arr[mid] = 13, arr[mid+1] = 5
13 > 5 → Decreasing slope
hi = mid = 4

----------------------------------------------------
Loop Ends: lo == hi == 4

Result:
Peak Index = 4
Peak Value = 13

====================================================
*/

/*
🔍 Concept:

This uses **Binary Search** on a "mountain array" (strictly increasing to peak, then decreasing):

- If arr[mid] < arr[mid + 1], we are in the **increasing slope**, so move right (lo = mid + 1)
- If arr[mid] > arr[mid + 1], we are in the **decreasing slope**, so move left (hi = mid)

Loop continues until lo == hi → index of peak

🧠 Time Complexity: O(log n)
📦 Space Complexity: O(1)
*/
