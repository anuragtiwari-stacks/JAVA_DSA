package _13Searching;

public class _8SearchInRotated
{

    public static int search(int[] arr, int target)
    {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;

            if (arr[mid] == target)
            {
                return mid;
            }

            // Check if left half is sorted
            if (arr[lo] <= arr[mid])
            {
                if (target >= arr[lo] && target < arr[mid])
                {
                    hi = mid - 1;
                }
                else
                {
                    lo = mid + 1;
                }
            }
            // Otherwise, right half is sorted
            else
            {
                if (target > arr[mid] && target <= arr[hi])
                {
                    lo = mid + 1;
                }
                else
                {
                    hi = mid - 1;
                }
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

Optimized binary search for rotated sorted array:

- One half (left or right) is always sorted.
- Check if target lies in sorted half:
    → If yes, adjust search to that half
    → If not, search in the other half

🧠 Time Complexity: O(log n)
📦 Space Complexity: O(1)

⚡ No need to find pivot separately — search done in one pass.
*/
