package _1Array;

import java.util.Arrays;

// LeetCode 455
public class _20AssignCookies
{

    public static void main(String[] args)
    {
        _20AssignCookies obj = new _20AssignCookies();

        int[] g = {1, 2, 3};
        int[] s = {1, 1};

        int result = obj.findContentChildren(g, s);

        System.out.println(result);
    }

    public int findContentChildren(int[] g, int[] s)
    {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        int count = 0;

        while (i < g.length && j < s.length)
        {
            if (s[j] >= g[i])
            {
                count = count + 1;
                i = i + 1;
                j = j + 1;
            }
            else
            {
                j = j + 1;
            }
        }

        return count;
    }
}

/*
Dry Run:

Input:
g = {1, 2, 3}
s = {1, 1}

After Sorting:
g = {1, 2, 3}
s = {1, 1}

i = 0, j = 0
s[0] >= g[0] → 1 >= 1 → count = 1 → i = 1, j = 1

i = 1, j = 1
s[1] >= g[1] → 1 >= 2 → false → j = 2

Loop ends (j == s.length)

Return 1

Output: 1
*/
