package _20DynamicProgramming;

// LeetCode 72 - Edit Distance (Backward Recursion)
public class _21EditDistance_Forward
{
    public static int minDistance(String word1, String word2)
    {
        return solve(word1, word2,
                word1.length() - 1,
                word2.length() - 1);
    }

    private static int solve(String s1, String s2, int i, int j)
    {
        // base cases
        if (i < 0)
        {
            return j + 1;   // insert remaining characters of s2
        }

        if (j < 0)
        {
            return i + 1;   // delete remaining characters of s1
        }

        // characters match
        if (s1.charAt(i) == s2.charAt(j))
        {
            return solve(s1, s2, i - 1, j - 1);
        }

        // operations
        int insert  = 1 + solve(s1, s2, i, j - 1);
        int delete  = 1 + solve(s1, s2, i - 1, j);
        int replace = 1 + solve(s1, s2, i - 1, j - 1);

        return Math.min(insert, Math.min(delete, replace));
    }

    public static void main(String[] args)
    {
        String word1 = "horse";
        String word2 = "ros";

        System.out.println(minDistance(word1, word2));
    }
}

/*
==================== DRY RUN (BACKWARD) ====================

word1 = "horse"
word2 = "ros"

Start:
solve(4,2) -> e vs s (not equal)

Operations:
Insert  -> 1 + solve(4,1)
Delete  -> 1 + solve(3,2)
Replace -> 1 + solve(3,1)

-----------------------------------------------
solve(3,1) -> s vs o (not equal)

Insert  -> 1 + solve(3,0)
Delete  -> 1 + solve(2,1)
Replace -> 1 + solve(2,0)

-----------------------------------------------
Eventually best path:

horse → hors   (delete e)
hors  → hor    (delete s)
hor   → or     (delete h)
or    → ror    (insert r)
ror   → ros    (replace r → s)

Minimum Edit Distance = 3
================================================
*/
