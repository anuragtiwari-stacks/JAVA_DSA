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
        StringBuilder sb = new StringBuilder(str);

        String reverse = sb.reverse().toString();

        return str.equals(reverse);
    }
}