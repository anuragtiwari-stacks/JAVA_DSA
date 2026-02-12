package _20DynamicProgramming;

// LeetCode 647

public class _28PalindromicSubstrings_BruteForec
{
    public static int countSubstrings(String s)
    {
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(isPalindrome(s,i,j))
                {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isPalindrome(String s,int l,int r)
    {
        while(l<r)
        {
            if(s.charAt(l)!=s.charAt(r))
            {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args)
    {
        String s="aaa";
        System.out.println(countSubstrings(s));
    }
}

/*
DRY RUN:

s = "aaa"
n = 3

Substrings check:

i=0
 j=0 → "a"  → palindrome → count=1
 j=1 → "aa" → palindrome → count=2
 j=2 → "aaa"→ palindrome → count=3

i=1
 j=1 → "a"  → palindrome → count=4
 j=2 → "aa" → palindrome → count=5

i=2
 j=2 → "a"  → palindrome → count=6

FINAL OUTPUT:
6
*/
