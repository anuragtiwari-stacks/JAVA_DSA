package _20DynamicProgramming;

public class _30LongestPalindromicSubstring
{
    public static String longestPalindrome(String s)
    {
        int n = s.length();

        String longest = "";

        for(int i = 0; i < n; i++)
        {
            for(int j = i; j < n; j++)
            {
                if(isValidPalindrome(s, i, j))
                {
                    if(j - i + 1 > longest.length())
                    {
                        longest = s.substring(i, j + 1);
                    }
                }
            }
        }

        return longest;
    }

    public static boolean isValidPalindrome(String s, int left, int right)
    {
        while(left < right)
        {
            if(s.charAt(left) != s.charAt(right))
            {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args)
    {
        String s = "babad";

        System.out.println(longestPalindrome(s));
    }
}