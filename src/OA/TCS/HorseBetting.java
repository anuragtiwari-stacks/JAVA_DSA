package OA.TCS;

/*
 * Question:
 *
 * Bob wants to bet on a continuous sequence of horses.
 *
 * Each horse has a betting price.
 * Bob has reward money K.
 *
 * He wants to choose the longest continuous sequence of horses
 * such that the total betting price is strictly less than K.
 *
 * If multiple sequences have the same maximum length,
 * any one of them can be chosen.
 *
 * Example 1:
 *
 * N = 10
 * K = 100
 *
 * Price = {30, 40, 50, 20, 20, 10, 90, 10, 10, 10}
 *
 * Output:
 * 3
 *
 * Explanation:
 * Longest valid sequences are:
 * {50, 20, 20} -> Sum = 90
 * {10, 10, 10} -> Sum = 30
 *
 * Maximum Length = 3
 *
 * Approach:
 * Sliding Window (Two Pointer)
 *
 * Time Complexity : O(N)
 * Space Complexity: O(1)
 */

public class HorseBetting
{
    public static int maximumLength(int[] price, int k)
    {
        int start = 0;
        int sum = 0;
        int maxLength = 0;

        for(int end = 0; end < price.length; end++)
        {
            sum += price[end];

            while(sum >= k)
            {
                sum -= price[start];
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
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

        int N = 10;
        int K = 100;

        int[] price =
                {
                        30, 40, 50, 20, 20, 10, 90, 10, 10, 10
                };

        /*
        // Example 2

        int N = 10;
        int K = 100;

        int[] price =
        {
            10, 90, 80, 20, 90, 60, 40, 60, 70, 75
        };
        */

        System.out.println("Number of Horses : " + N);
        System.out.println("Reward Money     : " + K);

        System.out.println();

        System.out.print("Betting Prices   : ");
        displayArray(price);

        System.out.println();

        System.out.println("Maximum Length = " + maximumLength(price, K));
    }
}