package _11Sorting._2QUESTIONS;

public class _2MissingNumberCyclicSort
{

    public static int missingNumber(int[] arr)
    {
        int i = 0;

        while (i < arr.length)
        {
            int correct = arr[i];
            if (arr[i] < arr.length && arr[i] != arr[correct])
            {
                // swap arr[i] and arr[correct]
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }
            else
            {
                i++;
            }
        }

        // After sorting, check for the missing number
        for (int index = 0; index < arr.length; index++)
        {
            if (arr[index] != index)
            {
                return index;
            }
        }

        // If all indices match, then n is missing
        return arr.length;
    }

    public static void main(String[] args)
    {
        int[] arr = {3, 0, 1};
        int missing = missingNumber(arr);
        System.out.println("Missing number is: " + missing);
    }
}


/*
Initial array: [3, 0, 1]

i = 0
arr[i] = 3
arr[i] >= arr.length → skip
i = 1

arr = [3, 0, 1]

i = 1
arr[i] = 0
correct = 0
arr[1] != arr[0] → swap arr[1] and arr[0]
arr = [0, 3, 1]

i = 1
arr[i] = 3
arr[i] >= arr.length → skip
i = 2

arr = [0, 3, 1]

i = 2
arr[i] = 1
correct = 1
arr[2] != arr[1] → swap arr[2] and arr[1]
arr = [0, 1, 3]

i = 2
arr[i] = 3
arr[i] >= arr.length → skip
i = 3 → exit loop

Final sorted array: [0, 1, 3]

Check for missing number:
index = 0 → arr[0] == 0 ✅
index = 1 → arr[1] == 1 ✅
index = 2 → arr[2] == 3 ❌ → return 2

Output: 2
*/