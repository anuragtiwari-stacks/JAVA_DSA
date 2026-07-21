package OA.TCS;

/*
 * TCS NQT - Absent Number Function
 *
 * Generate all subsequences using Recursion.
 * For every subsequence, find the smallest
 * missing positive integer (MEX).
 *
 * Time Complexity : O(2^N × N)
 * Space Complexity: O(N)
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class AbsentNumberFunction
{
    static final int MOD = 1000000007;
    static long answer = 0;

    public static int absentNumber(ArrayList<Integer> list)
    {
        HashSet<Integer> set = new HashSet<>();

        for(int num : list)
        {
            if(num > 0)
            {
                set.add(num);
            }
        }

        int mex = 1;

        while(set.contains(mex))
        {
            mex++;
        }

        return mex;
    }

    public static void generateSubsequences(int[] arr, int index, ArrayList<Integer> current)
    {
        // Base Case
        if(index == arr.length)
        {
            answer = (answer + absentNumber(current)) % MOD;
            return;
        }

        // Include current element
        current.add(arr[index]);
        generateSubsequences(arr, index + 1, current);

        // Backtrack
        current.remove(current.size() - 1);

        // Exclude current element
        generateSubsequences(arr, index + 1, current);
    }

    public static long solve(int[] arr)
    {
        answer = 0;

        generateSubsequences(arr, 0, new ArrayList<>());

        return answer;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        System.out.println(solve(arr));

        sc.close();
    }
}