package OA.TCS;

/*
 * Question:
 *
 * Alice and her friends are playing a verbal Kho-Kho game.
 *
 * Alice gives a digit to the first friend.
 * Each friend passes the understood digit to the next friend.
 *
 * Finally, Alice checks the digit written by the last friend.
 *
 * If at any point two consecutive friends have different digits,
 * then either:
 * 1. The previous friend enacted incorrectly.
 * OR
 * 2. The current friend understood incorrectly.
 *
 * Therefore, both friends are considered incorrect.
 *
 * Given the array D[] representing the digit understood by each friend,
 * find the number of unique friends who have not enacted well OR
 * have not understood correctly.
 *
 * Example:
 *
 * Input:
 * N = 5
 * D = {1, 2, 3, 2, 2}
 *
 * Output:
 * 4
 *
 * Explanation:
 * Compare adjacent friends:
 *
 * 1 != 2  -> Friend 1 and Friend 2 are incorrect
 * 2 != 3  -> Friend 2 and Friend 3 are incorrect
 * 3 != 2  -> Friend 3 and Friend 4 are incorrect
 * 2 == 2  -> No problem
 *
 * Incorrect Friends:
 * F1, F2, F3, F4
 *
 * Answer = 4
 *
 * Time Complexity : O(N)
 * Space Complexity: O(N)
 */

public class VerbalKhoKho
{
    public static int countIncorrectFriends(int[] digits)
    {
        int n = digits.length;

        boolean[] wrong = new boolean[n];

        for(int i = 1; i < n; i++)
        {
            if(digits[i] != digits[i - 1])
            {
                wrong[i - 1] = true;
                wrong[i] = true;
            }
        }

        int count = 0;

        for(boolean friend : wrong)
        {
            if(friend)
            {
                count++;
            }
        }

        return count;
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

        int[] digits =
                {
                        1, 2, 3, 2, 2
                };

        // Uncomment to test another example

        /*
        int[] digits =
        {
            4, 4, 4
        };
        */

        System.out.println("Digits Understood by Friends:");

        displayArray(digits);

        int answer = countIncorrectFriends(digits);

        System.out.println("Incorrect Friends = " + answer);
    }
}