package OA.Accenture.Matrix;

// Question: Find the sum of the diagonal elements of a matrix

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

        System.out.println(diagonalSum(matrix));
    }

    static int diagonalSum(int[][] matrix)
    {
        int sum = 0;
        int n = matrix.length;

        for(int i = 0; i < n; i++)
        {
            sum += matrix[i][i];

            if(i != n - 1 - i)
            {
                sum += matrix[i][n - 1 - i];
            }
        }

        return sum;
    }
}