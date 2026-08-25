package OA.Accenture.Numbers;

// Question: Print every palindromic number that lies between two given limits

public class _17PalindromicNumbersInRange
{
    public static void main(String[] args)
    {
        int a = 10;
        int b = 200;

        printPalindromes(a, b);
    }

    static void printPalindromes(int a, int b)
    {
        for(int i = a; i <= b; i++)
        {
            if(isPalindrome(i))
            {
                System.out.print(i + " ");
            }
        }
    }

    static boolean isPalindrome(int n)
    {
        String str = String.valueOf(n);

        String reverse = new StringBuilder(str).reverse().toString();

        return str.equals(reverse);
    }
}