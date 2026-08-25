package OA.Accenture.Arrays;

// Question: Find all duplicate elements in an array

import java.util.HashSet;
import java.util.Set;

public class _4FindAllDuplicates
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 2, 4, 5, 1, 6, 3};

        findDuplicates(arr);
    }

    static void findDuplicates(int[] arr)
    {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < arr.length; i++)
        {
            if(set.contains(arr[i]))
            {
                System.out.println(arr[i]);
            }
            else
            {
                set.add(arr[i]);
            }
        }
    }
}