// LeetCode 44. Wildcard Matching

package _20DynamicProgramming;

public class _42WildcardMatching_Recursion
{
    public static void main(String[] args)
    {
        // Example 1
        String s1 = "abdefcd";
        String p1 = "ab*cd";

        System.out.println(isMatch(s1, p1));


        // Example 2
        String s2 = "abcd";
        String p2 = "ab*cd";

        System.out.println(isMatch(s2, p2));
    }

    public static boolean isMatch(String s, String p)
    {
        return solve(s, p, 0, 0);
    }

    public static boolean solve(String s, String p, int i, int j)
    {
        if(i == s.length() && j == p.length())
        {
            return true;
        }

        if(j == p.length())
        {
            return false;
        }

        if(i == s.length())
        {
            while(j < p.length())
            {
                if(p.charAt(j) != '*')
                {
                    return false;
                }

                j++;
            }

            return true;
        }

        char sc = s.charAt(i);
        char pc = p.charAt(j);

        if(pc == sc || pc == '?')
        {
            return solve(s, p, i + 1, j + 1);
        }

        if(pc == '*')
        {
            boolean skip = solve(s, p, i, j + 1);

            boolean pick = solve(s, p, i + 1, j);

            return skip || pick;
        }

        return false;
    }
}