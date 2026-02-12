package _13Searching;

public class _14KthMissingBinarySearch
{
    public static int findKthPositive(int[] arr, int k)
    {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high)
        {
            int mid = (low + high) / 2;

            // Missing numbers before arr[mid]
            int missing = arr[mid] - (mid + 1);

            if (missing < k)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }

        // kth missing number
        return low + k;
    }

    public static void main(String[] args)
    {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;

        System.out.println("The " + k + "th missing number is: " + findKthPositive(arr, k));
    }
}

/*
====================== DRY RUN ======================

Input:
arr = [2, 3, 4, 7, 11]
k = 5

Index:     0  1  2  3   4
arr[i]:    2  3  4  7  11
Expected:  1  2  3  4   5
Missing:   1  1  1  3   6   (arr[i] - (i + 1))

----------------------------------------------------
Initial:
low = 0
high = 4

----------------------------------------------------
Iteration 1:
mid = (0 + 4) / 2 = 2
arr[mid] = 4
missing = 4 - (2 + 1) = 1

1 < 5 → missing numbers too few
→ move right
low = mid + 1 = 3

----------------------------------------------------
Iteration 2:
low = 3, high = 4
mid = (3 + 4) / 2 = 3
arr[mid] = 7
missing = 7 - (3 + 1) = 3

3 < 5 → still too few
→ move right
low = mid + 1 = 4

----------------------------------------------------
Iteration 3:
low = 4, high = 4
mid = 4
arr[mid] = 11
missing = 11 - (4 + 1) = 6

6 >= 5 → too many / enough missing
→ move left
high = mid - 1 = 3

----------------------------------------------------
Loop ends (low > high)

low = 4

Final Answer:
kth missing number = low + k = 4 + 5 = 9

====================================================
*/

/*
🧠 KEY IDEA:
missing numbers before index i = arr[i] - (i + 1)

Binary search finds the first index where
missing >= k

⏱ Time Complexity: O(log n)
📦 Space Complexity: O(1)
*/
