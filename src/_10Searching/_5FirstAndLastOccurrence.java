package _10Searching;

public class _5FirstAndLastOccurrence
{

    public static int findFirst(int[] arr, int target)
    {
        int lo = 0, hi = arr.length - 1;
        int first = -1;

        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;

            if (arr[mid] == target)
            {
                first = mid;
                hi = mid - 1;
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

        return first;
    }

    public static int findLast(int[] arr, int target)
    {
        int lo = 0, hi = arr.length - 1;
        int last = -1;

        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;

            if (arr[mid] == target)
            {
                last = mid;
                lo = mid + 1;
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

        return last;
    }

    public static void main(String[] args)
    {
        int[] arr = { 10, 10, 20, 20, 20, 20, 20, 30, 30, 30, 40, 40 };
        int target = 20;

        int first = findFirst(arr, target);
        int last = findLast(arr, target);

        if (first == -1)
        {
            System.out.println("Element " + target + " not found.");
        }
        else
        {
            System.out.println("First Occurrence of " + target + ": " + first);
            System.out.println("Last Occurrence of " + target + ": " + last);
        }
    }
}

/*
🔍 Concept Summary:

✅ First Occurrence:
- If arr[mid] == target → store mid, search left (hi = mid - 1)
- Else if arr[mid] < target → search right
- Else → search left

✅ Last Occurrence:
- If arr[mid] == target → store mid, search right (lo = mid + 1)
- Else if arr[mid] < target → search right
- Else → search left

🕒 Time Complexity: O(log n)
🧠 Space Complexity: O(1)
*/
