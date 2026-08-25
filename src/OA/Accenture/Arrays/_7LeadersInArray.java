package OA.Accenture.Arrays;

// Question: Find the leaders in an array (elements greater than all elements to their right)

public class _7LeadersInArray
{
    public static void main(String[] args)
    {
        int[] arr = {16, 17, 4, 3, 5, 2};

        findLeaders(arr);
    }

    static void findLeaders(int[] arr)
    {
        int max = Integer.MIN_VALUE;

        for(int i = arr.length - 1; i >= 0; i--)
        {
            if(arr[i] > max)
            {
                System.out.print(arr[i] + " ");
                max = arr[i];
            }
        }
    }
}