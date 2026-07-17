package OA.TCS;

/*
 * Question:
 *
 * You are given an array A of size N.
 * A fair sequence is a subsequence in which consecutive elements
 * alternate in sign.
 *
 * Examples:
 * Positive -> Negative -> Positive -> Negative
 * OR
 * Negative -> Positive -> Negative -> Positive
 *
 * Your task is to select a fair subsequence such that:
 * 1. The subsequence has the maximum possible length.
 * 2. Among all such subsequences, the sum of elements is maximum.
 *
 * Example 1:
 * Input:
 * A = {21, 12, 13, -21, -2}
 *
 * Output:
 * 19
 *
 * Explanation:
 * Maximum fair subsequence length = 2
 * Best subsequence = {21, -2}
 * Sum = 19
 *
 * Example 2:
 * Input:
 * A = {-1, 18, 13, -7, -2, 7, -1, 11}
 *
 * Output:
 * 32
 *
 * Explanation:
 * Groups:
 * {-1}
 * {18,13}
 * {-7,-2}
 * {7}
 * {-1}
 * {11}
 *
 * Pick the maximum element from every group:
 * -1 + 18 + (-2) + 7 + (-1) + 11 = 32
 *
 * Approach:
 * Traverse the array.
 * Consecutive elements having the same sign belong to one group.
 * Select the maximum element from every group.
 *
 * Time Complexity : O(N)
 * Space Complexity: O(1)
 */

public class FairSequenceMaximumSum
{
    public static boolean isSameSign(int a, int b)
    {
        return (a > 0 && b > 0) || (a < 0 && b < 0);
    }

    public static int maximumFairSequenceSum(int[] arr)
    {
        int currentMaximum = arr[0];
        int answer = 0;

        for(int i = 1; i < arr.length; i++)
        {
            if(isSameSign(currentMaximum, arr[i]))
            {
                currentMaximum = Math.max(currentMaximum, arr[i]);
            }
            else
            {
                answer += currentMaximum;
                currentMaximum = arr[i];
            }
        }

        answer += currentMaximum;

        return answer;
    }

    public static void displayArray(int[] arr)
    {
        for(int value : arr)
        {
            System.out.print(value + " ");
        }

        System.out.println();
    }

    public static void main(String[] args)
    {
        // Predefined Input

        int[] arr =
                {
                        21, 12, 13, -21, -2
                };

        // Uncomment to test another example

        /*
        int[] arr =
        {
            -1, 18, 13, -7, -2, 7, -1, 11
        };
        */

        System.out.println("Array:");

        displayArray(arr);

        System.out.println("Maximum Fair Sequence Sum:");

        System.out.println(maximumFairSequenceSum(arr));
    }
}