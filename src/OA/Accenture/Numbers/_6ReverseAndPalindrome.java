package OA.Accenture.Numbers;

// Question: Reverse the digits of an integer and check if it is a palindrome number

public class _6ReverseAndPalindrome
{
    public static void main(String[] args)
    {
        int n = 121;

        System.out.println(isPalindrome(n));
    }

    static boolean isPalindrome(int n)
    {
        int original = n;
        int reverse = 0;

        while(n > 0)
        {
            int digit = n % 10;
            reverse = reverse * 10 + digit;
            n /= 10;
        }

        return original == reverse;
    }
}