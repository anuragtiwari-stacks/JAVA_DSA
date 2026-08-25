package OA.Accenture.Arrays;

// Question: Count how many times a given element occurs in an array

public class _21CountElementOccurrences
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 2, 4, 2, 5};
        int target = 2;

        System.out.println(countOccurrences(arr, target));
    }

    static int countOccurrences(int[] arr, int target)
    {
        int count = 0;

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == target)
            {
                count++;
            }
        }

        return count;
    }
}