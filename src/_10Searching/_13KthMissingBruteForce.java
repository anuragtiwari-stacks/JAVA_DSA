package _10Searching;

public class _13KthMissingBruteForce
{

    public static int findKthPositive(int[] arr, int k)
    {
        int count = 0;
        int current = 1;
        int index = 0;

        while (true)
        {
            if (index < arr.length && arr[index] == current)
            {
                index++; // current exists in array
            }
            else
            {
                count++; // current is missing
                if (count == k)
                {
                    return current;
                }
            }
            current++;
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        System.out.println("The " + k + "th missing number is: " + findKthPositive(arr, k)); // Output: 9
    }
}

/*
🔍 Concept:
Iterate from 1 upwards and check if the number is in the array.
If it is missing, increase the missing count.
Once count == k, return that number.

🧠 Time Complexity: O(k + n)
📦 Space Complexity: O(1)
*/
