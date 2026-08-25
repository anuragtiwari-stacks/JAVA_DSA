package OA.Accenture.Arrays;

// Question: Check whether an array contains a given element

public class _22CheckElementPresent
{
    public static void main(String[] args)
    {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 30;

        System.out.println(containsElement(arr, target));
    }

    static boolean containsElement(int[] arr, int target)
    {
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == target)
            {
                return true;
            }
        }

        return false;
    }
}