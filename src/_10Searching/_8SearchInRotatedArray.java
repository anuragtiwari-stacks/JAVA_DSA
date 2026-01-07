package _10Searching;

public class _8SearchInRotatedArray
{

    public static int search(int[] arr, int target)
    {
        int pivot = findPivot(arr);

        // Search in left part
        int left = binarySearch(arr, 0, pivot - 1, target);
        if (left != -1)
        {
            return left;
        }

        // Search in right part
        return binarySearch(arr, pivot, arr.length - 1, target);
    }

    // Step 1: Find the pivot (index of smallest element)
    public static int findPivot(int[] arr)
    {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo < hi)
        {
            int mid = (lo + hi) / 2;

            if (arr[mid] > arr[hi])
            {
                lo = mid + 1;
            }
            else
            {
                hi = mid;
            }
        }

        return lo; // index of minimum element
    }

    // Step 2: Regular binary search
    public static int binarySearch(int[] arr, int lo, int hi, int target)
    {
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;

            if (arr[mid] == target)
            {
                return mid;
            }
            else if (arr[mid] < target)
            {
                lo = mid + 1;
            }
            else
            {
                hi = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args)
    {
        int[] arr = { 15, 18, 2, 3, 6, 12 };
        int target = 3;

        int index = search(arr, target);

        if (index != -1)
        {
            System.out.println("Element found at index: " + index);
        }
        else
        {
            System.out.println("Element not found");
        }
    }
}

/*
🔍 Concept:

Step 1: Find Pivot (smallest element):
- If mid > arr[hi] → pivot lies to the right → lo = mid + 1
- Else → pivot lies to the left → hi = mid

Step 2: Do binary search in both halves:
- Search left: from index 0 to pivot - 1
- Search right: from index pivot to end

🧠 Time Complexity: O(log n)
📦 Space Complexity: O(1)
*/
