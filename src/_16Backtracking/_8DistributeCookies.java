package _16Backtracking;

// LeetCode 2305: Fair Distribution of Cookies
import java.util.*;

public class _8DistributeCookies
{
    int result = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k)
    {
        int[] children = new int[k];
        backtrack(cookies, 0, children, k);
        return result;
    }

    public void backtrack(int[] cookies, int idx, int[] children, int k)
    {
        if (idx == cookies.length)
        {
            int max = 0;
            for (int c : children)
            {
                max = Math.max(max, c);
            }
            result = Math.min(result, max);
            return;
        }

        for (int i = 0; i < k; i++)
        {
            children[i] = children[i] + cookies[idx];   // choose

            if (children[i] < result)                   // pruning
            {
                backtrack(cookies, idx + 1, children, k);
            }

            children[i] = children[i] - cookies[idx];   // unchoose
        }
    }

    public static void main(String[] args)
    {
        _8DistributeCookies obj = new _8DistributeCookies();

        int[] cookies = {8, 15, 10, 20, 8};
        int k = 2;

        System.out.println(obj.distributeCookies(cookies, k));
    }
}

/*
---------------- DRY RUN ----------------

cookies = [8, 15, 10, 20, 8]
k = 2

children = [0,0]

Assign 8:
children = [8,0]

Assign 15:
children = [23,0]

Assign 10:
children = [33,0]

Assign 20:
children = [53,0]

Assign 8:
children = [61,0]
max = 61 → result = 61

Backtracking tries other distributions:
[8,15,10,20,8] → split as
child1 = 31, child2 = 30

max = 31 → result updated

Final Answer:
31

----------------------------------------
*/
