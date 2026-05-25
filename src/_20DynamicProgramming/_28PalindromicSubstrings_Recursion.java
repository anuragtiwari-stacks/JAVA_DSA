package _20DynamicProgramming;

// LeetCode 647

public class _28PalindromicSubstrings_Recursion
{
    public static int countSubstrings(String s)
    {
        int n = s.length();

        int count = 0;

        // Generate all substrings
        for (int i = 0; i < n; i++)
        {
            for (int j = i; j < n; j++)
            {
                if (isPalindrome(s, i, j))
                {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean isPalindrome(String s, int l, int r)
    {
        if (l >= r)
        {
            return true;
        }

        if (s.charAt(l) == s.charAt(r))
        {
            return isPalindrome(s, l + 1, r - 1);
        }

        return false;
    }

    public static void main(String[] args)
    {
        String s = "aaa";

        System.out.println(countSubstrings(s));
    }
}

/*
DRY RUN:

s = "aaa"

Substrings:

"a"   -> palindrome
"aa"  -> palindrome
"aaa" -> palindrome
"a"   -> palindrome
"aa"  -> palindrome
"a"   -> palindrome

Total = 6
*/