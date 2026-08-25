package OA.Accenture.Strings;

// Question: Find the longest palindromic substring in a string

public class _10LongestPalindromicSubstring
{
    public static void main(String[] args)
    {
        String s = "babad";

        System.out.println(longestPalindrome(s));
    }

    static String longestPalindrome(String s)
    {
        int n = s.length();
        String max = "";

        for(int i = 0; i < n; i++)
        {
            for(int j = i; j < n; j++)
            {
                if(isValid(s, i, j))
                {
                    int len = j - i + 1;

                    if(len > max.length())
                    {
                        max = s.substring(i, j + 1);
                    }
                }
            }
        }

        return max;
    }

    static boolean isValid(String s, int left, int right)
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
}