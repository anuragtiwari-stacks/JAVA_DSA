package OA.TCS;

/*
 * Reconstructed Problem
 * ---------------------
 * Given an N x N matrix and a tolerance value P.
 *
 * You may rearrange all the elements of the matrix in any order.
 *
 * For every row:
 * 1. Sort the row.
 * 2. Median = element at position (N+1)/2 (1-based indexing).
 *
 * A rearrangement is valid only if:
 * Sum of all row medians <= P
 *
 * Among all valid rearrangements, print the maximum possible
 * minimum row median.
 *
 * If no valid rearrangement exists, print -1.
 *
 * ----------------------------------------------------------
 * NOTE:
 * This is a reconstructed solution because the original
 * TCS statement is ambiguous/incomplete.
 *
 * Time Complexity : O(N² log(N²))
 * Space Complexity: O(N²)
 */

import java.util.Arrays;

public class GoldenStoreRoom
{
    public static int maximumMinimumMedian(int[][] matrix, int p)
    {
        int n = matrix.length;

        int[] values = new int[n * n];

        int index = 0;

        // Convert 2-D matrix into 1-D array
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                values[index++] = matrix[i][j];
            }
        }

        // Sort all values
        Arrays.sort(values);

        /*
         * Rearrange into rows:
         *
         * Row1 -> first N elements
         * Row2 -> next N elements
         * ...
         */

        int medianIndex = (n - 1) / 2;

        int sumOfMedians = 0;
        int minimumMedian = Integer.MAX_VALUE;

        for(int row = 0; row < n; row++)
        {
            int median = values[row * n + medianIndex];

            sumOfMedians += median;

            minimumMedian = Math.min(minimumMedian, median);
        }

        if(sumOfMedians > p)
        {
            return -1;
        }

        return minimumMedian;
    }

    public static void printMatrix(int[][] matrix)
    {
        for(int[] row : matrix)
        {
            for(int value : row)
            {
                System.out.print(value + " ");
            }

            System.out.println();
        }
    }

    public static void dryRun(int[][] matrix, int p)
    {
        int n = matrix.length;

        int[] values = new int[n * n];

        int index = 0;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                values[index++] = matrix[i][j];
            }
        }

        Arrays.sort(values);

        System.out.println("\nAfter Sorting:");

        for(int value : values)
        {
            System.out.print(value + " ");
        }

        System.out.println("\n");

        int medianIndex = (n - 1) / 2;

        int sum = 0;

        System.out.println("Row Wise Medians:");

        for(int row = 0; row < n; row++)
        {
            System.out.print("Row " + (row + 1) + " : ");

            for(int col = 0; col < n; col++)
            {
                System.out.print(values[row * n + col] + " ");
            }

            int median = values[row * n + medianIndex];

            sum += median;

            System.out.println(" -> Median = " + median);
        }

        System.out.println();

        System.out.println("Sum Of Medians = " + sum);

        if(sum <= p)
        {
            System.out.println("Valid Rearrangement");
        }
        else
        {
            System.out.println("Invalid Rearrangement");
        }
    }

    public static void main(String[] args)
    {
        // Predefined Input

        int[][] matrix =
                {
                        {34, 77, 72, 65},
                        {49, 70, 71, 15},
                        {12, 84, 5, 78},
                        {74, 1, 26, 60}
                };

        int P = 198;

        System.out.println("Original Matrix:\n");

        printMatrix(matrix);

        dryRun(matrix, P);

        int answer = maximumMinimumMedian(matrix, P);

        System.out.println();

        System.out.println("Answer = " + answer);
    }
}