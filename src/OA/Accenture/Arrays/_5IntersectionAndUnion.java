package OA.Accenture.Arrays;

// Question: Find the intersection and union of two arrays

import java.util.HashSet;
import java.util.Set;

public class _5IntersectionAndUnion
{
    public static void main(String[] args)
    {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};

        findIntersection(arr1, arr2);
        findUnion(arr1, arr2);
    }

    static void findIntersection(int[] arr1, int[] arr2)
    {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int i = 0; i < arr1.length; i++)
        {
            set1.add(arr1[i]);
        }

        for(int i = 0; i < arr2.length; i++)
        {
            if(set1.contains(arr2[i]))
            {
                set2.add(arr2[i]);
            }
        }

        System.out.println("Intersection: " + set2);
    }

    static void findUnion(int[] arr1, int[] arr2)
    {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < arr1.length; i++)
        {
            set.add(arr1[i]);
        }

        for(int i = 0; i < arr2.length; i++)
        {
            set.add(arr2[i]);
        }

        System.out.println("Union: " + set);
    }
}