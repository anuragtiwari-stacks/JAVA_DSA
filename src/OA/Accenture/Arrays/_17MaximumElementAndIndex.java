package OA.Accenture.Arrays;

// Question: Find the maximum element in an array and print its value along with its index

public class _17MaximumElementAndIndex
{
    public static void main(String[] args)
    {
        int[] arr = {10, 25, 7, 40, 18};

        findMaximum(arr);
    }

    static void findMaximum(int[] arr)
    {
        int max = Integer.MIN_VALUE;
        int index = -1;

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
                index = i;
            }
        }

        System.out.println("Maximum = " + max);
        System.out.println("Index = " + index);
    }
}