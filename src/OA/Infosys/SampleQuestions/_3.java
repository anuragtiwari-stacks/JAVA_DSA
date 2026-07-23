package OA.Infosys.SampleQuestions;

import java.util.*;

class Main3
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];

        for(int i = 0; i < n; i++)
        {
            a[i] = sc.nextInt();
        }

        int ans = solve(0, -1, 0, 0, a, n, m);

        System.out.println(ans);
    }

    public static int solve(int i, int prevIndex, int xor, int length, int[] a, int n, int m)
    {
        if(i == n && length > 0 && xor >= m)
        {
            return length;
        }

        if(i == n)
        {
            return 0;
        }

        // Skip current element
        int skip = solve(i + 1, prevIndex, xor, length, a, n, m);

        // Take current element
        int take = 0;

        if(prevIndex == -1 || a[prevIndex] <= a[i])
        {
            take = solve(i + 1, i, xor ^ a[i], length + 1, a, n, m);
        }

        return Math.max(take, skip);
    }
}