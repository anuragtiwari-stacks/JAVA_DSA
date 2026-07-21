package OA.TCS;

/*
 * Question:
 *
 * Two roads have strong ground positions represented by two arrays.
 *
 * Your task is to:
 * 1. Combine both arrays.
 * 2. Remove duplicate elements.
 * 3. Sort the unique elements in ascending order.
 * 4. Find the median of the sorted unique elements.
 *
 * Rules:
 * - If the number of elements is odd, median is the middle element.
 * - If the number of elements is even, median is the average of the
 *   two middle elements.
 *
 * Print the median with two decimal places.
 *
 * Time Complexity : O((N1 + N2) log (N1 + N2))
 * Space Complexity: O(N1 + N2)
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class BridgeConstruction
{
    public static double findMedian(int[] roadA, int[] roadB)
    {
        HashSet<Integer> set = new HashSet<>();

        // Insert Road A positions
        for(int value : roadA)
        {
            set.add(value);
        }

        // Insert Road B positions
        for(int value : roadB)
        {
            set.add(value);
        }

        // Convert HashSet to ArrayList
        ArrayList<Integer> list = new ArrayList<>(set);

        // Sort the unique elements
        Collections.sort(list);

        int size = list.size();

        // Odd number of elements
        if(size % 2 == 1)
        {
            return list.get(size / 2);
        }

        // Even number of elements
        int first = list.get((size / 2) - 1);
        int second = list.get(size / 2);

        return (first + second) / 2.0;
    }

    public static void displayArray(int[] arr)
    {
        for(int value : arr)
        {
            System.out.print(value + " ");
        }

        System.out.println();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Road A Input
        int n1 = sc.nextInt();

        int[] roadA = new int[n1];

        for(int i = 0; i < n1; i++)
        {
            roadA[i] = sc.nextInt();
        }

        // Road B Input
        int n2 = sc.nextInt();

        int[] roadB = new int[n2];

        for(int i = 0; i < n2; i++)
        {
            roadB[i] = sc.nextInt();
        }

        double median = findMedian(roadA, roadB);

        System.out.printf("%.2f\n", median);

        sc.close();
    }
}