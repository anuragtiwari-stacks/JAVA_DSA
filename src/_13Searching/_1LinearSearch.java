package _13Searching;

import java.util.Scanner;

public class _1LinearSearch
{

    public static int linearSearch(int[] arr, int target)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == target)
            {
                return i; // Return index if found
            }
        }
        return -1; // Not found
    }

    public static void main(String[] args)
    {
        int[] arr = {12, 34, 7, 23, 56, 90, 3};

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value to search in the array: ");
        int target = sc.nextInt();
        sc.close();

        int index = linearSearch(arr, target);

        if (index != -1)
        {
            System.out.println(target + " found at index " + index);
        }
        else
        {
            System.out.println("Element not found in the array.");
        }
    }

}
