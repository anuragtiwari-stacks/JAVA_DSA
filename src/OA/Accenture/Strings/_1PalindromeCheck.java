package OA.Accenture.Strings;

// Question: Check whether a given string is a palindrome

public class _1PalindromeCheck
{
    public static void main(String[] args)
    {
        String str = "madam";

        System.out.println(isPalindrome(str));
    }

    static boolean isPalindrome(String str)
    {
        int left = 0;
        int right = str.length() - 1;

        while(left < right)
        {
            if(str.charAt(left) != str.charAt(right))
            {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}