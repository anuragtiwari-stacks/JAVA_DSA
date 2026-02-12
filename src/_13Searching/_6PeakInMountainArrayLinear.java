package _13Searching;

public class _6PeakInMountainArrayLinear
{

    public static int findPeak(int[] arr)
    {
        for (int i = 1; i < arr.length - 1; i++)
        {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1])
            {
                return i;
            }
        }

        return -1; // If no peak found (not expected for valid mountain arrays)
    }

    public static void main(String[] args)
    {
        int[] mountainArr = { 1, 3, 8, 12, 9, 5, 2 };
        int peakIndex = findPeak(mountainArr);

        System.out.println("Peak Element Index: " + peakIndex);
        System.out.println("Peak Element Value: " + mountainArr[peakIndex]);
    }
}

/*
🔍 Concept:

In a mountain array, the peak is the element that is greater than both its neighbors.

We loop from index 1 to n-2:
- Check if arr[i] > arr[i-1] and arr[i] > arr[i+1]
- If so, it's the peak → return the index

🕒 Time Complexity: O(n)
📦 Space Complexity: O(1)

Note: This approach works well but is slower than binary search (O(log n)) for large arrays.
*/
