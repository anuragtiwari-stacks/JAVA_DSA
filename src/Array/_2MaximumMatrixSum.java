package Array;

// LeetCode 1975 - Maximum Matrix Sum
public class _2MaximumMatrixSum
{
    public static int maxMatrixSum(int[][] matrix)
    {
        int sum = 0;
        int negativeCount = 0;
        int minAbsValue = Integer.MAX_VALUE;

        int n = matrix.length;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int val = matrix[i][j];

                if (val < 0)
                {
                    negativeCount++;
                }

                int absVal = Math.abs(val);
                sum += absVal;

                if (absVal < minAbsValue)
                {
                    minAbsValue = absVal;
                }
            }
        }

        if (negativeCount % 2 != 0)
        {
            sum = sum - 2 * minAbsValue;
        }

        return sum;
    }

    public static void main(String[] args)
    {
        int[][] matrix1 = {
                {1, -1},
                {-1, 1}
        };

        int[][] matrix2 = {
                {-1, 2},
                {3, 4}
        };

        System.out.println(maxMatrixSum(matrix1)); // even negatives
        System.out.println(maxMatrixSum(matrix2)); // odd negatives
    }
}

/*
==================== DRY RUN ====================

CASE 1: EVEN negatives
matrix =
[
 [1, -1],
 [-1, 1]
]

abs sum = 1 + 1 + 1 + 1 = 4
negativeCount = 2 (even)
minAbsValue = 1

Answer = 4

--------------------------------
CASE 2: ODD negatives
matrix =
[
 [-1, 2],
 [ 3, 4]
]

abs sum = 1 + 2 + 3 + 4 = 10
negativeCount = 1 (odd)
minAbsValue = 1

Adjustment:
sum = 10 - 2×1 = 8

Answer = 8
*/
