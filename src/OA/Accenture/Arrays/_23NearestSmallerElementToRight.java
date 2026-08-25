package OA.Accenture.Arrays;

// Question: Replace every array element with the nearest smaller element to its right (-1 if none exists)

import java.util.Arrays;

public class _23NearestSmallerElementToRight
{
    public static void main(String[] args)
    {
        int[] arr = {4, 5, 2, 10, 8};

        System.out.println(Arrays.toString(findNearestSmaller(arr)));
    }

    static int[] findNearestSmaller(int[] arr)
    {
        int[] result = new int[arr.length];

        for(int i = 0; i < arr.length; i++)
        {
            result[i] = -1;

            for(int j = i + 1; j < arr.length; j++)
            {
                if(arr[j] < arr[i])
                {
                    result[i] = arr[j];
                    break;
                }
            }
        }

        return result;
    }
}