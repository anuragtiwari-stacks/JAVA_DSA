package _10Searching;

public class _5FirstLastOccurrence
{
    // Lower Bound: first index with value >= x
    public static int lowerBound(int[] arr, int x)
    {
        int lo = 0, hi = arr.length - 1;
        int lb = arr.length;

        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;

            if (arr[mid] >= x)
            {
                lb = Math.min(mid,lb);
                hi = mid - 1;
            }
            else
            {
                lo = mid + 1;
            }
        }

        return lb;
    }

    // Upper Bound: first index with value > x
    public static int upperBound(int[] arr, int x)
    {
        int lo = 0, hi = arr.length - 1;
        int ub = arr.length;

        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;

            if (arr[mid] > x)
            {
                ub = Math.min(mid,ub);
                hi = mid - 1;
            }
            else
            {
                lo = mid + 1;
            }
        }

        return ub;
    }

    public static void findFirstAndLastOccurrence(int[] arr, int x)
    {
        int lb = lowerBound(arr, x);
        int ub = upperBound(arr, x);

        if (lb == arr.length || arr[lb] != x)
        {
            System.out.println(x + " not found in the array.");
        }
        else
        {
            System.out.println("First Occurrence of " + x + ": " + lb);
            System.out.println("Last Occurrence of " + x + ": " + (ub - 1));
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {10, 20, 30, 30, 30, 40, 50, 60, 703};

        findFirstAndLastOccurrence(arr, 30);
        findFirstAndLastOccurrence(arr, 703);
        findFirstAndLastOccurrence(arr, 25);
    }
}

/*
🔍 Concept Summary:

- Lower Bound: First index where arr[i] >= x
    → Binary search to minimize index satisfying arr[mid] >= x

- Upper Bound: First index where arr[i] > x
    → Binary search to minimize index satisfying arr[mid] > x

- If lowerBound gives index where arr[index] == x → x exists
    → First Occurrence = lowerBound
    → Last Occurrence = upperBound - 1

⌛ Time Complexity: O(log n)
🧠 Space Complexity: O(1)
*/
