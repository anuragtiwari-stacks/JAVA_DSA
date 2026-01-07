package _8BitManipulation._2QUESTIONS;

public class _8XorQueriesOfSubarray
{

    public static int[] xorQueries(int[] arr, int[][] queries)
    {

        int n = arr.length;
        int[] prefixXor = new int[n];

        prefixXor[0] = arr[0];

        for (int i = 1; i < n; i++)
        {
            prefixXor[i] = prefixXor[i - 1] ^ arr[i];
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++)
        {
            int left = queries[i][0];
            int right = queries[i][1];

            if (left == 0)
            {
                result[i] = prefixXor[right];
            }
            else
            {
                result[i] = prefixXor[right] ^ prefixXor[left - 1];
            }
        }

        return result;
    }

    public static void main(String[] args)
    {

        int[] arr = {1, 3, 4, 8};
        int[][] queries = {
                {0, 1},
                {1, 2},
                {0, 3},
                {3, 3}
        };

        int[] ans = xorQueries(arr, queries);

        for (int val : ans)
        {
            System.out.print(val + " ");
        }
    }

    /*
     Dry Run

     arr = [1, 3, 4, 8]

     prefixXor calculation
     prefixXor[0] = 1
     prefixXor[1] = 1 ^ 3 = 2
     prefixXor[2] = 2 ^ 4 = 6
     prefixXor[3] = 6 ^ 8 = 14

     prefixXor = [1, 2, 6, 14]

     Query 1: [0, 1]
     result = prefixXor[1] = 2

     Query 2: [1, 2]
     result = prefixXor[2] ^ prefixXor[0]
     result = 6 ^ 1 = 7

     Query 3: [0, 3]
     result = prefixXor[3] = 14

     Query 4: [3, 3]
     result = prefixXor[3] ^ prefixXor[2]
     result = 14 ^ 6 = 8

     Final Output
     [2, 7, 14, 8]
    */
}
