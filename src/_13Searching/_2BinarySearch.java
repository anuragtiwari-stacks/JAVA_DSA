package _13Searching;

import java.util.Scanner;

public class _2BinarySearch
{

    public static int binarySearch(int[] arr, int target)
    {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right)
        {
            int mid = (left + right) / 2;

            if (arr[mid] == target)
            {
                return mid;
            }
            else if (arr[mid] < target)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args)
    {
        int[] arr = {5, 9, 17, 23, 25, 45, 59, 63, 71, 89}; // Sorted array

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value to search in the array: ");
        int target = sc.nextInt();
        sc.close();

        int index = binarySearch(arr, target);

        if (index != -1)
        {
            System.out.println(target + " element found at index " + index);
        }
        else
        {
            System.out.println("Element not found in the array.");
        }
    }

}
