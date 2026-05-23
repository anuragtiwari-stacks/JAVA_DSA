package _20DynamicProgramming;

// LeetCode 583 - Delete Operation for Two Strings (Recursion)
public class _26DeleteOperation
{
    public static int minDistance(String word1, String word2)
    {
        return solve(word1, word2, word1.length() - 1, word2.length() - 1);
    }

    private static int solve(String s1, String s2, int i, int j)
    {
        // If s1 finished
        if (i < 0)
        {
            return j + 1;
        }

        // If s2 finished
        if (j < 0)
        {
            return i + 1;
        }

        // Characters match
        if (s1.charAt(i) == s2.charAt(j))
        {
            return solve(s1, s2, i - 1, j - 1);
        }

        // Delete from s1
        int deleteFromS1 = 1 + solve(s1, s2, i - 1, j);

        // Delete from s2
        int deleteFromS2 = 1 + solve(s1, s2, i, j - 1);

        return Math.min(deleteFromS1, deleteFromS2);
    }

    public static void main(String[] args)
    {
        String word1 = "sea";
        String word2 = "eat";

        System.out.println(minDistance(word1, word2));
    }
}

/*
==================== DRY RUN ====================

word1 = "sea"
word2 = "eat"

solve(2,2)
a vs t -> not equal

Option 1:
Delete from s1
1 + solve(1,2)

Option 2:
Delete from s2
1 + solve(2,1)

---------------------------------------

solve(2,1)
a vs a -> equal

solve(1,0)

e vs e -> equal

solve(0,-1)

j < 0
return i + 1
return 1

---------------------------------------

Minimum deletions = 2

Delete 's' from "sea"
Delete 't' from "eat"

Both become:
"ea"

=================================================
*/