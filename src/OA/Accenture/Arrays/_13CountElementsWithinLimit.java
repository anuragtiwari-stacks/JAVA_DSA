package OA.Accenture.Arrays;

// Question: Count array elements whose absolute difference from a target number is within a given limit

public class _13CountElementsWithinLimit
{
    public static void main(String[] args)
    {
        int[] arr = {7, 8, 10, 12, 15, 5};

        int target = 10;
        int limit = 3;

        System.out.println(countElements(arr, target, limit));
    }

    static int countElements(int[] arr, int target, int limit)
    {
        int[] diff = new int[arr.length];

        for(int i = 0; i < arr.length; i++)
        {
            diff[i] = Math.abs(arr[i] - target);
        }

        int count = 0;

        for(int i = 0; i < diff.length; i++)
        {
            if(diff[i] <= limit)
            {
                count++;
            }
        }

        return count;
    }
}