package _20DynamicProgramming;

// LeetCode 72 - Edit Distance (Forward Recursion)
public class _21EditDistance_Forward
{
    public static int minDistance(String word1, String word2)
    {
        return solve(word1, word2, 0, 0);
    }

    private static int solve(String s1, String s2, int i, int j)
    {
        int m = s1.length();
        int n = s2.length();

        // s1 finished
        // insert all remaining characters of s2
        if (i == m)
        {
            return n - j;
        }

        // s2 finished
        // delete all remaining characters of s1
        if (j == n)
        {
            return m - i;
        }

        // characters match
        if (s1.charAt(i) == s2.charAt(j))
        {
            return solve(s1, s2, i + 1, j + 1);
        }

        // operations
        int insert  = 1 + solve(s1, s2, i, j + 1);
        int delete  = 1 + solve(s1, s2, i + 1, j);
        int replace = 1 + solve(s1, s2, i + 1, j + 1);

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
==================== DRY RUN (FORWARD) ====================

word1 = "horse"
word2 = "ros"

Start:
solve(0,0)

i = 0 -> 'h'
j = 0 -> 'r'

'h' != 'r'

Three choices:

Insert:
1 + solve(0,1)

Delete:
1 + solve(1,0)

Replace:
1 + solve(1,1)

------------------------------------------------

Important meaning:

INSERT:
solve(i, j + 1)

We insert s2[j] into s1.

i stays same because original s1[i]
has not been processed yet.

j moves forward because s2[j]
has been matched using insertion.

------------------------------------------------

DELETE:
solve(i + 1, j)

We delete s1[i].

i moves forward because s1[i]
has been removed.

j stays same because s2[j]
still needs to be matched.

------------------------------------------------

REPLACE:
solve(i + 1, j + 1)

We replace s1[i] with s2[j].

Both characters are processed,
so both i and j move forward.

------------------------------------------------

MATCH:

If:

s1.charAt(i) == s2.charAt(j)

No operation required:

solve(i + 1, j + 1)

------------------------------------------------

BASE CASES:

if (i == m)
{
    return n - j;
}

s1 is finished.

Example:

s1 = "horse"
             ↑ i == m

s2 = "ros"
        ↑ j

If 2 characters remain in s2,
we need 2 INSERT operations.

Therefore:

return n - j;

------------------------------------------------

if (j == n)
{
    return m - i;
}

s2 is finished.

Any remaining characters in s1
must be DELETED.

Therefore:

return m - i;

------------------------------------------------

Answer:

minDistance("horse", "ros") = 3

One optimal transformation:

horse
↓ delete 'h'
orse
↓ delete 'r'
ose
↓ delete 'e'
os

Conceptually aligning/editing gives minimum
Edit Distance = 3.

================================================
*/