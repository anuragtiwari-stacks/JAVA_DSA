package OA.Accenture.Matrix;

// Question: Print a matrix in spiral order

public class _2SpiralMatrix
{
    public static void main(String[] args)
    {
        int[][] matrix =
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };

        printSpiral(matrix);
    }

    static void printSpiral(int[][] matrix)
    {
        int minR = 0;
        int maxR = matrix.length - 1;
        int minC = 0;
        int maxC = matrix[0].length - 1;

        while(minR <= maxR && minC <= maxC)
        {
            // Left -> Right
            for(int i = minC; i <= maxC; i++)
            {
                System.out.print(matrix[minR][i] + " ");
            }

            minR++;

            // Top -> Bottom
            for(int i = minR; i <= maxR; i++)
            {
                System.out.print(matrix[i][maxC] + " ");
            }

            maxC--;

            // Right -> Left
            if(minR <= maxR)
            {
                for(int i = maxC; i >= minC; i--)
                {
                    System.out.print(matrix[maxR][i] + " ");
                }

                maxR--;
            }

            // Bottom -> Top
            if(minC <= maxC)
            {
                for(int i = maxR; i >= minR; i--)
                {
                    System.out.print(matrix[i][minC] + " ");
                }

                minC++;
            }
        }
    }
}