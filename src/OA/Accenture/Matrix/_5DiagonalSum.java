package OA.Accenture.Matrix;

// Question: Find the sum of Primary and Secondary Diagonal elements

public class _5DiagonalSum
{
    public static void main(String[] args)
    {
        int[][] matrix =
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };

        diagonalSum(matrix);
    }

    static void diagonalSum(int[][] matrix)
    {
        int primarySum = 0;
        int secondarySum = 0;
        int n = matrix.length;

        for(int i = 0; i < n; i++)
        {
            // Primary Diagonal
            primarySum += matrix[i][i];

            // Secondary Diagonal
            secondarySum += matrix[i][n - 1 - i];
        }

        System.out.println("Primary Diagonal Sum: " + primarySum);
        System.out.println("Secondary Diagonal Sum: " + secondarySum);
    }
}