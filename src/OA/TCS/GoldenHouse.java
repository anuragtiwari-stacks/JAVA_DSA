package OA.TCS;

/*
 * Question:
 *
 * There are N rooms in a golden house.
 * Each room contains some gold coins.
 *
 * You have to choose a starting room and an ending room such that
 * the total number of coins collected from the continuous sequence
 * of rooms is exactly K.
 *
 * If multiple solutions exist, print the one having the smaller
 * starting room number.
 *
 * Room numbers start from 1.
 *
 * Example:
 *
 * N = 10
 * K = 15
 *
 * Coins = {5, 3, 7, 14, 18, 1, 18, 4, 8, 3}
 *
 * Output:
 * 1 3
 *
 * Explanation:
 * Rooms 1 to 3 => 5 + 3 + 7 = 15
 * Rooms 8 to 10 => 4 + 8 + 3 = 15
 *
 * Since (1,3) has the smaller starting room number,
 * the answer is:
 * 1 3
 *
 * Approach:
 * Sliding Window (Two Pointer)
 *
 * Time Complexity : O(N)
 * Space Complexity: O(1)
 */

public class GoldenHouse
{
    public static void findRooms(int[] coins, int target)
    {
        int start = 0;
        int sum = 0;

        for(int end = 0; end < coins.length; end++)
        {
            sum += coins[end];

            while(sum > target)
            {
                sum -= coins[start];
                start++;
            }

            if(sum == target)
            {
                // +1 because room numbering starts from 1
                System.out.println("Starting Room : " + (start + 1));
                System.out.println("Ending Room   : " + (end + 1));
                return;
            }
        }
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
        int K = 15;

        int[] coins =
                {
                        5, 3, 7, 14, 18, 1, 18, 4, 8, 3
                };

        System.out.println("Number of Rooms : " + N);
        System.out.println("Target Coins    : " + K);

        System.out.println();

        System.out.print("Coins in Rooms  : ");
        displayArray(coins);

        System.out.println();

        findRooms(coins, K);
    }
}