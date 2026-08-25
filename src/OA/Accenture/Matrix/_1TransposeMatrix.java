package OA.Accenture.Matrix;

// Question: Find the transpose of a matrix

public class _1TransposeMatrix
{
    public static void main(String[] args)
    {
        int[][] matrix =
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };

        transpose(matrix);
    }

    static void transpose(int[][] matrix)
    {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[cols][rows];

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                result[j][i] = matrix[i][j];
            }
        }

        for(int i = 0; i < result.length; i++)
        {
            for(int j = 0; j < result[0].length; j++)
            {
                System.out.print(result[i][j] + " ");
            }

            System.out.println();
        }
    }
}