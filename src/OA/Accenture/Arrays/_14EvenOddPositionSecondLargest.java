package OA.Accenture.Arrays;

// Question: Split an array into even-position and odd-position sub-arrays, sort each, and sum the 2nd-largest element of both

import java.util.ArrayList;
import java.util.Collections;

public class _14EvenOddPositionSecondLargest
{
    public static void main(String[] args)
    {
        int[] arr = {3, 2, 1, 7, 5, 4, 6};

        System.out.println(findSum(arr));
    }

    static int findSum(int[] arr)
    {
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();

        for(int i = 0; i < arr.length; i++)
        {
            if(i % 2 == 0)
            {
                even.add(arr[i]);
            }
            else
            {
                odd.add(arr[i]);
            }
        }

        Collections.sort(even);
        Collections.sort(odd);

        int secondLargestEven = even.get(even.size() - 2);
        int secondLargestOdd = odd.get(odd.size() - 2);

        return secondLargestEven + secondLargestOdd;
    }
}