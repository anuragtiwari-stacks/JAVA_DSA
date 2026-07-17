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
 * Example:
 *
 * Road A = {3, 5, 2}
 * Road B = {1, 2, 3}
 *
 * Combined = {3,5,2,1,2,3}
 * Unique   = {1,2,3,5}
 *
 * Median = (2 + 3) / 2 = 2.50
 *
 * Output:
 * 2.50
 *
 * Time Complexity : O((N1 + N2) log (N1 + N2))
 * Space Complexity: O(N1 + N2)
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

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
        // Predefined Input

        int[] roadA =
                {
                        3, 5, 2
                };

        int[] roadB =
                {
                        1, 2, 3
                };

        System.out.print("Road A Positions : ");
        displayArray(roadA);

        System.out.print("Road B Positions : ");
        displayArray(roadB);

        System.out.println();

        double median = findMedian(roadA, roadB);

        System.out.printf("Median = %.2f\n", median);
    }
}