package OA.Accenture.Arrays;
// Question: Find the first and last occurrence of an element in a sorted array

import java.util.*;

public class _24FirstAndLastOccurrence
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;

        findFirstAndLast(arr, target);
    }

    static void findFirstAndLast(int[] arr, int target)
    {
        HashMap<Integer,Integer> map = new HashMap<>();

        int first = -1;
        int last = -1;

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==target)
            {
                if(!map.containsKey(target))
                {
                    map.put(arr[i],i);
                    first = i;
                }
                map.put(arr[i],i);
                last = i;
            }
        }
        System.out.println("First Occurence: "+first);
        System.out.println("Last Occurence: "+last);
    }
}